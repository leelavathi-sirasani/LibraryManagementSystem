package com.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.Users;
import com.repository.UsersRepository;


@SpringBootTest
class UsersServiceImplTest {
	@Autowired
	UsersService userservice;
	@MockBean
	UsersRepository userrepo;

	@Test
	void testRegisterUserDetails() {
		Users ur = new Users();
		ur.setFirstName("Jayasri");
		ur.setLastName("Sadurla");
		ur.setEmail("jayasri02@gmail.com");
		ur.setPassword("jaya@123");
		ur.setDateofBirth(null);
		ur.setMobileno("9876543220");
		ur.setSubexpiredate(null);
		ur.setSubscriptiondate(null);
		ur.setSubscriptionstatus("valid");
		ur.setUserid(1);
		Mockito.when(userrepo.save(ur)).thenReturn(ur);
		assertThat(userservice.registerUserDetails(ur)).isEqualTo(ur);
		
	}

	@Test
	void testViewAllUsers() {
		Users ur = new Users();
		ur.setFirstName("Jayasri");
		ur.setLastName("Sadurla");
		ur.setEmail("jayasri02@gmail.com");
		ur.setPassword("jaya@123");
		ur.setDateofBirth(null);
		ur.setMobileno("9876543220");
		ur.setSubexpiredate(null);
		ur.setSubscriptiondate(null);
		ur.setSubscriptionstatus("valid");
		ur.setUserid(1);
		
		Users ur1=new Users();
		ur1.setFirstName("Jayasri");
		ur1.setLastName("Sadurla");
		ur1.setEmail("jayasri02@gmail.com");
		ur1.setPassword("jaya@123");
		ur1.setDateofBirth(null);
		ur1.setMobileno("9876543220");
		ur1.setSubexpiredate(null);
		ur1.setSubscriptiondate(null);
		ur1.setSubscriptionstatus("valid");
		ur1.setUserid(1);
		
		List<Users> userlist=new ArrayList<Users>();
		userlist.add(ur);
		userlist.add(ur1);
		
		Mockito.when(userrepo.findAll()).thenReturn(userlist);
		assertThat(userservice.viewAllUsers()).isEqualTo(userlist);
	}

	@Test
	void testUpdateUserDetails() {
		Users ur = new Users();
		ur.setFirstName("Jayasri");
		ur.setLastName("Sadurla");
		ur.setEmail("jayasri02@gmail.com");
		ur.setPassword("jaya@123");
		ur.setDateofBirth(null);
		ur.setMobileno("9876543220");
		ur.setSubexpiredate(null);
		ur.setSubscriptiondate(null);
		ur.setSubscriptionstatus("valid");
		ur.setUserid(1);
		Optional<Users> u1 =  Optional.of(ur);
		Mockito.when(userrepo.findById(1)).thenReturn(u1);
		Mockito.when(userrepo.save(ur)).thenReturn(ur);
		ur.setFirstName("Tanuja");
		ur.setLastName("Chava");
		ur.setEmail("tanuja28@gmail.com");
		ur.setPassword("tanu@24");
		ur.setDateofBirth(null);
		ur.setMobileno("9876864360");
		
		ur.setSubscriptiondate(null);
		ur.setSubscriptionstatus("valid");
		ur.setUserid(1);
		assertThat(userservice.updateUserDetails(ur)).isEqualTo(ur);
	}

	@Test
	void testDeleteUserDetails() {
		Users ur = new Users();
		ur.setFirstName("Jayasri");
		ur.setLastName("Sadurla");
		ur.setEmail("jayasri02@gmail.com");
		ur.setPassword("jaya@123");
		ur.setDateofBirth(null);
		ur.setMobileno("9876543220");
		ur.setSubexpiredate(null);
		ur.setSubscriptiondate(null);
		ur.setSubscriptionstatus("valid");
		ur.setUserid(1);
		Optional<Users> u1 =  Optional.of(ur);
		Mockito.when(userrepo.findById(1)).thenReturn(u1);
		Mockito.when(userrepo.existsById(ur.getUserid())).thenReturn(false);
		assertFalse(userrepo.existsById(ur.getUserid()));
	}

	@Test
	void testFindByEmail() {
		Users ur = new Users();
		ur.setFirstName("Jayasri");
		ur.setLastName("Sadurla");
		ur.setEmail("jayasri02@gmail.com");
		ur.setPassword("jaya@123");
		ur.setDateofBirth(null);
		ur.setMobileno("9876543220");
		ur.setSubexpiredate(null);
		ur.setSubscriptiondate(null);
		ur.setSubscriptionstatus("valid");
		ur.setUserid(1);
		Mockito.when(userrepo.findByEmail("jayasri02@gmail.com")).thenReturn(ur);
		assertThat(userservice.findByEmail("jayasri02@gmail.com")).isEqualTo(ur);
	}
	/*
	 * @Test void testLoginValidate() {
	 * 
	 * }
	 */
}
