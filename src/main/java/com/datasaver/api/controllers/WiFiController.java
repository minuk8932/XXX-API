package com.datasaver.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasaver.api.controllers.forms.AddWiFiConnectionLogForm;
import com.datasaver.api.controllers.forms.AddWiFiForm;
import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.domains.User;
import com.datasaver.api.domains.WiFi;
import com.datasaver.api.domains.WiFiConnectionLog;
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
	private WiFiConnectionLogService wcls;

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
}
