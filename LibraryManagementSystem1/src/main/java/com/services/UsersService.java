package com.services;

import java.util.List;

import com.entities.Users;

public interface UsersService {
	public Users registerUserDetails(Users user);
	public Users loginValidate(Users user) throws Throwable;
	//public Users cancelSubscription(Users user);
	//public int payThePenalty(int userid, double amount);
	public List<Users> viewAllUsers();
	public Users updateUserDetails(Users user);
	public Users deleteUserDetails(Users user);
	 public Users findByEmail(String email) ;
	
}