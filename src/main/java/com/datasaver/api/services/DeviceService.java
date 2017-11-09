package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.Device;
import com.datasaver.api.repositories.DeviceRepository;
import com.datasaver.api.services.interfaces.DeviceServiceInterface;

@Service("DeviceService")
public class DeviceService implements DeviceServiceInterface {
	@Autowired
	DeviceRepository dr;

	@Override
	public Device findByIdx(long idx) {
		return dr.findOne(idx);
	}

	@Override
	public void save(Device device) {
		dr.save(device);
	}

	@Override
	public void delete(Device device) {
		dr.delete(device);
	}
}
