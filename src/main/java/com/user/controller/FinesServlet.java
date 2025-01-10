package com.user.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinesServlet")
public class FinesServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int loanId = Integer.parseInt(request.getParameter("loan_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        double fineAmount = Double.parseDouble(request.getParameter("fine_amount"));

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO fines (loan_id, user_id, fine_amount) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, loanId);
                stmt.setInt(2, userId);
                stmt.setDouble(3, fineAmount);
                stmt.executeUpdate();
                response.getWriter().println("Fine added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

