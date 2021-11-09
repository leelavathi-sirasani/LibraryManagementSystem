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

import com.entities.Author;
import com.repository.AuthorRepository;

@SpringBootTest
class AuthorServImpTest {
	
	@Autowired
	AuthorServiceImpl authorservice;
	
	@MockBean
	AuthorRepository repo;

	@Test
	void testAddAuthorDetails() {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Kalyan");
		aut.setLastName("Ullangula");
		aut.setContactno("2452782939");
		aut.setEmail("kalyan@gmail.com");
		Mockito.when(repo.save(aut)).thenReturn(aut);
		assertThat(authorservice.addAuthorDetails(aut)).isEqualTo(aut);
		
	}

	@Test
	void testUpdateAuthorDetails() throws Throwable {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Kalyan");
		aut.setLastName("Ullangula");
		aut.setContactno("2452782939");
		aut.setEmail("kalyan@gmail.com");
		Optional<Author> aut2 =  Optional.of(aut);
		Mockito.when(repo.findById(1)).thenReturn(aut2);
		Mockito.when(repo.save(aut)).thenReturn(aut);
		aut.setFirstName("Kal");
		aut.setLastName("ALlaa");
		aut.setContactno("2452787339");
		aut.setEmail("kalyanad@gmail.com");
	
		assertThat(authorservice.updateAuthorDetails(aut)).isEqualTo(aut);
	}

	@Test
	void testDeleteAuthorDetails() {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Kalyan");
		aut.setLastName("Ullangula");
		aut.setContactno("2452782939");
		aut.setEmail("kalyan@gmail.com");
		Optional<Author> c2=Optional.of(aut);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.existsById(aut.getAuthorId())).thenReturn(false);
		assertFalse(repo.existsById(aut.getAuthorId()));
	}

	@Test
	void testViewAuthorsList() {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Kalyan");
		aut.setLastName("Ullangula");
		aut.setContactno("2452782939");
		aut.setEmail("kalyan@gmail.com");
		
		Author aut1 = new Author();
		aut1.setAuthorId(1);
		aut1.setFirstName("Zahid");
		aut1.setLastName("Shaik");
		aut1.setContactno("9852782939");
		aut1.setEmail("zahid@gmail.com");
		
		List<Author> authorList = new ArrayList<Author>();
		authorList.add(aut);
		authorList.add(aut1);
		
		Mockito.when(repo.findAll()).thenReturn(authorList);
		assertThat(authorservice.viewAuthorsList()).isEqualTo(authorList);

	}

	@Test
	void testViewAuthorById() {
		Author aut = new Author();
		aut.setAuthorId(1);
		aut.setFirstName("Kalyan");
		aut.setLastName("Ullangula");
		aut.setContactno("2452782939");
		aut.setEmail("kalyan@gmail.com");
	
		Optional<Author> c2 = Optional.of(aut);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		assertThat(authorservice.viewAuthorsList()).isEqualTo(aut);
	}

	/*
	 * @Test void testGetAuthorByFirstName() { fail("Not yet implemented"); }
	 * 
	 * @Test void testFindByEmailSorted() { fail("Not yet implemented"); }
	 */

}
