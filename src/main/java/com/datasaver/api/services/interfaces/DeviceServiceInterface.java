package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.Device;

public interface DeviceServiceInterface {
	public Device findByIdx(long idx);

	public void save(Device device);

	public void delete(Device device);
}