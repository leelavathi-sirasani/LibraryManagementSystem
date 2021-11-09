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

import com.entities.Books;
import com.repository.BooksRepository;




@SpringBootTest
class BooksServImpTest {
	
	@Autowired
	BooksServiceImpl bookservice;
	
	@MockBean
	BooksRepository repo;

	@Test
	void testAddBook() {
		Books b1 = new Books();
		b1.setBookid(null);
		b1.setTitle("GameofThrones");
		b1.setSubject("fhfh");
		b1.setPublishedyear(2007);
		b1.setIsbncode(null);
		b1.setQuantity(0);
		b1.setBookcost(0);
		//b1.setAuthors(null);
		b1.setShelfdetails(null);
		Mockito.when(repo.save(b1)).thenReturn(b1);
		assertThat(bookservice.addBook(b1)).isEqualTo(b1);
	}

	@Test
	void testUpdateBookDetails() throws Throwable {
		Books b1 = new Books();
		b1.setBookid(null);
		b1.setTitle("GameofThrones");
		b1.setSubject("fhfh");
		b1.setPublishedyear(2007);
		b1.setIsbncode(null);
		b1.setQuantity(0);
		b1.setBookcost(0);
		//b1.setAuthors(null);
		b1.setShelfdetails(null);
		Optional<Books> b2 =  Optional.of(b1);
		Mockito.when(repo.findById(null)).thenReturn(b2);
		Mockito.when(repo.save(b1)).thenReturn(b1);
		b1.setTitle("Thrones");
		b1.setSubject("fhfh");
		b1.setPublishedyear(2007);
		b1.setIsbncode(null);
		b1.setQuantity(0);
		b1.setBookcost(0);
		//b1.setAuthors(null);
		b1.setShelfdetails(null);
		
		assertThat(bookservice.updateBookDetails(b1)).isEqualTo(b1);
	}

	@Test
	void testRemoveBook() {
		Books b1 = new Books();
		b1.setBookid(null);
		b1.setTitle("GameofThrones");
		b1.setSubject("fhfh");
		b1.setPublishedyear(2007);
		b1.setIsbncode(null);
		b1.setQuantity(0);
		b1.setBookcost(0);
		//b1.setAuthors(null);
		b1.setShelfdetails(null);
		Optional<Books> b2=Optional.of(b1);
		Mockito.when(repo.findById(null)).thenReturn(b2);
		Mockito.when(repo.existsById(b1.getBookid())).thenReturn(false);
		assertFalse(repo.existsById(b1.getBookid()));
		
	}

	@Test
	void testSearchBookByTitle() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchBookBySubject() {
		fail("Not yet implemented");
	}

	@Test
	void testViewAllBooks() {
		Books b1 = new Books();
		b1.setBookid(null);
		b1.setTitle("GameofThrones");
		b1.setSubject("fhfh");
		
		b1.setPublishedyear(2007);
		b1.setIsbncode(null);
		b1.setQuantity(0);
		b1.setBookcost(0);
		//b1.setAuthors(null);
		b1.setShelfdetails(null);
		
		Books b2 = new Books();
		b2.setBookid(null);
		b2.setTitle("GameofThrones");
		b2.setSubject("fhfh");
	
		b2.setPublishedyear(2007);
		b2.setIsbncode(null);
		b2.setQuantity(0);
		b2.setBookcost(0);
		//b2.setAuthors(null);
		b2.setShelfdetails(null);
		
		List<Books> bookList = new ArrayList<Books>();
		bookList.add(b1);
		bookList.add(b2);
		
		Mockito.when(repo.findAll()).thenReturn(bookList);
		assertThat(bookservice.viewAllBooks()).isEqualTo(bookList);
		
	}

}
