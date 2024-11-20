package com.user.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.user.model.Fines;


public class FineDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/Library";
	private String jdbcUserName = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_FINE_SQL = "INSERT INTO FINES" + 
	"(loan_id,user_id,fine_amount,paid_status,payment_date) VALUES" + "(?,?,?,?,?);";
	private static final String SELECT_FINES_BY_ID = "SELECT * FROM FINES WHERE FINE_ID=?;";
	private static final String SELECT_ALL_FINES = "SELECT * FROM FINES;";
	private static final String DELETE_FINES_BY_ID = "DELETE FROM FINES WHERE FINE_ID=?;";
	private static final String UPDATE_FINES_SQL = "UPDATE FINES SET paid_status=?, payment_date=? where FINE_ID=?;";
	
	public FineDao() {
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
	
	public void addFines(Fines fine) {
		FineDao dao=new FineDao();
		
		try (Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_FINE_SQL);
			preparedStatement.setInt(1,fine.getLoanId());
			preparedStatement.setInt(2,fine.getUserId());
			preparedStatement.setBigDecimal(3, fine.getFineAmount());
			preparedStatement.setBoolean(4, fine.isPaidStatus());
			preparedStatement.setDate(5, fine.getPaymentDate() != null ? Date.valueOf(fine.getPaymentDate()) : null);
			
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Fines getFineByID(int fineId) {
		Fines fine=new Fines();
		FineDao dao=new FineDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_FINES_BY_ID);
			preparedStatement.setInt(1, fineId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				fine.setFineId(fineId);
				fine.setLoanId(resultSet.getInt("loan_id"));
				fine.setUserId(resultSet.getInt("user_id"));
				fine.setFineAmount(resultSet.getBigDecimal("fine_amount"));
				fine.setPaidStatus(resultSet.getBoolean("paid_status"));
				fine.setPaymentDate(resultSet.getDate("payment_date") != null ? resultSet.getDate("payment_date").toLocalDate() : null);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return fine;
	}
	
	public List<Fines> getAllFines(){
		List<Fines> fines=new ArrayList<Fines>();
		FineDao dao=new FineDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_FINES);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int fine_id=resultSet.getInt("fine_id");
				int loan_id=resultSet.getInt("loan_id");
				int user_id=resultSet.getInt("user_id");
				BigDecimal fine_amount=resultSet.getBigDecimal("fine_amount");
				boolean paid_status=resultSet.getBoolean("paid_status");
				LocalDate payment_date=resultSet.getDate("payment_date")!=null ? resultSet.getDate("payment_date").toLocalDate() : null;
				
				fines.add(new Fines(fine_id,loan_id,user_id,fine_amount,paid_status,payment_date));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return fines;
	}
	
	public boolean deleteFine(int fineId) {
		boolean status=false;
		FineDao dao=new FineDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_FINES_BY_ID);
			preparedStatement.setInt(1, fineId);
			
			status=preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean updateBook(Fines fine,int fineId, LocalDate paymentDate)
	{
		boolean status=false;
		FineDao dao=new FineDao();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_FINES_SQL);
			preparedStatement.setBoolean(1, fine.isPaidStatus());
			preparedStatement.setDate(3, paymentDate != null ? Date.valueOf(paymentDate) : null);
			preparedStatement.setInt(5, fine.getFineId());
			
			status=preparedStatement.executeUpdate()>0;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	
}
