package com.datasaver.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datasaver.api.services.DeviceBaseStationLogService;
import com.datasaver.api.services.DeviceBatteryLogService;
import com.datasaver.api.services.DeviceLightLogService;
import com.datasaver.api.services.DeviceLocationLogService;
import com.datasaver.api.services.DeviceNoiseLogService;
import com.datasaver.api.services.DeviceRingerLogService;
import com.datasaver.api.services.DeviceTiltLogService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("device")
@Api
public class DeviceController {
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
}
