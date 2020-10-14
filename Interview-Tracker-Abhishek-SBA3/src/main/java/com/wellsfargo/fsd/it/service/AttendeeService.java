package com.wellsfargo.fsd.it.service;

import java.util.List;
import java.util.Set;

import com.wellsfargo.fsd.it.Entity.AttendeeEntity;
import com.wellsfargo.fsd.it.Entity.UserEntity;
import com.wellsfargo.fsd.it.exception.InterviewException;
import com.wellsfargo.fsd.it.exception.UserException;

public interface AttendeeService {
	
	AttendeeEntity add(AttendeeEntity attendee) throws UserException, InterviewException;
	List<UserEntity> getAllAttendees(int interview) throws InterviewException;
	
}
