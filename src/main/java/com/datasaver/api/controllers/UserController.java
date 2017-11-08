package com.datasaver.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasaver.api.controllers.forms.SignInForm;
import com.datasaver.api.controllers.forms.SignOutForm;
import com.datasaver.api.controllers.forms.SignUpForm;
import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.controllers.responses.data.SignInResponseData;
import com.datasaver.api.domains.User;
import com.datasaver.api.services.UserService;
import com.datasaver.api.utils.auth.Auth;
import com.datasaver.api.utils.auth.JWT;
import com.datasaver.api.utils.log.ControllerLog;
import com.datasaver.api.utils.res.Strings;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("user")
@Api
public class UserController {
	@Autowired
	private UserService us;

	@PostMapping("/sign/up")
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> signUp(@RequestBody SignUpForm suf) {
		User u = new User();
		u.setName(suf.getName());
		u.setPhoneNumber(suf.getPhoneNumber());
		u.setEmail(suf.getEmail());
		u.setPassword(suf.getPassword());

		us.addUser(u);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/sign/in")
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> signIn(@RequestBody SignInForm sif) {
		User u = us.getUserByEmailNPassword(sif.getEmail(), sif.getPassword());

		if (u == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_USER);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.UNAUTHORIZED);
		}

		DefaultResponse dr = new DefaultResponse(new SignInResponseData(JWT.create(u.getIdx())));
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@DeleteMapping("/sign/out")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> signOut(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody SignOutForm sof) {
		if (us.getUserByEmailNPassword(sof.getEmail(), sof.getPassword()) == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_USER);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.UNAUTHORIZED);
		}

		us.deleteUser(u);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}