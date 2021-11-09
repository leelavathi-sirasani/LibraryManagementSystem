package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.DamagedBooks;



public interface DamagedBooksRepository  extends JpaRepository<DamagedBooks,Integer>{

}
