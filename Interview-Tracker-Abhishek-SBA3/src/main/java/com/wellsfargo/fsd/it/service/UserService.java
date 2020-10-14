package com.wellsfargo.fsd.it.service;

import java.util.List;

import com.wellsfargo.fsd.it.Model.UserModel;
import com.wellsfargo.fsd.it.exception.UserException;

public interface UserService {
	
	UserModel add(UserModel user) throws UserException;
	
	boolean delete(int userId) throws UserException;
	
	UserModel getUser(int userId);
	
	List<UserModel> getAllUsers();

}
