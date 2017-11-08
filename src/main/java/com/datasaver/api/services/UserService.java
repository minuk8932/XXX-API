package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.User;
import com.datasaver.api.repositories.UserRepository;
import com.datasaver.api.services.interfaces.UserServiceInterface;

@Service("UserService")
public class UserService implements UserServiceInterface {
	@Autowired
	private UserRepository ur;

	@Override
	public User getUserByEmailNPassword(String email, String password) {
		return ur.getUserByEmailNPassword(email, password);
	}

	@Override
	public User getUserByIdx(long idx) {
		return ur.findOne(idx);
	}

	@Override
	public void addUser(User user) {
		ur.save(user);
	}

	@Override
	public void deleteUser(User user) {
		ur.delete(user);
	}

	@Override
	public void updateUser(User user) {
		ur.save(user);
	}
}
