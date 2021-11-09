package com.services;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.AuthorNotFoundException;
import com.entities.Author;
import com.repository.AuthorRepository;
@Service
public class AuthorServiceImpl implements AuthorService {
      @Autowired
      private AuthorRepository authorrepo;
      
	@Override
	public Author addAuthorDetails(Author author) {
		authorrepo.save(author);
		return author;
	}

	@Override
	public Author updateAuthorDetails(Author author) throws Throwable{
		int authorId=author.getAuthorId();
		Supplier s1=()-> new AuthorNotFoundException("Author does not exist in the database");
		Author existingauthor=authorrepo.findById(authorId).orElseThrow(s1);
		existingauthor.setFirstName(author.getFirstName());
		existingauthor.setLastName(author.getLastName());
		existingauthor.setEmail(author.getEmail());
		existingauthor.setContactno(author.getContactno());
		authorrepo.save(author);
		return author;
	}

	@Override
	public String deleteAuthorDetails(Author author) {
		authorrepo.delete(author);
		return "deleted";
	}

	@Override
	public List<Author> viewAuthorsList() {
		List<Author> l1=authorrepo.findAll();
		return l1;
	}

	@Override
	public Author viewAuthorById(int authorId) throws Throwable {
	   Supplier s1=()-> new AuthorNotFoundException("Author does not exist in the database");
	   Author a1=authorrepo.findById(authorId).orElseThrow(s1);
		return a1;
	}

	@Override
	public Author getAuthorByFirstName(String firstName) {
		Author a1=authorrepo.findByFirstName(firstName);
		return a1;
	}

	@Override
	public List<Author> findByEmailSorted(String email) {
		List<Author> a1=authorrepo.findByEmailSorted(email);
		return a1;
	}

}