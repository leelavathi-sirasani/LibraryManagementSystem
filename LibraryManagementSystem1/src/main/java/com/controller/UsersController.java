package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Users;
import com.services.UsersService;



@RestController
@RequestMapping(path="/lms")
public class UsersController {
	@Autowired
	UsersService userservice;
	@PostMapping("/registrationdetails")
	public ResponseEntity<Users> registerUserDetails(@RequestBody Users user) 
	{
		Users u1=userservice.registerUserDetails(user); 
		ResponseEntity re = new ResponseEntity<Users>(u1,HttpStatus.OK);	
		return re;		
	}
	@DeleteMapping("/deleteUser")
      public ResponseEntity<Users> deleteUserDetails( @RequestBody Users user){
    	Users u1= userservice.deleteUserDetails(user); 
    	 ResponseEntity re  = new ResponseEntity<String>("deleted",HttpStatus.OK);
       return re;
      }
   @PutMapping("/updateUser")
   public ResponseEntity<Users> updateUserDetails(@RequestBody Users user)throws Throwable
   {
	   
   Users e1=userservice.updateUserDetails(user);
   ResponseEntity re = new ResponseEntity<Users>(e1,HttpStatus.OK);
   return re;
	   
   }
   @GetMapping("/viewuserslist")
   
	 public ResponseEntity<List<Users>> viewAllUsersList() {
	   List<Users> db3=userservice.viewAllUsers();
		ResponseEntity re = new ResponseEntity<List<Users>>(db3,HttpStatus.OK);
		return re;
   }
   @PostMapping("/loginvalidate")
   public ResponseEntity<Users> loginValidate(@RequestBody Users user) throws Throwable
   {
	   Users login=userservice.loginValidate(user);
	   ResponseEntity re = new ResponseEntity<Users>(login,HttpStatus.OK);
	   return re;
   }
   @GetMapping("/findbyemail")
   public ResponseEntity<Users> findByEmail(String email){
	  Users u1 = userservice.findByEmail(email);
	   ResponseEntity re = new ResponseEntity<Users>(u1,HttpStatus.OK);
	   return re;
   }
}
