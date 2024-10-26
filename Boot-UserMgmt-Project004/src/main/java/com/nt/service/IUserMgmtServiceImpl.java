package com.nt.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.bindings.ActivateUser;
import com.nt.bindings.LoginCredintials;
import com.nt.bindings.RecoveryPassword;
import com.nt.bindings.UserAccount;
import com.nt.entity.UserMaster;
import com.nt.repository.IUserMgmtRepository;
import com.nt.util.SendMailToUser;
@Service("userservice")
public class IUserMgmtServiceImpl implements IUserMgmtService {
   @Autowired
   private IUserMgmtRepository userRepo;
   @Autowired
	private Environment env;
	@Autowired
	private SendMailToUser sendMail;
	@Override
	public String UserRegistration(UserAccount user) throws Exception {
		  //convert binding object to UserMaster entity object
		 UserMaster entity=new UserMaster();
		 //copy binding obj properties to entity object
		 BeanUtils.copyProperties(user, entity);
		 entity.setActiveSW("inactive");
		 //generate password and set to entity object
		 entity.setPassword(generatePassword(6));
		  UserMaster savedEntity= userRepo.save(entity);
		  String mailBody=readMailBody(env.getProperty("mailbody.registration.location"),savedEntity.getName(),savedEntity.getPassword());
		  String subject="User Registration Process ";
		  sendMail.sendMail(savedEntity.getMail(),subject,mailBody);
		return "user registered and mail sent to email";
	}

	@Override
	public String activateUser(ActivateUser user) {
		//convert binding obj to UserMaster obj
		UserMaster entity=new UserMaster();
		entity.setName(user.getName());
		entity.setMail(user.getMail());
		Example<UserMaster> example=Example.of(entity);
		List<UserMaster> listEntities=userRepo.findAll(example);
		if(listEntities.size()!=0) {
			UserMaster master=listEntities.get(0);
			if(master!=null) {
				//activate user
				master.setActiveSW("active");
				//update password
				master.setPassword(user.getConfirmPassword());
				UserMaster savedMaster=userRepo.save(master);
				return "user activated successfully..";
			}
		}
		return "user not found to activate";
	}

	@Override
	public List<UserAccount> getAllUsers() {
		List<UserMaster> listUsers=userRepo.findAll();
		List<UserAccount> listAccounts=new ArrayList<UserAccount>();
		listUsers.forEach(entity->{
			UserAccount user=new UserAccount();
			//copy Master entity obj to UserAccount object
			BeanUtils.copyProperties(entity, user);
			listAccounts.add(user);
		});

		return listAccounts;
	}

	@Override
	public UserAccount showUserById(int userId) {
		Optional<UserMaster> opt=userRepo.findById(userId);
		if(opt.isPresent()) {
			UserMaster master=opt.get();
			UserAccount user=new UserAccount();
			BeanUtils.copyProperties(master, user);
			return user;
		}
		return null;
	}

	@Override
	public String deleteUserById(int userId) {
		Optional<UserMaster> opt=userRepo.findById(userId);
		if(opt.isPresent()) {
		    userRepo.deleteById(userId);
			return "user found and deleted";
		}
		return "user not found to delete";
	}
	

	@Override
	public String updateUser(UserAccount  user) {
		Optional<UserMaster> opt =userRepo.findById(user.getUserId());
		if(opt.isPresent()) {
			 UserMaster master=opt.get();
			 BeanUtils.copyProperties(user, master);
			 userRepo.save(master);
			  return "user details are updated";
		}
		
		return "user not found to updated";
	}

	@Override
	public String loginUser(LoginCredintials login) {
		 //convert binding object to UserMaster
		UserMaster master=new UserMaster();
		//BeanUtils.copyProperties(login, master);
		master.setMail(login.getMail());	
		master.setPassword(login.getPassword());
		Example<UserMaster> example=Example.of(master);
		List<UserMaster> listUsers=userRepo.findAll(example);
		if(listUsers!=null) {
			UserMaster savedMaster=listUsers.get(0);
			if(savedMaster.getActiveSW().equalsIgnoreCase("active")) {
				  return "vaild credintials and login successfull" ;
			}else {
				return "user not activated";
			}
		}
		return "Invalid credtintials";
	}

	@Override
	public String recoveryPassword(RecoveryPassword recovery) throws Exception {
		 UserMaster master=userRepo.findByNameAndMail(recovery.getName(), recovery.getMail());
		 if(master!=null) {
			 String password=master.getPassword();
			 String mailBody=readMailBody(env.getProperty("mailbody.recoverypwd.location"),master.getName(),password);
			 String subject="Mail for password recovery";
			 sendMail.sendMail(master.getMail(),subject,mailBody);
			 return "password sent  toyour mail";
		 }
		return "user not found";
	}
	private String generatePassword(int size){

		
		

		 // a list of characters to choose from in form of a string

		 String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

		 // creating a StringBuffer size of AlphaNumericStr

		 StringBuilder s = new StringBuilder(size);

		 int i;

		 for ( i=0; i<size; i++) {

		   //generating a random number using math.random()

		   int ch = (int)(AlphaNumericStr.length() * Math.random());

		   //adding Random character one by one at the end of s

		   s.append(AlphaNumericStr.charAt(ch));

		  }

		    return s.toString();

		 }//end of generatedPassword().....
	
	//develop mail body
	private String readMailBody(String file,String name,String password) throws Exception {
		String mailBody=null;
		try {
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String url="www.google.com";
			StringBuffer buffer=new StringBuffer();
			String line=null;
			do {
				 line=reader.readLine();
				 buffer.append(line);
			}while(line!=null);
			mailBody=buffer.toString();
			mailBody=mailBody.replace("{FULLNAME}", name);
			mailBody=mailBody.replace("{PWD}", password);
		    mailBody= mailBody.replace("{URL}", url);
			
		}//end try
		catch(Exception e) {
			 e.printStackTrace();
			 throw e;
		}
		  return mailBody;
		}//end of readmailBody()

	}
