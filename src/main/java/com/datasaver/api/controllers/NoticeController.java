package com.datasaver.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.datasaver.api.controllers.responses.data.GetNoticeResponseData;
import com.datasaver.api.domains.Notice;
import com.datasaver.api.domains.User;
import com.datasaver.api.services.NoticeService;
import com.datasaver.api.utils.auth.Auth;
import com.datasaver.api.utils.log.ControllerLog;
import com.datasaver.api.utils.res.Strings;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("notice")
@Api
public class NoticeController {
	@Autowired
	private NoticeService ns;
	
	@PutMapping("")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addNotice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddNoticeForm anf) {
		if (ns.findByTitleNContents(anf.getTitle(), anf.getContents()) != null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.ALREADY_EXIST_NOTICE);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.ALREADY_REPORTED);
		}

		Notice n = new Notice();
		n.setTitle(anf.getTitle());
		n.setContents(anf.getContents());
		ns.save(n);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@GetMapping("/read")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> getNotice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u) {
		Notice n = ns.findByIdx(u.getIdx());
		
		if(n == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_NOTICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		n = new Notice();
		
		GetNoticeResponseData gnrd = new GetNoticeResponseData(n.getTitle(), n.getContents());
		
		DefaultResponse dr = new DefaultResponse(gnrd);
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> updateNotice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody UpdateNoticeForm unf) {
		if (ns.findByTitleNContents(unf.getTitle(), unf.getContents()) == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_NOTICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.NOT_FOUND);
		}

		Notice n = new Notice();
		n.setTitle(unf.getTitle());
		n.setContents(unf.getContents());
		ns.save(n);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> deleteNotice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u) {
		Notice n = new Notice();
		
		if (ns.findByIdx(n.getIdx()) == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_NOTICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.NOT_FOUND);
		}
		
		ns.delete(n);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}
