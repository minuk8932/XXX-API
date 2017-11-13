package com.datasaver.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datasaver.api.controllers.forms.AddBaseStationLogForm;
import com.datasaver.api.controllers.forms.AddBatteryLogForm;
import com.datasaver.api.controllers.forms.UpdateDeviceForm;
import com.datasaver.api.controllers.forms.AddLightLogForm;
import com.datasaver.api.controllers.forms.AddLocationLogForm;
import com.datasaver.api.controllers.forms.AddNoiseLogForm;
import com.datasaver.api.controllers.forms.AddRingerLogForm;
import com.datasaver.api.controllers.forms.AddTiltLogForm;
import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.domains.Device;
import com.datasaver.api.domains.DeviceBaseStationLog;
import com.datasaver.api.domains.DeviceBatteryLog;
import com.datasaver.api.domains.DeviceLightLog;
import com.datasaver.api.domains.DeviceLocationLog;
import com.datasaver.api.domains.DeviceNoiseLog;
import com.datasaver.api.domains.DeviceRingerLog;
import com.datasaver.api.domains.DeviceTiltLog;
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

	@PutMapping("")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> updateDevice(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody UpdateDeviceForm udf) {
		Device d = ds.findByUser(u);

		if (d != null)
			ds.delete(d);

		d = new Device();
		d.setToken(udf.getToken());
		d.setType(udf.getType());
		d.setUuid(udf.getUuid());
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
		Device d = ds.findByUser(u);

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

	@PostMapping("/log/battery")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addBatteryLog(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddBatteryLogForm ablf) {
		Device d = ds.findByUser(u);

		if (d == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_DEVICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DeviceBatteryLog dbl = new DeviceBatteryLog();
		dbl.setChargeType(ablf.getChargeType());
		dbl.setPercent(ablf.getPercent());
		dbl.setDevice(d);
		dbls.save(dbl);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/log/light")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addLightLog(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddLightLogForm alilf) {
		Device d = ds.findByUser(u);

		if (d == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_DEVICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DeviceLightLog dlil = new DeviceLightLog();
		dlil.setLux(alilf.getLux());
		dlil.setDevice(d);
		dlils.save(dlil);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/log/location")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addLocationLog(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddLocationLogForm alolf) {
		Device d = ds.findByUser(u);

		if (d == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_DEVICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DeviceLocationLog dlol = new DeviceLocationLog();
		dlol.setSensorType(alolf.getSensorType());
		dlol.setLongitude(alolf.getLongitude());
		dlol.setLatitude(alolf.getLatitude());
		dlol.setDevice(d);
		dlols.save(dlol);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/log/noise")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addNoiseLog(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddNoiseLogForm anlf) {
		Device d = ds.findByUser(u);

		if (d == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_DEVICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DeviceNoiseLog dnl = new DeviceNoiseLog();
		dnl.setDb(anlf.getDb());
		dnl.setDevice(d);
		dnls.save(dnl);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/log/ringer")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addRingerLog(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddRingerLogForm arf) {
		Device d = ds.findByUser(u);

		if (d == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_DEVICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DeviceRingerLog drl = new DeviceRingerLog();
		drl.setType(arf.getType());
		drl.setVolume(arf.getVolume());
		drl.setDevice(d);
		drls.save(drl);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}

	@PostMapping("/log/tilt")
	@Auth
	@ControllerLog
	public @ResponseBody ResponseEntity<DefaultResponse> addTiltLog(@RequestHeader("Authorization") String token,
			@ApiIgnore User u, @RequestBody AddTiltLogForm atlf) {
		Device d = ds.findByUser(u);

		if (d == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_ANY_DEVICES);
			return new ResponseEntity<DefaultResponse>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		DeviceTiltLog dtl = new DeviceTiltLog();
		dtl.setX(atlf.getX());
		dtl.setY(atlf.getY());
		dtl.setZ(atlf.getZ());
		dtls.save(dtl);

		DefaultResponse dr = new DefaultResponse();
		return new ResponseEntity<DefaultResponse>(dr, HttpStatus.OK);
	}
}