package com.wellsfargo.fsd.it.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.wellsfargo.fsd.it.Entity.InterviewEntity;
@Repository
public interface Interviewdao extends JpaRepository<InterviewEntity,Integer>{
	
	@Query("SELECt k FROM InterviewEntity k WHERE k.interviewerName=:interviewerName")
	List<InterviewEntity> findAllinterviewerName(String interviewerName);
	
	@Query("SELECt k FROM InterviewEntity k WHERE k.interviewName=:interviewName")
	List<InterviewEntity> findAllinterviewName(String interviewName);

}
