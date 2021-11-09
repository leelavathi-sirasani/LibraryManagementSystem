package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.UserAddress;


@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress,Integer> {

@Query("Select useraddress from UserAddress useraddress order by useraddress.pincode")	
List<UserAddress> findByUserAddressByPinCode(int pincode);
	
	@Query("Select useraddress from UserAddress useraddress order by useraddress.state")
	List<UserAddress> findByUserAddressByState(String state);

}
