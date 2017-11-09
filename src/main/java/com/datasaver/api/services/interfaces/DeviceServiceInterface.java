package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.Device;
import com.datasaver.api.domains.User;

public interface DeviceServiceInterface {
	public Device findByIdx(long idx);

	public void save(Device device);

	public void delete(Device device);

	public Device findByUser(User user);
}