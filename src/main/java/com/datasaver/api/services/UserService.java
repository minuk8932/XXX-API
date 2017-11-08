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
	public User findByEmailNPassword(String email, String password) {
		return ur.findByEmailNPassword(email, password);
	}

	@Override
	public User findByIdx(long idx) {
		return ur.findOne(idx);
	}

	@Override
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}

	@Override
	public User findByPhoneNumber(String phoneNumber) {
		return ur.findByPhoneNumber(phoneNumber);
	}

	@Override
	public User findByNameNPhoneNumberNEmail(String name, String phoneNumber, String email) {
		return ur.findByNameNPhoneNumberNEmail(name, phoneNumber, email);
	}

	@Override
	public void save(User user) {
		ur.save(user);
	}

	@Override
	public void delete(User user) {
		ur.delete(user);
	}
}
