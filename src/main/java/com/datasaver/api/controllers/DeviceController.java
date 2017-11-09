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

import com.datasaver.api.controllers.forms.AddBaseStationLogForm;
import com.datasaver.api.controllers.forms.AddDeviceForm;
import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.domains.Device;
import com.datasaver.api.domains.DeviceBaseStationLog;
import com.datasaver.api.domains.User;
import com.datasaver.api.services.DeviceBaseStationLogService;
import com.datasaver.api.services.DeviceBatteryLogService;
import com.datasaver.api.services.DeviceLightLogService;
import com.datasaver.api.services.DeviceLocationLogService;
import com.datasaver.api.services.DeviceNoiseLogService;
import com.datasaver.api.services.DeviceRingerLogService;
import com.datasaver.api.services.DeviceService;
import com.datasaver.api.services.DeviceTiltLogService;
import com.datasaver.api.utils.auth.Auth;
import com.datasaver.api.utils.log.ControllerLog;
import com.datasaver.api.utils.res.Strings;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("device")
@Api
public class DeviceController {
	@Autowired
	private DeviceService ds;

	@Autowired
	private DeviceBaseStationLogService dbsls;

	@Autowired
	private DeviceBatteryLogService dbls;

	@Autowired
	private DeviceLightLogService dlils;

	@Autowired
	private DeviceLocationLogService dlols;

	@Autowired
	private DeviceNoiseLogService dnls;

	@Autowired
	private DeviceRingerLogService drls;

	@Autowired
	private DeviceTiltLogService dtls;

	@PostMapping("")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addDevice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddDeviceForm adf) {
		Device d = new Device();
		d.setToken(adf.getToken());
		d.setType(adf.getType());
		d.setUuid(adf.getUuid());
		d.setUser(u);

		ds.save(d);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/log/baseStation")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addBaseStationLog(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddBaseStationLogForm abslf) {
		Device d = u.getDevice();

		if (d == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_DEVICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DeviceBaseStationLog dbsl = new DeviceBaseStationLog();
		dbsl.setCid(abslf.getCid());
		dbsl.setLac(abslf.getLac());
		dbsl.setDevice(d);
		dbsls.save(dbsl);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}