package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.UserMaster;

public interface IUserMgmtRepository extends JpaRepository<UserMaster, Integer> {
	
  public UserMaster findByNameAndMail(String name,String mail);
  
}