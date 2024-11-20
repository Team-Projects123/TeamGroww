package com.user.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.user.model.Loans;


public class LoanDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/Library";
	private String jdbcUserName = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_LOAN_SQL = "INSERT INTO BOOKS" + 
	"(book_id,user_id,issue_date,due_date,return_date) VALUES" + "(?,?,?,?,?);";
	private static final String SELECT_LOANS_BY_ID = "SELECT * FROM LOANS WHERE LOAN_ID=?;";
	private static final String SELECT_ALL_LOANS = "SELECT * FROM LOANS;";
	private static final String DELETE_LOANS_BY_ID = "DELETE FROM LOANS WHERE LOAN_ID=?;";
	private static final String UPDATE_LOANS_SQL = "UPDATE LOANS SET RETURN_DATE=? where LOAN_ID=?;";
	
	public LoanDao() {
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
	
	public void addLoan(Loans loan) {
		LoanDao dao=new LoanDao();
		
		try (Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_LOAN_SQL);
			preparedStatement.setInt(1,loan.getBookId());
			preparedStatement.setInt(2,loan.getUserId());
			preparedStatement.setDate(3,Date.valueOf(loan.getIssueDate()));
			preparedStatement.setDate(4,Date.valueOf(loan.getDueDate()));
			preparedStatement.setDate(5,Date.valueOf(loan.getReturnDate()));
			
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Loans getLoanByID(int loanId) {
		Loans loan=new Loans();
		LoanDao dao=new LoanDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_LOANS_BY_ID);
			preparedStatement.setInt(1, loanId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				loan.setLoanId(loanId);
				loan.setBookId(resultSet.getInt("book_id"));
				loan.setUserId(resultSet.getInt("user_id"));
				loan.setIssueDate(resultSet.getDate("issue_date").toLocalDate());
				loan.setDueDate(resultSet.getDate("due_date").toLocalDate());
				loan.setReturnDate(resultSet.getDate("return_date")!=null ? resultSet.getDate("return_date").toLocalDate():null);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return loan;
	}
	
	public List<Loans> getAllLoans(){
		List<Loans> loans=new ArrayList<Loans>();
		LoanDao dao=new LoanDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_LOANS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int loan_id=resultSet.getInt("loan_id");
				int book_id=resultSet.getInt("book_id");
				int user_id=resultSet.getInt("user_id");
				LocalDate issue_date=resultSet.getDate("issue_date").toLocalDate();
				LocalDate due_date=resultSet.getDate("due_date").toLocalDate();
				LocalDate return_date=resultSet.getDate("return_date")!=null ? resultSet.getDate("return_date").toLocalDate() : null;
				
				loans.add(new Loans(loan_id,book_id,user_id,issue_date,due_date,return_date));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return loans;
	}
	
	public boolean deleteLoan(int loanId) {
		boolean status=false;
		LoanDao dao=new LoanDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_LOANS_BY_ID);
			preparedStatement.setInt(1, loanId);
			
			status=preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean updateBook(Loans loan,int loanId, LocalDate returnDate)
	{
		boolean status=false;
		LoanDao dao=new LoanDao();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_LOANS_SQL);
			preparedStatement.setInt(1, loan.getBookId());
			preparedStatement.setInt(2, loan.getUserId());
			preparedStatement.setDate(3, returnDate != null ? Date.valueOf(returnDate) : null);
			preparedStatement.setInt(5, loan.getUserId());
			
			status=preparedStatement.executeUpdate()>0;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	
}
