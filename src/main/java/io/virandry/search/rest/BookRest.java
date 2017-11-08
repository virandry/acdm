package io.virandry.search.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.virandry.search.model.Book;
import io.virandry.search.service.BookService;
import io.virandry.search.util.Util;

@RestController
public class BookRest extends AbstractRest {

	@Autowired
	private BookService bookService;

	@GetMapping(path = "books", produces = "application/json")
	public ResponseEntity<?> searchByAuthor(@RequestParam(value = "author", required = true) String author) {
		List<Book> books = bookService.findByAuthor(author);

		if (Util.isEmpty(books)) {
			return ResponseEntity.ok(getErrorResponse());
		}
		return ResponseEntity.ok(books);
	}

	@GetMapping(path = "books/{page}/{pageSize}", produces = "application/json")
	public ResponseEntity<?> searchByAuthorPagination(@PathVariable int page, @PathVariable int pageSize,
			@RequestParam(value = "author", required = false) String author,
			@RequestParam(value = "q", required = false) String q) {
		List<Book> books;
		page -= 1;
		
		if (Util.isEmpty(q)) {
			if (Util.isEmpty(author)) {
				author = "";
			}
			books = bookService.findByAuthor(author, page, pageSize);
		} else {
			books = bookService.findBySearchTerm(q, page, pageSize);	
		}
		
		if (Util.isEmpty(books)) {
			return ResponseEntity.ok(getErrorResponse());
		}
		return ResponseEntity.ok(books);
	}

}
