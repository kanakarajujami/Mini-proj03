package com.nt.service;

import java.util.List;

import com.nt.bindings.ActivateUser;
import com.nt.bindings.LoginCredintials;
import com.nt.bindings.RecoveryPassword;
import com.nt.bindings.UserAccount;

public interface IUserMgmtService {
   public String UserRegistration(UserAccount user) throws Exception;
   public String activateUser(ActivateUser user);
   public List<UserAccount> getAllUsers();
   public UserAccount showUserById(int userId);
   public String deleteUserById(int userId);
   public String updateUser(UserAccount user);
   public String loginUser(LoginCredintials login);
   public String recoveryPassword(RecoveryPassword recovery) throws Exception;
}
