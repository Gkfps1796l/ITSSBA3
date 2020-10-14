package com.wellsfargo.fsd.it.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.it.Entity.AttendeeEntity;
import com.wellsfargo.fsd.it.Entity.InterviewEntity;
import com.wellsfargo.fsd.it.Entity.UserEntity;
import com.wellsfargo.fsd.it.dao.Attendeedao;
import com.wellsfargo.fsd.it.dao.Interviewdao;
import com.wellsfargo.fsd.it.dao.Userdao;
import com.wellsfargo.fsd.it.exception.InterviewException;
import com.wellsfargo.fsd.it.exception.UserException;
@Service
public class AttendeeServiceimpl implements AttendeeService{
	
	@Autowired
	private Attendeedao attendeedao;
	
	@Autowired
	private Interviewdao interviewdao;
	
	@Autowired
	private Userdao userdao;
	
	

	@Override
	@Transactional
	public AttendeeEntity add(AttendeeEntity attendee) throws UserException, InterviewException {
		// TODO Auto-generated method stub
		
		if (attendee!=null)
		{
			if (attendeedao.existsById(attendee.getAttendeeId()))
			{
				throw new InterviewException("Attendee id already exists");
			}
		
			if (!userdao.existsById(attendee.getUser().getUserId()))
			{
				throw new UserException("User doesn't exists");
			}
			
			if (!interviewdao.existsById(attendee.getInterview().getInterviewId()))
			{
				throw new InterviewException("Interview id doesn't exists");
			}
			
			
			
			List<UserEntity> userEntities=attendeedao.findAllUserByInterview(attendee.getInterview());
			/*
			List<AttendeeEntity> attendeeEntities = attendeedao.findAll();
			
			//Getting list of users who are part of the interview by interview Id
			for(AttendeeEntity attendeeEntity: attendeeEntities) {
				
				if(attendee.getInterview().getInterviewId()== attendeeEntity.getInterview().getInterviewId()) {
					userEntities.add(attendeeEntity.getUser());
				}
			}
			*/
			for(UserEntity e:userEntities)
			{
				System.out.println(e);
				if (e.getUserId()==attendee.getUser().getUserId())
				{
					throw new InterviewException("User has already been added to this interview");
				}
			}
			
			attendee.setUser(attendee.getUser());
			attendee.setInterview(attendee.getInterview());
			
			attendee.getUser().getAttendees().add(attendee);
			
			attendee.getInterview().getAttendees().add(attendee);	
			
			attendeedao.save(attendee);
		}
		return attendee;
	}

	@Override
	public List<UserEntity> getAllAttendees(int interview) throws InterviewException {
		List<UserEntity> userEntities=new ArrayList<>();
		List<AttendeeEntity> attendeeEntities = attendeedao.findAll();
		List<Integer> userIds = new ArrayList<>();
		
		//Getting list of users who are part of the interview by interview Id
		for(AttendeeEntity attendeeEntity: attendeeEntities) {
			
			if(interview== attendeeEntity.getInterview().getInterviewId()) {
				//userEntities.add(attendeeEntity.getUser());
				userIds.add(attendeeEntity.getUser().getUserId());
				System.out.println(attendeeEntity.getAttendeeId());
				System.out.println(attendeeEntity.getInterview().getInterviewId());
				System.out.println(attendeeEntity.getUser().getUserId());
			}
		}
		
		for(Integer i: userIds) {
			userEntities.add(userdao.getOne(i));
		}
		System.out.println(userEntities.size());
		if(userEntities.size()==0) {
			throw new InterviewException("No Attendee found with interview id "+interview);
		}
		return userEntities;
	
	}

}
