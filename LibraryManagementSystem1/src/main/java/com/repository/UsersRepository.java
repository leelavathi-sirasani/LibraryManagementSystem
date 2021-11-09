package com.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.entities.Users;




@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
	@Query("select users from Users users order by users.email")
	Users findByEmail(String email);
	
}
