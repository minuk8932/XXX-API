package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.User;

public interface UserServiceInterface {
	public User findByEmailNPassword(String email, String password);

	public User findByIdx(long idx);

	public User findByEmail(String email);

	public User findByPhoneNumber(String phoneNumber);

	public User findByNameNPhoneNumberNEmail(String name, String phoneNumber, String email);

	public void save(User user);

	public void delete(User user);
}
