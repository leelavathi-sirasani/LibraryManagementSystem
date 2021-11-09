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

import com.entities.Admin;
import com.entities.Books;
import com.entities.BooksOrder;
import com.entities.DamagedBooks;
import com.repository.AdminRepository;
import com.repository.BooksOrderRepository;
import com.repository.BooksRepository;
import com.repository.DamagedBooksRepository;
import com.repository.UsersRepository;
@SpringBootTest
class AdminServiceImpTest {
@Autowired
AdminService adminservice;
@MockBean
AdminRepository adminrepo;
@MockBean
BooksRepository booksrepo;
@MockBean 
BooksOrderRepository booksorderrepo;
@MockBean
DamagedBooksRepository damagedbookrepo;
@MockBean 
UsersRepository userrepo;
	@Test
	void testAddAdminDetails() {
		Admin ad=new Admin();
		ad.setAdminId(1);
		ad.setAdminName("Jahnavi");
		ad.setAdminPassword("jahnavi@1499");
		Mockito.when(adminrepo.save(ad)).thenReturn(ad);
		assertThat(adminservice.addAdminDetails(ad)).isEqualTo(ad);
	}

	/*
	 * @Test void testValidateUserDetails() { fail("Not yet implemented"); }
	 */

	@Test
	void testAddBooks() {
		Books b1 = new Books();
		b1.setBookid((long) 1);
		b1.setTitle("FairyTales");
		b1.setSubject("Cindrella");
		b1.setPublishedyear(2007);
		b1.setIsbncode("8974764348397");
		b1.setQuantity(1);
		b1.setBookcost(500);
		b1.setShelfdetails("row1");
		Mockito.when(booksrepo.save(b1)).thenReturn(b1);
		assertThat(adminservice.addBooks(b1)).isEqualTo(b1);
	}

	@Test
	void testUpdateBooks() throws Throwable {
		Books b1 = new Books();
		b1.setBookid((long) 1);
		b1.setTitle("FairyTales");
		b1.setSubject("Cindrella");
		b1.setPublishedyear(2007);
		b1.setIsbncode("8974764348397");
		b1.setQuantity(1);
		b1.setBookcost(500);
		b1.setShelfdetails("row1");
		
		Optional<Books> b2 =  Optional.of(b1);
		Mockito.when(booksrepo.findById((long) 1)).thenReturn(b2);
		Mockito.when(booksrepo.save(b1)).thenReturn(b1);
		b1.setBookid((long) 1);
		b1.setTitle("History");
		b1.setSubject("World History");
		b1.setPublishedyear(2005);
		b1.setIsbncode("8978964508397");
		b1.setQuantity(1);
		b1.setBookcost(1000);
		b1.setShelfdetails("row2");
		
		assertThat(adminservice.updateBooks(b1)).isEqualTo(b1);
	}

	@Test
	void testRemoveBooks() {
		Books b1 = new Books();
		b1.setBookid((long) 1);
		b1.setTitle("FairyTales");
		b1.setSubject("Cindrella");
		b1.setPublishedyear(2007);
		b1.setIsbncode("8974764348397");
		b1.setQuantity(1);
		b1.setBookcost(500);
		b1.setShelfdetails("row1");
		Optional<Books> b2=Optional.of(b1);
		Mockito.when(booksrepo.findById((long) 1)).thenReturn(b2);
		Mockito.when(booksrepo.existsById(b1.getBookid())).thenReturn(false);
		assertFalse(booksrepo.existsById(b1.getBookid()));
	}

	@Test
	void testAddBookorder() {
		BooksOrder bo = new BooksOrder();
		bo.setOrderId(1);
		bo.setOrderDate(null);
		bo.setOrderStatus("ordered");
		bo.setQuantity(1);
		Mockito.when(booksorderrepo.save(bo)).thenReturn(bo);
		assertThat(adminservice.addBook(bo)).isEqualTo(bo);
	}

