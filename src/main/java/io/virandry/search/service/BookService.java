package io.virandry.search.service;

import java.util.List;

import io.virandry.search.model.Book;

public interface BookService {
	
	public List<Book> findByAuthor(String author);

	public List<Book> findByAuthor(String author, int page, int pageSize);

	public List<Book> findBySearchTerm(String searchTerm, int page, int pageSize);
}
