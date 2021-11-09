package com.services;

import java.util.List;

import com.entities.UserAddress;

public interface UserAddressService {
	public UserAddress addUserAddress(UserAddress user);
	public UserAddress updateUserAddressDetails(UserAddress user);
	public String  deleteUserAddress(UserAddress address);
	public UserAddress viewAddressByUserId(int addressid);
	public List<UserAddress> viewUserAddressList();
	public List<UserAddress> viewUserAddressByPinCode(int pincode);
    public List<UserAddress> viewUserAddressByState(String state);
}