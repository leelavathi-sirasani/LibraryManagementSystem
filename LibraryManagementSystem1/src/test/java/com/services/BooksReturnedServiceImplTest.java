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

import com.entities.BooksReturned;
import com.repository.BooksReturnedRepository;
@SpringBootTest
class BooksReturnedServImpTest {
	@Autowired
	BooksReturnedServiceImpl bookreturnservice;
	
	@MockBean
	BooksReturnedRepository repo;

	@Test
	void testReturnBooks() {
		BooksReturned br = new BooksReturned();
		
		br.setId(0);
		br.setBooks(null);
		br.setUsers(null);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus(null);
		br.setDelayedDays(0);
		Mockito.when(repo.save(br)).thenReturn(br);
		assertThat(bookreturnservice.returnBooks(br)).isEqualTo(br);
	}

	@Test
	void testUpdateReturnedBookDetails() throws Throwable {
		BooksReturned br = new BooksReturned();
	    br.setId(0);
	    br.setBooks(null);
	    br.setReturnedDate(null);
	    br.setDelayedDays(0);
	    br.setPenalty(0);
	    br.setPenaltyStatus(null);
	    Optional<BooksReturned> c2 =  Optional.of(br);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.save(br)).thenReturn(br);
		br.setBooks(null);
	    br.setReturnedDate(null);
	    br.setDelayedDays(0);
	    br.setPenalty(0);
	    br.setPenaltyStatus(null);
		assertThat(bookreturnservice.updateReturnedBookDetails(br)).isEqualTo(br);
		
	}

	@Test
	void testViewReturnedBooksList() {
        BooksReturned br = new BooksReturned();
		
		br.setId(0);
		br.setBooks(null);
		br.setUsers(null);
		br.setReturnedDate(null);
		br.setPenalty(0);
		br.setPenaltyStatus(null);
		br.setDelayedDays(0);
		
        BooksReturned br1 = new BooksReturned();
		
		br1.setId(0);
		br1.setBooks(null);
		br1.setUsers(null);
		br1.setReturnedDate(null);
		br1.setPenalty(0);
		br1.setPenaltyStatus(null);
		br1.setDelayedDays(0);
		List<BooksReturned> bookList = new ArrayList<BooksReturned>();
		bookList.add(br);
		bookList.add(br1);
		
		Mockito.when(repo.findAll()).thenReturn(bookList);
		assertThat(bookreturnservice.viewReturnedBooksList()).isEqualTo(bookList);
		
	}

	@Test
	void testViewDelayedBooksList() {
		 BooksReturned br = new BooksReturned();
			
			br.setId(0);
			br.setBooks(null);
			br.setUsers(null);
			br.setReturnedDate(null);
			br.setPenalty(0);
			br.setPenaltyStatus(null);
			br.setDelayedDays(0);
			
	        BooksReturned br1 = new BooksReturned();
			
			br1.setId(0);
			br1.setBooks(null);
			br1.setUsers(null);
			br1.setReturnedDate(null);
			br1.setPenalty(0);
			br1.setPenaltyStatus(null);
			br1.setDelayedDays(0);
			List<BooksReturned> bookList = new ArrayList<BooksReturned>();
			bookList.add(br);
			bookList.add(br1);
			
			Mockito.when(repo.findAll()).thenReturn(bookList);
			assertThat(bookreturnservice.viewDelayedBooksList()).isEqualTo(bookList);
	
	}

}
