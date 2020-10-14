package com.wellsfargo.fsd.it.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.it.Entity.AttendeeEntity;
import com.wellsfargo.fsd.it.Entity.InterviewEntity;
import com.wellsfargo.fsd.it.Entity.UserEntity;

@Repository
public interface Attendeedao extends JpaRepository<AttendeeEntity,Integer>{	

	
	@Query("SELECt k.user FROM AttendeeEntity k WHERE k.interview=:interview")
	List<UserEntity> findAllUserByInterview(InterviewEntity interview);
	
	

}
