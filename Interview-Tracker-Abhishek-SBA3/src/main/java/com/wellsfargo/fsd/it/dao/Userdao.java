package com.wellsfargo.fsd.it.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.it.Entity.UserEntity;

@Repository
public interface Userdao extends JpaRepository<UserEntity,Integer> {

}
