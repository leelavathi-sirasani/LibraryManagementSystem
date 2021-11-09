/**
 * 
 */
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

import com.entities.BooksIssued;
import com.repository.BooksIssuedRepository;
@SpringBootTest
class BookIssuedServImpTest {
	
	@Autowired
	BooksIssuedServiceImpl bookissuedserv;
	
	@MockBean
	BooksIssuedRepository repo;

	@Test
	void testAddIssuedBook() {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(1);
		bi.setBooks(null);;
		bi.setUsers(null);
		bi.setIssueDate(null);
		bi.setDueDate(null);
		bi.setQuantity(0);
		Mockito.when(repo.save(bi)).thenReturn(bi);
		assertThat(bookissuedserv.addIssuedBook(bi)).isEqualTo(bi);
	}

	@Test
	void testUpdateIssuedBookDetails() throws Throwable {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(0);
		bi.setBooks(null);
		bi.setUsers(null);
		bi.setIssueDate(null);
		bi.setDueDate(null);
		bi.setQuantity(0);
		
		
		Optional<BooksIssued> b2 =  Optional.of(bi);
		Mockito.when(repo.findById(null)).thenReturn(b2);
		Mockito.when(repo.save(bi)).thenReturn(bi);
		
		
		assertThat(bookissuedserv.updateIssuedBookDetails(bi)).isEqualTo(bi);
		
	}

	@Test
	void testDeleteIssuedBooks() {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(0);
		bi.setBooks(null);
		bi.setUsers(null);
		bi.setIssueDate(null);
		bi.setDueDate(null);
		bi.setQuantity(0);
		Optional<BooksIssued> b2=Optional.of(bi);
		Mockito.when(repo.findById(null)).thenReturn(b2);
		Mockito.when(repo.existsById(bi.getIssueId())).thenReturn(false);
		assertFalse(repo.existsById(bi.getIssueId()));
		
	}

	@Test
	void testViewBooksIssuedList() {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(0);
		bi.setBooks(null);
		bi.setUsers(null);
		bi.setIssueDate(null);
		bi.setDueDate(null);
		bi.setQuantity(0);
		
		BooksIssued bi1 = new BooksIssued();
		bi1.setIssueId(0);
		bi1.setBooks(null);
		bi1.setUsers(null);
		bi1.setIssueDate(null);
		bi1.setDueDate(null);
		bi1.setQuantity(0);
		
		
		List<BooksIssued> bookissueList = new ArrayList<BooksIssued>();
		bookissueList.add(bi);
		bookissueList.add(bi1);
		
		Mockito.when(repo.findAll()).thenReturn(bookissueList);
		assertThat(bookissuedserv.viewBooksIssuedList()).isEqualTo(bookissueList);
		
	}

	@Test
	void testFindByIssueId() {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(0);
		bi.setBooks(null);
		bi.setUsers(null);
		bi.setIssueDate(null);
		bi.setDueDate(null);
		bi.setQuantity(0);
		
		Optional<BooksIssued> c2 = Optional.of(bi);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		assertThat(bookissuedserv.findByIssueId(1)).isEqualTo(bi);
	
	}

	/*
	 * @Test void testFindByQuantitySorted() { fail("Not yet implemented"); }
	 */
}