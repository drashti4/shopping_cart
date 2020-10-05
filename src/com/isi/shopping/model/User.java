package com.isi.shopping.model;

import java.util.HashMap;

public class User {
	
	 private HashMap<String, String> validUsers = new HashMap<String, String>();
	 
	 public User() {
		 validUsers.put("admin","admin");
	 }
	 public boolean validateUser(String userName, String pwd) {
		 for (String name : validUsers.keySet()) {
			  if(name.equalsIgnoreCase(userName) && validUsers.get(name).equalsIgnoreCase(pwd)) {
				  return true;
			  }
			}
		 return false;
	 }

}
