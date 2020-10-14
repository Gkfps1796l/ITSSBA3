package com.wellsfargo.fsd.it.service;

import java.util.List;

import com.wellsfargo.fsd.it.Model.InterviewModel;
import com.wellsfargo.fsd.it.exception.InterviewException;


public interface InterviewService {
	
	InterviewModel add(InterviewModel interview) throws InterviewException;
	
	InterviewModel update(InterviewModel interview) throws InterviewException;
	
	boolean delete(int interviewId) throws InterviewException;
	
	//UserModel getUser(int userId);
	List<InterviewModel> searchByName(String name);
	
	List<InterviewModel> getAllInterview();
	
	List<InterviewModel> getAllInterviewByInterviewerName(String name);
	
	List<InterviewModel> getAllInterviewByInterviewName(String name);

	Integer getTotalNoOfInterviews();
}
