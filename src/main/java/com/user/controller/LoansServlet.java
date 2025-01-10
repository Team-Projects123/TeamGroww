package com.user.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoansServlet")
public class LoansServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("book_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String issueDate = request.getParameter("issue_date");
        String dueDate = request.getParameter("due_date");

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO loans (book_id, user_id, issue_date, due_date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, bookId);
                stmt.setInt(2, userId);
                stmt.setDate(3, Date.valueOf(issueDate));
                stmt.setDate(4, Date.valueOf(dueDate));
                stmt.executeUpdate();
                response.getWriter().println("Loan added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

