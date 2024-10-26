package com.nt.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bindings.ActivateUser;
import com.nt.bindings.LoginCredintials;
import com.nt.bindings.RecoveryPassword;
import com.nt.bindings.UserAccount;
import com.nt.service.IUserMgmtService;



@RestController
@RequestMapping("usermgmt-api")
public class UserMgmtController {
	@Autowired
	private IUserMgmtService userService;
   @PostMapping("/save")
   private ResponseEntity<String> saveUser(@RequestBody UserAccount user) throws Exception{
	  //use service
	   String msg=userService.UserRegistration(user);
	   return new ResponseEntity<String>(msg,HttpStatus.CREATED);
   }
   
   @PatchMapping("/activate")
   private ResponseEntity<String> userActivation(@RequestBody ActivateUser user){
	   //user service
	   String msg=userService.activateUser(user);
	   return new ResponseEntity<String>(msg,HttpStatus.OK);
   }
   
   @GetMapping("/findAll")
   private ResponseEntity<List<UserAccount>> findAllUsers(){
	   //user service
	   List<UserAccount> listUsers=userService.getAllUsers();
	   return new ResponseEntity<List<UserAccount>>(listUsers,HttpStatus.OK);
   }
   @GetMapping("/find/{id}")
   private ResponseEntity<UserAccount> getUserById(@PathVariable Integer id){
	   //user service
	   UserAccount user=userService.showUserById(id);
	   return new ResponseEntity<UserAccount>(user,HttpStatus.OK);
   }
   @GetMapping("/delete/{id}")
   private ResponseEntity<String> deleteUserById(@PathVariable Integer id){
	  //use service
	   String msg=userService.deleteUserById(id);
	   return new ResponseEntity<String>(msg,HttpStatus.OK);
	   
   }
   @PutMapping("/update@")
   private ResponseEntity<String> updateUser(@RequestBody UserAccount user){
	   //use service
	   String msg=userService.updateUser(user);
	   return new ResponseEntity<String>(msg,HttpStatus.OK);
   }
   
   @PostMapping("/login")
   private ResponseEntity<String> loingUser(@RequestBody LoginCredintials login){
	    //user service
	    String msg=userService.loginUser(login);
	   return new ResponseEntity<String>(msg,HttpStatus.OK);   
   }
   
   @PostMapping("/recoveryPassword")
   private ResponseEntity<String> recoveryPassword(@RequestBody RecoveryPassword recovery) throws Exception{
	   //use service
	   String msg=userService.recoveryPassword(recovery);
	   return new ResponseEntity<String>(msg,HttpStatus.OK);
   }
}
