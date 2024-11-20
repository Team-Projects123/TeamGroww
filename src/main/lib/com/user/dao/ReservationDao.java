package com.user.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.user.model.Reservations;


public class ReservationDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/Library";
	private String jdbcUserName = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_RESERVATION_SQL = "INSERT INTO RESERVATIONS" + 
	"(user_id,book_id,reservation_date,status) VALUES" + "(?,?,?,?);";
	private static final String SELECT_RESERVATIONS_BY_ID = "SELECT * FROM RESERVATIONS WHERE RESERVATION_ID=?;";
	private static final String SELECT_ALL_RESERVATIONS = "SELECT * FROM RESERVATIONS;";
	private static final String DELETE_RESERVATIONS_BY_ID = "DELETE FROM RESERVATIONS WHERE RESERVATION_ID=?;";
	private static final String UPDATE_RESERVATIONS_SQL = "UPDATE RESERVATIONS SET STATUS=? where RESERVATION_ID=?;";
	
	public ReservationDao() {
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
	
	public void addReservation(Reservations reservation) {
		ReservationDao dao=new ReservationDao();
		
		try (Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_RESERVATION_SQL);
			preparedStatement.setInt(1,reservation.getUserId());
			preparedStatement.setInt(2,reservation.getBookId());
			preparedStatement.setDate(3,Date.valueOf(reservation.getReservationDate()));
			preparedStatement.setString(4,reservation.getStatus());
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Reservations getReservationByID(int reservationId) {
		Reservations reservation=new Reservations();
		ReservationDao dao=new ReservationDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_RESERVATIONS_BY_ID);
			preparedStatement.setInt(1, reservationId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				reservation.setReservationId(reservationId);
				reservation.setUserId(resultSet.getInt("user_id"));
				reservation.setBookId(resultSet.getInt("book_id"));
				reservation.setReservationDate(resultSet.getDate("reservation_date").toLocalDate());
				reservation.setStatus(resultSet.getString("status"));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return reservation;
	}
	
	public List<Reservations> getAllReservations(){
		List<Reservations> reservations=new ArrayList<Reservations>();
		ReservationDao dao=new ReservationDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_RESERVATIONS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int loan_id=resultSet.getInt("reservation_id");
				int book_id=resultSet.getInt("book_id");
				int user_id=resultSet.getInt("user_id");
				LocalDate reservation_date=resultSet.getDate("reservation_date").toLocalDate();
				String status=resultSet.getString("status");
				
				reservations.add(new Reservations(loan_id,book_id,user_id,reservation_date,status));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return reservations;
	}
	
	public boolean deleteReservation(int reservationId) {
		boolean status=false;
		ReservationDao dao=new ReservationDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_RESERVATIONS_BY_ID);
			preparedStatement.setInt(1, reservationId);
			
			status=preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean updateBook(Reservations resrvation,int resrvationId)
	{
		boolean status=false;
		LoanDao dao=new LoanDao();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_RESERVATIONS_SQL);
			preparedStatement.setString(1, resrvation.getStatus());
			preparedStatement.setInt(2, resrvation.getReservationId());
			
			status=preparedStatement.executeUpdate()>0;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	
}
