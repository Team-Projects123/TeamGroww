package com.user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.user.model.*;
public class UserDao {
	
	private String jdbcURL="jdbc:mysql://localhost:30006/Library";
	private String jdbcUserName="root";
	private String jdbcPassword="root";
	
	private static final String INSERT_USER_SQL="INSERT INTO users"+
	"(u_name,email,phone,u_address,u_role) VALUES"+"(?,?,?,?,?);";
	private static final String SELECT_USER_BY_ID="SELECT * FROM USERS WHERE USER_ID=?;";
	private static final String SELECT_ALL_USERS="SELECT * FROM USERS;";
	private static final String DELETE_USERS_BY_ID="DELETE FROM USERS WHERE USER_ID=?;";
	private static final String UPDATE_USERS_SQL="UPDATE USERS SET U_NAME=?, EMAIL=?, PHONE=?, U_ADDRESS=?, U_ROLE=? where USER_ID=?;";
	
	public UserDao() { 
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertUser(User user) {
		UserDao dao=new UserDao();
		
		try (Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setString(1,user.getName());
			preparedStatement.setString(2,user.getEmail());
			preparedStatement.setString(3,user.getPhone());
			preparedStatement.setString(4,user.getAddress());
			preparedStatement.setString(5,user.getRole());
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public User selectUser(int id) {
		User user=new User();
		UserDao dao=new UserDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				user.setId(id);
				user.setName(resultSet.getString("u_name"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setAddress(resultSet.getString("u_address"));
				user.setRole(resultSet.getString("u_role"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> selectAllUsers(){
		List<User> users=new ArrayList<User>();
		UserDao dao=new UserDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id=resultSet.getInt("id");
				String u_name=resultSet.getString("u_name");
				String email=resultSet.getString("email");
				String phone=resultSet.getString("phone");
				String u_address=resultSet.getString("u_address");
				String u_role=resultSet.getString("u_role");
				
				users.add(new User(id,u_name,email,phone,u_address,u_role));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public boolean deleteUser(int id) {
		boolean status=false;
		UserDao dao=new UserDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USERS_BY_ID);
			preparedStatement.setInt(1, id);
			
			status=preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean updateUser(User user)
	{
		boolean status=false;
		UserDao dao=new UserDao();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_USERS_SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.getRole());
			
			
			
			status=preparedStatement.executeUpdate()>0;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
}
