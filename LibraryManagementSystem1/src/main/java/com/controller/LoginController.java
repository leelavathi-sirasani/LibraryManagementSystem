package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Login;
import com.services.LoginService;
@RestController
@RequestMapping("/lms")
public class LoginController {
	@Autowired
	LoginService loginservice;
	
	@PostMapping("/addLoginDetails")
	public ResponseEntity<Login>  addLoginDetails(@RequestBody Login lo) {
		Login l=loginservice.addLoginDetails(lo);
		ResponseEntity<Login> re=new ResponseEntity <Login>(l,HttpStatus.OK);
		return re;
		
	}
	
	@PutMapping(path="/updateLoginDetails")
	public ResponseEntity<Login> updateLoginDetails(@RequestBody Login l) throws Throwable{
		Login up=loginservice.updateLoginDetails(l);
		ResponseEntity<Login> re=new ResponseEntity <Login>(up,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteLoginDetails")
	public ResponseEntity<String> deleteLoginDetails(@RequestBody Login del){
		loginservice.deleteLoginDetails(del);
		ResponseEntity re=new ResponseEntity<String>("deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/ViewusersList")
	public ResponseEntity<List<Login>> viewloginlist(){
		List<Login> lc1=loginservice.viewloginList();
		ResponseEntity<List<Login>> re=new ResponseEntity <List<Login>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/ViewusersbyId/{loginid}")
	public ResponseEntity<Login> viewuserById(@PathVariable int loginid ) throws Throwable 
	{
		Login u=loginservice.viewusersbyid(loginid);
		ResponseEntity< Login> re=new ResponseEntity<Login>(u,HttpStatus.OK);
		return re;
		
	}
	
	@GetMapping(path="/viewusersbyName/{userName}")
	public ResponseEntity<Login> getByUserName(@PathVariable String userName ) 
	{
		Login l=loginservice.findByUserName(userName);
		ResponseEntity re=new ResponseEntity<Login>(l,HttpStatus.OK);
		return re;
	}
	
	

}