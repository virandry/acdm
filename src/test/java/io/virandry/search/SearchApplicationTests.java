package io.virandry.search;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.virandry.search.model.Book;
import io.virandry.search.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private BookService bookService;
	
	@Test
    public void testFindByAuthor() throws Exception {
        
        List<Book> indexedBooks = bookService.findByAuthor("Terry");
        assertTrue(indexedBooks.size()>0);
    }

}
