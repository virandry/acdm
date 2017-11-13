package io.virandry.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.Gson;

import io.virandry.search.model.Book;
import io.virandry.search.service.BookService;

/*
 * Previously I combined the front end in one package
 * Front-end is moved to nodejs environment
 * 
 * */

@Controller
@Scope("request")
public class SearchController extends AbstractController {
	
	@Autowired
	private BookService bookService;

	//only use for dev logging purpose
	@Autowired
	private Gson gson;
	
	@GetMapping("/index")
	public String indexPage(Model model) {
		logInfo("displaying index.html");
		
		List<Book> books = bookService.findByAuthor("Mark Greaney");
		logInfo(gson.toJson(books));
		
		books = bookService.findByAuthor("Terry", 0, 20);
		logInfo(gson.toJson(books));
		
		books = bookService.findBySearchTerm("sa", 0, 20);
		logInfo(gson.toJson(books));
		
		return "index";
	}
}
