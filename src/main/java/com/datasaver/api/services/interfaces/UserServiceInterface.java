package com.datasaver.api.services.interfaces;

import java.util.Collection;

import com.datasaver.api.domains.User;
import com.datasaver.api.domains.views.FindFriendsView;
import com.datasaver.api.domains.views.FindUserProfileView;

public interface UserServiceInterface {
	public User findByEmailNPassword(String email, String password);

	public User findByIdx(long idx);

	public User findByEmail(String email);

	public User findByPhoneNumber(String phoneNumber);

	public User findByNameNPhoneNumberNEmail(String name, String phoneNumber, String email);

	public void save(User user);

	public void delete(User user);

	public Collection<User> findByIdxs(long[] idxs);

	public Collection<FindFriendsView> findFriendsByIdx(long idx);

	public FindUserProfileView findUserProfileByIdx(long idx);

	public boolean isFriend(long uidx, long fuidx);

	public Collection<User> findAll();
}