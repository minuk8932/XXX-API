package com.datasaver.api.services.interfaces;

import java.util.Collection;

import com.datasaver.api.domains.User;
import com.datasaver.api.repositories.UserRepository.Friend;

public interface UserServiceInterface {
	public User findByEmailNPassword(String email, String password);

	public User findByIdx(long idx);

	public User findByEmail(String email);

	public User findByPhoneNumber(String phoneNumber);

	public User findByNameNPhoneNumberNEmail(String name, String phoneNumber, String email);

	public void save(User user);

	public void delete(User user);

	public Collection<Friend> findFriends(User user);
}
