package com.datasaver.api.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.controllers.responses.data.GetPushMessageResponseData;
import com.datasaver.api.controllers.responses.data.ReadResponseData;
import com.datasaver.api.domains.PushMessage;
import com.datasaver.api.domains.User;
import com.datasaver.api.payloads.AddNoticePayload;
import com.datasaver.api.payloads.UpdateNoticePayload;
import com.datasaver.api.payloads.WiFiRequestPayload;
import com.datasaver.api.payloads.WiFiRequestResultPayload;
import com.datasaver.api.services.PushMessageService;
import com.datasaver.api.utils.auth.Auth;
import com.datasaver.api.utils.log.ControllerLog;
import com.datasaver.api.utils.res.Strings;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("pushMessage")
@Api
public class PushMessageController {
	@Autowired
	PushMessageService pms;

	@GetMapping("/list/{page}")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> getPushMessageList(
			@RequestHeader("Authorization") String token, @ApiIgnore User u, @PathVariable("page") int page) {
		Collection<PushMessage> pushMessages = pms.findListByUser(u, page);
		GetPushMessageResponseData[] gpmrds = new GetPushMessageResponseData[pushMessages.size()];
		int i = 0;

		for (PushMessage pm : pushMessages) {
			PushMessage.Type t = pm.getType();
			Object o = null;

			switch (t) {
			case ADD_NOTICE:
				o = new Gson().fromJson(pm.getPayload(), AddNoticePayload.class);
				break;

			case UPDATE_NOTICE:
				o = new Gson().fromJson(pm.getPayload(), UpdateNoticePayload.class);
				break;

			case WIFI_REQUEST:
				o = new Gson().fromJson(pm.getPayload(), WiFiRequestPayload.class);
				break;

			case WIFI_REQUEST_RESULT:
				o = new Gson().fromJson(pm.getPayload(), WiFiRequestResultPayload.class);
				break;
			}

			gpmrds[i++] = new GetPushMessageResponseData(pm.getIdx(), t, o, pm.getIsRead(), pm.getTs());
		}

		DefaultResponse dr = new DefaultResponse(gpmrds);
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("/read/{idx}")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> read(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("idx") long idx) {
		PushMessage pm = pms.findByIdx(idx);

		if (pm == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_PUSH_MESSAGE);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		if (pm.getUser().getIdx() != u.getIdx()) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.ONLY_PUSH_MESSAGE_OWNER_CAN_READ);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.UNAUTHORIZED);
		}

		pm.setIsRead(true);
		pms.save(pm);

		DefaultResponse dr = new DefaultResponse(new ReadResponseData(pms.getUnreadCounts(u)));
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}