package com.wellsfargo.fsd.it.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



public class InterviewModel {
	@NotNull(message = "Interview Id is mandatory and can not be null")
	@Min(value=1,message = "Interview Id can not be negative or zero")
	private Integer interviewId;
	
	@NotNull(message = "Interviewer Name is mandatory and can not be null")
	@Size(min = 5, max = 30, message = "Interviewer Name is expected to be 5 to 30 characters in length")
	private String interviewerName;
	
	@NotNull(message = "Interview Name is mandatory and can not be null")
	@Size(min = 3, max = 30, message = "Interview Name is expected to be 3 to 30 characters in length")
	private String interviewName;
	
	@NotNull(message = "User Skills are mandatory and can not be null")
	@Size(min = 5, max = 30, message = "User Skills are expected to be 5 to 30 characters in length")
	private String usersSkills;
	
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate date;
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime time;
	
	@NotNull(message = "Interview Status is mandatory and can not be null")
	@Size(min = 5, max = 100, message = "Interview Status is expected to be 5 to 100 characters in length")
	private String interviewStatus;
	
	@NotNull(message = "Interview Remarks are mandatory and can not be null")
	@Size(min = 5, max = 100, message = "Interview Remarks are expected to be 5 to 100 characters in length")
	private String remarks;

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getUsersSkills() {
		return usersSkills;
	}

	public void setUsersSkills(String usersSkills) {
		this.usersSkills = usersSkills;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public InterviewModel() {
		super();
	}

	public InterviewModel(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
			LocalDate date, LocalTime time, String interviewStatus, String remarks) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.date = date;
		this.time = time;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}
	
	

}
