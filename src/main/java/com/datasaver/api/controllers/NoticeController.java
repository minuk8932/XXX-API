package com.datasaver.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasaver.api.controllers.forms.AddNoticeForm;
import com.datasaver.api.controllers.forms.UpdateNoticeForm;
import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.domains.Notice;
import com.datasaver.api.domains.User;
import com.datasaver.api.payloads.AddNoticePayload;
import com.datasaver.api.payloads.UpdateNoticePayload;
import com.datasaver.api.services.NoticeService;
import com.datasaver.api.services.PushMessageService;
import com.datasaver.api.utils.auth.Auth;
import com.datasaver.api.utils.res.Strings;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("notice")
@Api
public class NoticeController {
	@Autowired
	private NoticeService ns;

	@Autowired
	private PushMessageService pms;

	@PostMapping("")
	@Auth(allowUserTypes = { User.Type.ADMINISTRATOR })
	public @ResponseBody ResponseEntity<DefaultResponse> addNotice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddNoticeForm anf) {
		Notice n = new Notice();
		n.setTitle(anf.getTitle());
		n.setContents(anf.getContents());
		n = ns.save(n);

		pms.sendAddNoticeMsg(new AddNoticePayload(n.getIdx(), n.getTitle()));

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("/{idx}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getNotice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("idx") long idx) {
		Notice n = ns.findByIdx(idx);

		if (n == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_NOTICE);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DefaultResponse dr = new DefaultResponse(n);
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PutMapping("/{idx}")
	@Auth(allowUserTypes = { User.Type.ADMINISTRATOR })
	public @ResponseBody ResponseEntity<DefaultResponse> updateNotice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("idx") long idx, @RequestBody UpdateNoticeForm unf) {
		Notice n = ns.findByIdx(idx);

		if (n == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_NOTICE);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		n.setTitle(unf.getTitle());
		n.setContents(unf.getContents());
		n = ns.save(n);

		pms.sendUpdateNoticeMsg(new UpdateNoticePayload(n.getIdx(), n.getTitle()));

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@DeleteMapping("/{idx}")
	@Auth(allowUserTypes = { User.Type.ADMINISTRATOR })
	public @ResponseBody ResponseEntity<DefaultResponse> deleteNotice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("idx") long idx) {
		Notice n = ns.findByIdx(idx);

		if (n == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_NOTICE);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		ns.delete(n);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("/list/{page}")
	@Auth
	public @ResponseBody ResponseEntity<DefaultResponse> getNoticeList(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("page") int page) {
		DefaultResponse dr = new DefaultResponse(ns.findList(page));
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}