package io.virandry.search.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import io.virandry.search.model.Book;

public interface BookRepository extends SolrCrudRepository<Book, String> {
	
	public List<Book> findByAuthor(String author);
	
	@Query("author:*?0*")
	public Page<Book> findByAuthor(String author, Pageable pageable);
	
	@Query("author:*?0* OR name:*?0* OR name:*?0*")
    public Page<Book> findBySearchTerm(String searchTerm, Pageable pageable);
	
}