	@Test
	void testUpdateBookorder() throws Throwable {
		BooksOrder bo = new BooksOrder();
		bo.setOrderId(1);
		bo.setOrderDate(null);
		bo.setOrderStatus("ordered");
		bo.setQuantity(1);
		Optional<BooksOrder> bord2 =  Optional.of(bo);
		Mockito.when(booksorderrepo.findById(1)).thenReturn(bord2);
		Mockito.when(booksorderrepo.save(bo)).thenReturn(bo);
		bo.setOrderDate(null);
		bo.setOrderStatus("ordered");
		bo.setQuantity(2);
		assertThat(adminservice.updateBook(bo)).isEqualTo(bo);
	}

	@Test
	void testRemoveBookorder() {
		BooksOrder bo = new BooksOrder();
		bo.setOrderId(1);
		bo.setOrderDate(null);
		bo.setOrderStatus("ordered");
		bo.setQuantity(1);
		Optional<BooksOrder> c2=Optional.of(bo);
		Mockito.when(booksorderrepo.findById(1)).thenReturn(c2);
		Mockito.when(booksorderrepo.existsById(bo.getOrderId())).thenReturn(false);
		assertFalse(booksorderrepo.existsById(bo.getOrderId()));
	}

	@Test
	void testViewDamagedBooksList() {
		DamagedBooks db = new DamagedBooks();
		db.setId(1);
		db.setDescription("missingpages");
		db.setQuantity(1);
		
		DamagedBooks db1 = new DamagedBooks();
		db1.setId(2);
		db1.setDescription("Book damaged");
		db1.setQuantity(1);
		
		List<DamagedBooks> damagedList = new ArrayList<DamagedBooks>();
		damagedList.add(db);
		damagedList.add(db1);
		
		Mockito.when(damagedbookrepo.findAll()).thenReturn(damagedList);
		assertThat(adminservice.viewDamagedBooksList()).isEqualTo(damagedList);
	}

	@Test
	void testViewDamagedBookById() throws Throwable {
		DamagedBooks db = new DamagedBooks();
		db.setId(1);
		db.setDescription("missingpages");
		db.setQuantity(1);
		Optional<DamagedBooks> c2 = Optional.of(db);
		Mockito.when(damagedbookrepo.findById(1)).thenReturn(c2);
		assertThat(adminservice.viewDamagedBookById(1)).isEqualTo(db);
	}

	@Test
	void testAddDamagedBooks() {
		DamagedBooks db = new DamagedBooks();
		db.setId(1);
		db.setDescription("missingpages");
		db.setQuantity(1);
		Mockito.when(damagedbookrepo.save(db)).thenReturn(db);
		assertThat(adminservice.addDamagedBooks(db)).isEqualTo(db);
	}

	 @Test void testGetBookByTitle() 
	  { 
		  Books b1 = new Books(); 
		  b1.setBookid((long)1); 
		  b1.setTitle("FairyTales"); 
		  b1.setSubject("Cindrella");
	      b1.setPublishedyear(2007); 
	      b1.setIsbncode("8974764348397");
	      b1.setQuantity(1); 
	      b1.setBookcost(500); 
	      b1.setShelfdetails("row1");
	      List<Books> bookList = new ArrayList<Books>(); 
	      bookList.add(b1);
	      Mockito.when(booksrepo.searchBookByTitle("FairyTales")).thenReturn(bookList);
	      assertThat(adminservice.searchBookByTitle("FairyTales")).isEqualTo(bookList); 
	  }
	  
	 /* @Test void testGetBookBySubject()
	  { 
		  Books b1 = new Books();
	      b1.setBookid((long) 1); 
	      b1.setTitle("FairyTales");
	      b1.setSubject("Cindrella");
	      b1.setPublished_year(2007);
	      b1.setIsbn_code("8974764348397");
	      b1.setQuantity(1); 
	      b1.setBook_cost(500);
	      b1.setShelf_details("row1");
	      List<Books> bookList = new ArrayList<Books>();
	      bookList.add(b1);
	      Mockito.when(booksrepo.searchBookBySubject("Cindrella")).thenReturn(bookList);
	      assertThat(adminservice.searchBookBySubject("Cindrella")).isEqualTo(bookList); }
	 
}*/
}

