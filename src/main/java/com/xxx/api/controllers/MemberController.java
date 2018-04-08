package com.xxx.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.api.services.MemberService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("member")
@Api
public class MemberController {
	@Autowired
	private MemberService ms;
	
}
