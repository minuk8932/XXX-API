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

import com.datasaver.api.controllers.forms.AddQNAForm;
import com.datasaver.api.controllers.forms.UpdateQNAForm;
import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.domains.QNA;
import com.datasaver.api.domains.User;
import com.datasaver.api.services.QNAService;
import com.datasaver.api.utils.auth.Auth;
import com.datasaver.api.utils.log.ControllerLog;
import com.datasaver.api.utils.res.Strings;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("qna")
@Api
public class QNAController {
	@Autowired
	private QNAService qs;
	
	@PostMapping("")
	@Auth(allowUserTypes = { User.Type.ADMINISTRATOR })
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addQNA(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddQNAForm aqf) {
		QNA q = new QNA();
		q.setQuestion(aqf.getQuestion());
		q.setAnswer(aqf.getAnswer());
		qs.save(q);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@GetMapping("/{idx}")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> getQNA(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("idx") long idx) {
		QNA q = qs.findByIdx(idx);
		
		if(q == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_QNA);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		DefaultResponse dr = new DefaultResponse(q);
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@PutMapping("/{idx}")
	@Auth(allowUserTypes = { User.Type.ADMINISTRATOR })
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> updateQNA(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("idx") long idx, @RequestBody UpdateQNAForm uqf) {
		QNA q = qs.findByIdx(idx);
		
		if (q == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_QNA);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		q.setQuestion(uqf.getQuestion());
		q.setAnswer(uqf.getAnswer());
		qs.save(q);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@DeleteMapping("/{idx}")
	@Auth(allowUserTypes = { User.Type.ADMINISTRATOR })
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> deleteQNA(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("idx") long idx) {
		QNA q = qs.findByIdx(idx);
		
		if (q == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_QNA);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		qs.delete(q);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
	
	@GetMapping("/list/{page}")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> getQNAList(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @PathVariable("page") int page) {
		DefaultResponse dr = new DefaultResponse(qs.findList(page));
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}
