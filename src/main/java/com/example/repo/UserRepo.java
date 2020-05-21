package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.userentity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	@Query("from UserEntity where email=:email and uPwd=:pwd")
	public UserEntity findByemailanduPwd(String email, String pwd);

	
	@Query("from UserEntity where email=:email")
	public UserEntity findByemail(String email);
	

	@Query(value="from UserEntity where role =:role")
	public List<UserEntity> findAllByRole(String role);
	
}
