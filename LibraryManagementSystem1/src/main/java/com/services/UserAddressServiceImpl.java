package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.UserAddress;
import com.repository.UserAddressRepository;
@Service
public class UserAddressServiceImpl implements UserAddressService {
	@Autowired 
	UserAddressRepository useraddressrepo;
	
	@Override
	public UserAddress addUserAddress(UserAddress user) {
		useraddressrepo.save(user);
		 return user;
	}

	@Override
	public UserAddress updateUserAddressDetails(UserAddress user) {
		int userid= user.getAddressId();
		UserAddress a1 = useraddressrepo.findById(userid).orElseThrow();
		a1.setAddress(user.getAddress());
		a1.setAddressId(user.getAddressId());
		a1.setCity(user.getCity());
		a1.setPincode(user.getPincode());
		a1.setState(user.getState());
		a1.setUsers(user.getUsers());
		useraddressrepo.save(user);
		return a1;
	}

	@Override
	public String deleteUserAddress(UserAddress address) {
		useraddressrepo.delete(address);
		return "Deleted";
	}

	@Override
	public UserAddress viewAddressByUserId(int addressid) {
		UserAddress a=useraddressrepo.findById(addressid).orElseThrow();
		return a;
	}

	@Override
	public List<UserAddress> viewUserAddressList() {
		List<UserAddress> l = useraddressrepo.findAll();
		return l;
	}
	@Override
	public List<UserAddress> viewUserAddressByPinCode(int pincode) {
		List<UserAddress> pin=useraddressrepo.findAll();
		return pin;
	}

	@Override
	public List<UserAddress> viewUserAddressByState(String state) {
		List<UserAddress> st=useraddressrepo.findAll();
		return st;
	}

}
