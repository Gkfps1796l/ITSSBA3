package com.wellsfargo.fsd.it.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.it.Entity.UserEntity;
import com.wellsfargo.fsd.it.Model.UserModel;
import com.wellsfargo.fsd.it.dao.Userdao;
import com.wellsfargo.fsd.it.exception.UserException;


@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	private Userdao userdao;
	
	private UserEntity toEntity(UserModel u) {
		return new UserEntity(u.getUserId(),u.getFirstName(),u.getLastName(),u.getEmail(),u.getMobile());		
	}
	
	private UserModel toModel(UserEntity u) {
		return new UserModel(u.getUserId(),u.getFirstName(),u.getLastName(),u.getEmail(),u.getMobile());
		
	}

	@Override
	@Transactional
	public UserModel add(UserModel user) throws UserException {
		// TODO Auto-generated method stub
		if (user!=null)
		{
			if (userdao.existsById(user.getUserId()))
			{
				throw new UserException("User Already exists");
			}
			user =toModel(userdao.save(toEntity(user)));
		}
		return user;
	}

	@Override
	@Transactional
	public boolean delete(int userId) throws UserException {
		// TODO Auto-generated method stub
		if (!userdao.existsById(userId))
		{
			throw new UserException("User doesn't exists");
		}
		userdao.deleteById(userId);
		return true;
	}

	@Override
	public UserModel getUser(int userId) {
		// TODO Auto-generated method stub
		UserEntity entity= userdao.findById(userId).orElse(null);
		
		return entity!=null?toModel(entity):null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<UserEntity> entities=userdao.findAll();
		List<UserModel> models=null;
		if (entities!=null && !entities.isEmpty()) {
			 models=entities.stream().map(e->toModel(e)).collect(Collectors.toList());
		}		
		return models;
	}
	

}
