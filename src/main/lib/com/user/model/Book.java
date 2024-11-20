package com.user.model;

public class Book {
	
	private int id;
	private String title;
	private String author;
	private String genre;
	private String publisher;
	private String isbn;
	private int copiesTotal;
	private int copiesAvailable;
	
	// Default constructor
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Constructor with all fields
	public Book(int id, String title, String author, String genre, String publisher, String isbn, int copiesTotal,
			int copiesAvailable) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.isbn= isbn;
		this.copiesTotal = copiesTotal;
		this.copiesAvailable = copiesAvailable;
	}
	
	// Constructor with all fields
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn= isbn;
	}

	public int getCopiesTotal() {
		return copiesTotal;
	}

	public void setCopiesTotal(int copiesTotal) {
		this.copiesTotal = copiesTotal;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	
	public boolean isAvailable() {
		return copiesAvailable>0;
	}
	
	public boolean borrowBook() {
		if(isAvailable()) {
			copiesAvailable--;
			return true;
		}
		return false;
	}
	
	public void returnBook() {
		if(copiesAvailable<copiesTotal) {
			copiesAvailable++;
		}
	}
	
	//Print book details
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", publisher="
				+ publisher + ", copiesTotal=" + copiesTotal + ", copiesAvailable=" + copiesAvailable + "]";
	}
	
	
}
