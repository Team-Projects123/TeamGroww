package com.user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.user.model.Book;


public class BookDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/Library";
	private String jdbcUserName = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_BOOK_SQL = "INSERT INTO BOOKS" + 
	"(title,author,genre,publisher,isbn,copies_total,copies_available) VALUES" + "(?,?,?,?,?,?,?);";
	private static final String SELECT_BOOKS_BY_ID = "SELECT * FROM BOOKS WHERE BOOK_ID=?;";
	private static final String SELECT_ALL_BOOKS = "SELECT * FROM BOOKS;";
	private static final String DELETE_BOOKS_BY_ID = "DELETE FROM BOOKS WHERE BOOK_ID=?;";
	private static final String UPDATE_BOOKS_SQL = "UPDATE BOOKS SET TITLE=?, AUTHOR=?, GENRE=?, PUBLISHER=?, ISBN=?, COPIESTOTAL=?, COPIESAVAILABLE=? where BOOK_ID=?;";
	
	public BookDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	public void addBook(Book book) {
		BookDao dao=new BookDao();
		
		try (Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_BOOK_SQL);
			preparedStatement.setString(1,book.getTitle());
			preparedStatement.setString(2,book.getAuthor());
			preparedStatement.setString(3,book.getGenre());
			preparedStatement.setString(4,book.getPublisher());
			preparedStatement.setString(5,book.getIsbn());
			preparedStatement.setInt(6,book.getCopiesTotal());
			preparedStatement.setInt(7,book.getCopiesAvailable());
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Book getBookByID(int id) {
		Book book=new Book();
		BookDao dao=new BookDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_BOOKS_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				book.setId(id);
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setGenre(resultSet.getString("genre"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setCopiesTotal(resultSet.getInt("copies_total"));
				book.setCopiesAvailable(resultSet.getInt("copies_available"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public List<Book> getAllBooks(){
		List<Book> books=new ArrayList<Book>();
		BookDao dao=new BookDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_BOOKS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id=resultSet.getInt("id");
				String title=resultSet.getString("title");
				String author=resultSet.getString("author");
				String genre=resultSet.getString("genre");
				String publisher=resultSet.getString("publisher");
				String isbn=resultSet.getString("isbn");
				int copies_total=resultSet.getInt("copies_total");
				int copies_available=resultSet.getInt("copies_available");
				
				books.add(new Book(id,title,author,genre,publisher,isbn,copies_total,copies_available));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return books;
	}
	
	public boolean deleteBook(int id) {
		boolean status=false;
		BookDao dao=new BookDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_BOOKS_BY_ID);
			preparedStatement.setInt(1, id);
			
			status=preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean updateBook(Book book)
	{
		boolean status=false;
		BookDao dao=new BookDao();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_BOOKS_SQL);
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getGenre());
			preparedStatement.setString(4, book.getPublisher());
			preparedStatement.setString(5, book.getIsbn());
			preparedStatement.setInt(5, book.getCopiesTotal());
			preparedStatement.setInt(5, book.getCopiesAvailable());
			preparedStatement.setInt(5, book.getId());
			
			
			
			status=preparedStatement.executeUpdate()>0;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	
}
