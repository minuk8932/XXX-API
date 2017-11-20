package com.datasaver.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.data.CheckEmailResponseData;
import com.datasaver.api.controllers.responses.data.CheckPhoneNumberResponseData;
import com.datasaver.api.services.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("check")
@Api
public class CheckController {
	@Autowired
	private UserService us;

	@GetMapping("/email/{email:.+}")
	public @ResponseBody ResponseEntity<DefaultResponse> checkEmail(@PathVariable("email") String email) {
		if (us.findByEmail(email) == null) {
			DefaultResponse dr = new DefaultResponse(new CheckEmailResponseData(false));
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
		}

		DefaultResponse dr = new DefaultResponse(new CheckEmailResponseData(true));
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@GetMapping("/phoneNumber/{phoneNumber}")
	public @ResponseBody ResponseEntity<DefaultResponse> checkPhoneNumber(
			@PathVariable("phoneNumber") String phoneNumber) {
		if (us.findByPhoneNumber(phoneNumber) == null) {
			DefaultResponse dr = new DefaultResponse(new CheckPhoneNumberResponseData(false));
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
		}

		DefaultResponse dr = new DefaultResponse(new CheckPhoneNumberResponseData(true));
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}
