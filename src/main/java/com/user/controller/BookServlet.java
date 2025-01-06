package com.user.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.BookDao;
import com.user.model.Book;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookDao bookDao;

    public void init() {
        bookDao = new BookDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addBook(request, response);
                break;
            case "update":
                updateBook(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "list":
                    listBooks(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteBook(request, response);
                    break;
                default:
                    listBooks(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");
        String publisher = request.getParameter("publisher");
        String isbn = request.getParameter("isbn");
        int copiesTotal = Integer.parseInt(request.getParameter("copiesTotal"));
        int copiesAvailable = Integer.parseInt(request.getParameter("copiesAvailable"));

        Book book = new Book(title, author, genre, publisher, isbn, copiesTotal, copiesAvailable);
        bookDao.addBook(book);
        response.sendRedirect("BookServlet?action=list");
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = bookDao.getAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("book-list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDao.getBookByID(id);
        request.setAttribute("book", existingBook);
        request.getRequestDispatcher("book-form.jsp").forward(request, response);
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");
        String publisher = request.getParameter("publisher");
        String isbn = request.getParameter("isbn");
        int copiesTotal = Integer.parseInt(request.getParameter("copiesTotal"));
        int copiesAvailable = Integer.parseInt(request.getParameter("copiesAvailable"));

        Book book = new Book(id, title, author, genre, publisher, isbn, copiesTotal, copiesAvailable);
        bookDao.updateBook(book);
        response.sendRedirect("BookServlet?action=list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDao.deleteBook(id);
        response.sendRedirect("BookServlet?action=list");
    }
}
