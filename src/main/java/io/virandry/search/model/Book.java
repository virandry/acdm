package io.virandry.search.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "booklist")
public class Book {
	
	@Id
	@Field
	private String id;
	
	@Field
	private String author;
	
	@Field
	private String series;
	
	@Field
	private String name;
	
	public Book() {
		super();
	}
	
	public Book(String id, String author, String series, String name) {
		super();
		this.id = id;
		this.author = author;
		this.series = series;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
