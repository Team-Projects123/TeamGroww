package com.user.model;

//import java.sql.Date;
import java.time.LocalDate;

public class Loans {
	
	private int loan_id;
	private int book_id;
	private int user_id;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	
	// Default constructor
	public Loans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Constructor with all fields
	public Loans(int loan_id, int book_id, int user_id, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
		super();
		this.loan_id = loan_id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
	}
	
	// Getters and Setters
	public int getLoanId() {
		return loan_id;
	}

	public void setLoanId(int loan_id) {
		this.loan_id = loan_id;
	}

	public int getBookId() {
		return book_id;
	}

	public void setBookId(int book_id) {
		this.book_id = book_id;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	// Check if the book is overdue
	public boolean isOverdue() {
		return returnDate == null && LocalDate.now().isAfter(dueDate);
	}
	
	// Calculate fine if the book is overdue (assuming a fixed fine rate)
	public double calculateFine(double fineRatePerDay) {
        if (isOverdue()) {
            long daysOverdue = LocalDate.now().toEpochDay() - dueDate.toEpochDay();
            return daysOverdue * fineRatePerDay;
        }
        return 0;
    }
	
	// Mark the book as returned
    public void markAsReturned(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
	// Print loan details
	@Override
	public String toString() {
		return "Loans [loan_id=" + loan_id + ", book_id=" + book_id + ", user_id=" + user_id + ", issueDate="
				+ issueDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + "]";
	}
}
