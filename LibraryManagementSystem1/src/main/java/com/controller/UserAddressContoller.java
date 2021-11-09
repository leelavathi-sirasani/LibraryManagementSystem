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


import com.entities.UserAddress;
import com.services.UserAddressService;

@RestController
@RequestMapping("/lms")
public class UserAddressContoller {
	@Autowired
	UserAddressService useraddservice;
	
	@PostMapping("/adduseraddress")
		public ResponseEntity<UserAddress> addUserAddress(@RequestBody UserAddress a) {
		 UserAddress a1=useraddservice.addUserAddress(a );
		 ResponseEntity re=new ResponseEntity<UserAddress>(a1,HttpStatus.OK);
		 return re;
	}
	@PutMapping("/updateuseraddress")
	
		public ResponseEntity<UserAddress> updateUserAddressDetails(@RequestBody UserAddress u2)throws Throwable
		{
			UserAddress u1= useraddservice.updateUserAddressDetails(u2); 
			ResponseEntity re = new ResponseEntity<UserAddress>(u1,HttpStatus.OK);
			return re;
			
		}
	 @DeleteMapping("/deleteuseraddres")
	  public ResponseEntity<UserAddress> deleteUserAddress(@RequestBody UserAddress d2){
	   useraddservice.deleteUserAddress(d2);
	   ResponseEntity re =new ResponseEntity<String>("deleted",HttpStatus.OK);
	   return re;
	 
	}
	 @GetMapping("/viewuseraddress")
	 public ResponseEntity<List<UserAddress>> viewUserAddressList(){
		 List<UserAddress> v2=useraddservice.viewUserAddressList();
		 ResponseEntity re =new ResponseEntity<List<UserAddress>>(v2,HttpStatus.OK);
		 return re;
		 
	 }
	 @GetMapping("/viewuseraddressid/{addressid}")
     public ResponseEntity<UserAddress> viewAddressListByUserId(@PathVariable int addressid) {
		 UserAddress a1=useraddservice.viewAddressByUserId(addressid);
		 ResponseEntity re = new ResponseEntity<UserAddress>(a1,HttpStatus.OK);
		 return re;
	 }
	 @GetMapping("/viewuseraddresslist/state")
	 public ResponseEntity<List<UserAddress>> viewUserAddressByState(String state){
	  List<UserAddress> v2 =useraddservice.viewUserAddressByState(state);
	  ResponseEntity re =new ResponseEntity<List<UserAddress>>(v2,HttpStatus.OK);
		 return re;
	 }
	 @GetMapping("/viewuseraddresslist/pincode")
	 public ResponseEntity<List<UserAddress>> viewUserAddressByPinCode(int pincode){
	  List<UserAddress> v2 =useraddservice.viewUserAddressByPinCode(pincode);
	  ResponseEntity re =new ResponseEntity<List<UserAddress>>(v2,HttpStatus.OK);
		 return re;
	 }
}