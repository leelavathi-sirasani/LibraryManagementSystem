package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.BooksReturned;
public interface BooksReturnedRepository extends JpaRepository<BooksReturned,Integer> {

}
