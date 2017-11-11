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

import com.datasaver.api.controllers.forms.AddHelpForm;
import com.datasaver.api.controllers.forms.UpdateHelpForm;
import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.domains.Help;
import com.datasaver.api.domains.User;
import com.datasaver.api.services.HelpService;
import com.datasaver.api.utils.auth.Auth;
import com.datasaver.api.utils.log.ControllerLog;
import com.datasaver.api.utils.res.Strings;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("help")
@Api
public class HelpController {
	@Autowired
	private HelpService hs;
	
	@PutMapping("")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addHelp(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddHelpForm ahf) {
		if (hs.findByTitleNContents(ahf.getTitle(), ahf.getContents()) != null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.ALREADY_EXIST_NOTICE);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.ALREADY_REPORTED);
		}

		Help h = new Help();
		h.setTitle(ahf.getTitle());
		h.setContents(ahf.getContents());
		hs.save(h);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@GetMapping("/read")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> getHelp(@RequestHeader("Authorization") String token,
			@ApiIgnore User u) {
		Help h = new Help();
		
		if(hs.findByIdx(h.getIdx()) == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_NOTICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		DefaultResponse dr = new DefaultResponse(hs.findByIdx(h.getIdx()));
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> updateHelp(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody UpdateHelpForm uhf) {
		if (hs.findByTitleNContents(uhf.getTitle(), uhf.getContents()) == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_NOTICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.NOT_FOUND);
		}

		Help h = new Help();
		h.setTitle(uhf.getTitle());
		h.setContents(uhf.getContents());
		hs.save(h);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> deleteHelp(@RequestHeader("Authorization") String token,
			@ApiIgnore User u) {
		Help h = new Help();
		
		if (hs.findByIdx(h.getIdx()) == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_NOTICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.NOT_FOUND);
		}
		
		hs.delete(h);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}
