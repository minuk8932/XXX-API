package com.datasaver.api.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User AS u WHERE u.email = ?1 AND u.password = ?2")
	public User findByEmailNPassword(String email, String password);

	@Query("SELECT u FROM User AS u WHERE u.name = ?1 AND u.phoneNumber = ?2")
	public User findByNameNPhoneNumber(String name, String phoneNumber);

	@Query("SELECT u FROM User AS u WHERE u.email = ?1")
	public User findByEmail(String email);

	@Query("SELECT u FROM User AS u WHERE u.phoneNumber = ?1")
	public User findByPhoneNumber(String phoneNumber);

	@Query("SELECT u FROM User AS u WHERE u.name = ?1 AND u.phoneNumber = ?2 AND u.email = ?3")
	public User findByNameNPhoneNumberNEmail(String name, String phoneNumber, String email);

	@Query(value = "SELECT NEW com.datasaver.api.domains.Friend(u.idx, u.name, u.profileImg) FROM User AS u INNER JOIN Friend AS f ON u.idx = f.fuidx WHERE f.uidx = ?1", nativeQuery = true)
	public Collection<Friend> findFriends(long idx);
	
	public class Friend {
		private long idx;
		private String name;
		private String profileImg;

		public Friend() {
		}

		public Friend(long idx, String name, String profileImg) {
			this.idx = idx;
			this.name = name;
			this.profileImg = profileImg;
		}

		public long getIdx() {
			return idx;
		}

		public void setIdx(long idx) {
			this.idx = idx;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getProfileImg() {
			return profileImg;
		}

		public void setProfileImg(String profileImg) {
			this.profileImg = profileImg;
		}
	}
}