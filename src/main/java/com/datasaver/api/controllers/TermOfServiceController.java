package com.datasaver.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.services.TermOfServiceService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("termOfService")
@Api
public class TermOfServiceController {
	@Autowired
	private TermOfServiceService ts;

	@GetMapping("/lastest")
	public @ResponseBody ResponseEntity<DefaultResponse> getLastestTermOfService() {
		DefaultResponse dr = new DefaultResponse(ts.findLastest());
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}
