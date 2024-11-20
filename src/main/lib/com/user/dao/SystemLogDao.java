package com.user.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.user.model.SystemLogs;


public class SystemLogDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/Library";
	private String jdbcUserName = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_SYSTEMLOG_SQL = "INSERT INTO SYSTEMLOGS" + 
	"(user_id,action,timestamp,details) VALUES" + "(?,?,?,?);";
	private static final String SELECT_SYSTEMLOGS_BY_ID = "SELECT * FROM SYSTEMLOGS WHERE LOG_ID=?;";
	private static final String SELECT_ALL_SYSTEMLOGS = "SELECT * FROM SYSTEMLOGS;";
	private static final String DELETE_SYSTEMLOGS_BY_ID = "DELETE FROM SYSTEMLOGS WHERE LOG_ID=?;";
	
	
	public SystemLogDao() {
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
	
	public void addSystemLog(SystemLogs systemLog) {
		SystemLogDao dao=new SystemLogDao();
		
		try (Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_SYSTEMLOG_SQL);
			preparedStatement.setInt(1,systemLog.getUserId());
			preparedStatement.setString(2,systemLog.getAction());
			preparedStatement.setTimestamp(3,Timestamp.valueOf(systemLog.getTimestamp()));
			preparedStatement.setString(4,systemLog.getDetails());
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public SystemLogs getSystemLogByID(int logId) {
		SystemLogs systemLog=new SystemLogs();
		SystemLogDao dao=new SystemLogDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_SYSTEMLOGS_BY_ID);
			preparedStatement.setInt(1, logId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			 systemLog.setLogId(logId);
			 systemLog.setUserId(resultSet.getInt("user_id"));
			 systemLog.setAction(resultSet.getString("action"));
			 systemLog.setTimestamp(resultSet.getTimestamp("reservation_date").toLocalDateTime());
			 systemLog.setDetails(resultSet.getString("details"));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return systemLog;
	}
	
	public List<SystemLogs> getAllSystemLogs(){
		List<SystemLogs> systemLogs=new ArrayList<SystemLogs>();
		SystemLogDao dao=new SystemLogDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_SYSTEMLOGS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int log_id=resultSet.getInt("log_id");
				int user_id=resultSet.getInt("user_id");
				String action=resultSet.getString("action");
				LocalDateTime timestamp=resultSet.getTimestamp("timestamp").toLocalDateTime();
				String details=resultSet.getString("details");
				
				systemLogs.add(new SystemLogs(log_id,user_id,action,timestamp,details));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return systemLogs;
	}
	
	public boolean deleteSystemLog(int logId) {
		boolean status=false;
		SystemLogDao dao=new SystemLogDao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_SYSTEMLOGS_BY_ID);
			preparedStatement.setInt(1, logId);
			
			status=preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	
}
