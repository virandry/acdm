package io.virandry.search.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.virandry.search.model.Book;
import io.virandry.search.repo.BookRepository;
import io.virandry.search.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findByAuthor(String author, int page, int pageSize) {
		Page<Book> books = bookRepository.findByAuthor(author, new PageRequest(page, pageSize));
		if (books.getNumberOfElements() > 0) {
			return books.getContent();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Book> findBySearchTerm(String searchTerm, int page, int pageSize) {
		Page<Book> books = bookRepository.findBySearchTerm(searchTerm, new PageRequest(page, pageSize));
		if (books.getNumberOfElements() > 0) {
			return books.getContent();
		}
		return new ArrayList<>();
	}

}
