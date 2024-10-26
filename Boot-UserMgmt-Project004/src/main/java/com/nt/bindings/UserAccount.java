package com.nt.bindings;


import java.time.LocalDate;

import lombok.Data;
@Data
public class UserAccount {
	 private Integer userId;
	  private String name;
	  private String mail;
	  private LocalDate dob;
	  private Long contactNo;
	  private String gender;
	 
}
