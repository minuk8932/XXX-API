package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.User;

public interface UserServiceInterface {
	public User getUserByEmailNPassword(String email, String password);

	public User getUserByIdx(long idx);

	public void addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);
}
