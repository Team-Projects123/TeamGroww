package com.user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.user.model.User;

public class UserDao {

    private Connection connection;

    // Database Credentials
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Library";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "@jayradhekrishna123";

    // SQL Queries
    private static final String INSERT_USER_SQL = "INSERT INTO users1 (u_name, email, phone, u_address, u_role, u_password) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users1 WHERE user_id = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users1;";
    private static final String DELETE_USERS_BY_ID = "DELETE FROM users1 WHERE user_id = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE users1 SET u_name = ?, email = ?, phone = ?, u_address = ?, u_role = ?, u_password = ? WHERE user_id = ?;";
    private static final String LOGIN_USER_SQL = "SELECT * FROM users1 WHERE email = ? AND u_password = ? AND u_role = ?;";

    // Constructor
    public UserDao() {
        try {
            // Establish connection
            this.connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    public UserDao(Connection connection2) {
        //TODO Auto-generated constructor stub
    }

    // Insert User
    public boolean insertUser(User user) throws SQLException {
        boolean status = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getPassword());
            status = preparedStatement.executeUpdate() > 0;
        }
        return status;
    }

    // Select User by ID
    public User selectUser(int id) throws SQLException {
        User user = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(
                        id,
                        resultSet.getString("u_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("u_address"),
                        resultSet.getString("u_role"),
                        resultSet.getString("u_password")
                    );
                }
            }
        }
        return user;
    }

    // Select All Users
    public List<User> selectAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                users.add(new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("u_name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone"),
                    resultSet.getString("u_address"),
                    resultSet.getString("u_role"),
                    resultSet.getString("u_password")
                ));
            }
        }
        return users;
    }

    // Delete User
    public boolean deleteUser(int id) throws SQLException {
        boolean status = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_BY_ID)) {
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate() > 0;
        }
        return status;
    }

    // Update User
    public boolean updateUser(User user) throws SQLException {
        boolean status = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setInt(7, user.getId());
            status = preparedStatement.executeUpdate() > 0;
        }
        return status;
    }

    // Login User
    public boolean loginUser(String email, String password, String role) throws SQLException {
        boolean isValidUser = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USER_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                isValidUser = resultSet.next();
            }
        }
        return isValidUser;
    }

    // Close Connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // Create a new User object
        User newUser = new User();
        newUser.setName("John Doe");
        newUser.setEmail("john.doe@example.com");
        newUser.setPhone("1234567890");
        newUser.setAddress("123 Main St, Cityville");
        newUser.setRole("Member");
        newUser.setPassword("password123"); // In real applications, hash the password before storing it.
    
        // Instantiate the UserDao object
        UserDao userDao = new UserDao();
    
        // Insert the user into the database
        try {
            boolean status = userDao.insertUser(newUser);
            if (status) {
                System.out.println("User successfully inserted into the database.");
    
                // Retrieve the user by ID (Assuming user_id is auto-incremented, and it's the first inserted user)
                // For this example, let's assume the inserted user_id is the last inserted one (can be modified based on actual ID retrieval)
                int insertedUserId = 1; // You can modify this based on your insert method logic (like retrieving generated keys)
                
                // Retrieve the inserted user
                User insertedUser = userDao.selectUser(insertedUserId);
                
                if (insertedUser != null) {
                    // Print the user details from the database
                    System.out.println("Inserted User Details:");
                    System.out.println("ID: " + insertedUser.getId());
                    System.out.println("Name: " + insertedUser.getName());
                    System.out.println("Email: " + insertedUser.getEmail());
                    System.out.println("Phone: " + insertedUser.getPhone());
                    System.out.println("Address: " + insertedUser.getAddress());
                    System.out.println("Role: " + insertedUser.getRole());
                } else {
                    System.out.println("Failed to retrieve user from the database.");
                }
            } else {
                System.out.println("Failed to insert user.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting or retrieving the user.");
            e.printStackTrace();
        } finally {
            // Close the database connection
            userDao.closeConnection();
        }
    }
    
}
