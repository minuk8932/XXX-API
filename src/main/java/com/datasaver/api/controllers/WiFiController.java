package com.datasaver.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasaver.api.controllers.forms.AddWiFiConnectionLogForm;
import com.datasaver.api.controllers.forms.AddWiFiForm;
import com.datasaver.api.controllers.forms.RequestForm;
import com.datasaver.api.controllers.forms.ResponseForm;
import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.domains.User;
import com.datasaver.api.domains.WiFi;
import com.datasaver.api.domains.WiFiConnectionLog;
import com.datasaver.api.payloads.WiFiRequestPayload;
import com.datasaver.api.payloads.WiFiRequestResultPayload;
import com.datasaver.api.services.PushMessageService;
import com.datasaver.api.services.UserService;
import com.datasaver.api.services.WiFiConnectionLogService;
import com.datasaver.api.services.WiFiService;
import com.datasaver.api.utils.auth.Auth;
import com.datasaver.api.utils.log.ControllerLog;
import com.datasaver.api.utils.res.Strings;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("wifi")
@Api
public class WiFiController {
	@Autowired
	private WiFiService ws;

	@Autowired
	private UserService us;

	@Autowired
	private WiFiConnectionLogService wcls;

	@Autowired
	private PushMessageService pms;

	@PostMapping("")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> AddWiFi(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddWiFiForm awf) {
		WiFi w = new WiFi();
		w.setSsid(awf.getSsid());
		w.setMac(awf.getMac());
		w.setPassword(awf.getPassword());
		w.setAuthType(awf.getAuthType());
		w.setChannel(awf.getChannel());
		w.setLongitude(awf.getLongitude());
		w.setLatitude(awf.getLatitude());
		w.setUser(u);
		ws.save(w);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/log/Connection")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addWiFiConnectionLog(
			@RequestHeader("Authorization") String token, @ApiIgnore User u,
			@RequestBody AddWiFiConnectionLogForm awclf) {
		WiFi w = ws.findByMac(awclf.getMac());

		if (w == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_WIFI);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		WiFiConnectionLog.Type t = awclf.getType();

		if (t == WiFiConnectionLog.Type.CONNECT) {
			w.setSsid(awclf.getSsid());
			w.setPassword(awclf.getPassword());
			w.setAuthType(awclf.getAuthType());
			w.setChannel(awclf.getChannel());
			w.setLongitude(awclf.getLongitude());
			w.setLatitude(awclf.getLatitude());
			w.setUser(u);
			ws.save(w);
		}

		WiFiConnectionLog wcl = new WiFiConnectionLog();
		wcl.setType(awclf.getType());
		wcl.setWifi(w);
		wcls.save(wcl);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("/my/list")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> getMyWiFiList(@RequestHeader("Authorization") String token,
			@ApiIgnore User u) {
		DefaultResponse dr = new DefaultResponse(ws.findMyListByUser(u));
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("/friend/{idx}/list")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> getFriendWiFiList(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("idx") long idx) {
		if (!us.isFriend(u.getIdx(), idx)) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.ONLY_FRIEND_RELATION_CAN_GET_INFO);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.UNAUTHORIZED);
		}

		DefaultResponse dr = new DefaultResponse(ws.findFriendListByUidx(idx));
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/request")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> request(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody RequestForm rf) {
		WiFi w = ws.findByIdx(rf.getRequestWidx());

		if (w == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_WIFI);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		long friendUidx = w.getUser().getIdx();
		long myUidx = u.getIdx();

		if (!us.isFriend(myUidx, friendUidx)) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.ONLY_FRIEND_RELATION_CAN_GET_INFO);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.UNAUTHORIZED);
		}

		if (!pms.sendWiFiRequestMsg(w.getUser(), new WiFiRequestPayload(myUidx, rf.getRequestWidx()))) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.FAIL_TO_SEND_PUSH_MESSAGE);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/response")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> response(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody ResponseForm rf) {
		WiFi w = ws.findByIdx(rf.getRequestWidx());

		if (w == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_WIFI);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		if (w.getUser().getIdx() == u.getIdx()) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.ONLY_WIFI_OWNER_CAN_PERMIT);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.UNAUTHORIZED);
		}

		User requester = us.findByIdx(rf.getRequesterUidx());
		boolean status = rf.getStatus();
		WiFiRequestResultPayload wrrp;

		if (!status) {
			wrrp = new WiFiRequestResultPayload(status, null);
		}

		else {
			WiFi sharedWiFi = new WiFi();
			sharedWiFi.setSsid(w.getSsid());
			sharedWiFi.setMac(w.getMac());
			sharedWiFi.setPassword(w.getPassword());
			sharedWiFi.setAuthType(w.getAuthType());
			sharedWiFi.setChannel(w.getChannel());
			sharedWiFi.setLongitude(w.getLongitude());
			sharedWiFi.setLatitude(w.getLatitude());
			sharedWiFi.setUser(requester);
			ws.save(sharedWiFi);

			wrrp = new WiFiRequestResultPayload(status, sharedWiFi);
		}

		if (!pms.sendWiFiRequestResultMsg(requester, wrrp)) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.FAIL_TO_SEND_PUSH_MESSAGE);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}