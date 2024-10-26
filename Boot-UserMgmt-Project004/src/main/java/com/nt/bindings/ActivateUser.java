package com.nt.bindings;

import lombok.Data;

@Data
public class ActivateUser {
   private String name;	
   private String mail;
   private String newPassword;
   private String confirmPassword;
}
