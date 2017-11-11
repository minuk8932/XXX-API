package com.datasaver.api.services;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.User;
import com.datasaver.api.domains.views.FindFriendsView;
import com.datasaver.api.domains.views.FindUserProfileView;
import com.datasaver.api.domains.views.IsFriendView;
import com.datasaver.api.repositories.UserRepository;
import com.datasaver.api.services.interfaces.UserServiceInterface;

@Service("UserService")
public class UserService implements UserServiceInterface {
	@Autowired
	private UserRepository ur;

	@Autowired
	private EntityManager em;

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

	@SuppressWarnings("unchecked")
	@Override
	public Collection<FindFriendsView> findFriendsByIdx(long idx) {
		Query q = em.createNativeQuery(
				"SELECT u.idx, u.name, u.profileImg FROM User AS u INNER JOIN Friend AS f ON u.idx = f.fuidx WHERE f.uidx = ?",
				FindFriendsView.class);
		q.setParameter(1, idx);

		return q.getResultList();
	}

	@Override
	public Collection<User> findByIdxs(long[] idxs) {
		return ur.findByIdxs(Arrays.asList(ArrayUtils.toObject(idxs)));
	}

	@Override
	public FindUserProfileView findUserProfileByIdx(long idx) {
		Query q = em.createNativeQuery(
				"SELECT u.idx, u.name, u.phoneNumber, u.profileImg FROM User AS u WHERE u.idx = ?",
				FindUserProfileView.class);
		q.setParameter(1, idx);

		return (FindUserProfileView) q.getSingleResult();
	}

	@Override
	public boolean isFriend(long uidx, long fuidx) {
		Query q = em.createNativeQuery("SELECT * FROM Friend AS f WHERE f.uidx = ? AND f.fuidx = ?",
				IsFriendView.class);
		q.setParameter(1, uidx);
		q.setParameter(2, fuidx);

		try {
			q.getSingleResult();

			return true;
		} catch (NoResultException nre) {
			return false;
		}
	}

	@Override
	public Collection<User> findAll() {
		return ur.findAll();
	}
}
