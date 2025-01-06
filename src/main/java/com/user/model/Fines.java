package com.user.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Fines {
	private int fineId; // Unique identifier for the fine
	private int loanId; // ID of the loan associated with the fine
	private int userId; // ID of the user who has the fine
	private BigDecimal fineAmount; // Amount of the fine
	private boolean paidStatus; // Indicates whether the fine is paid
	private LocalDate paymentDate; // Date when the fine was paid

	// Constructor with all fields
	public Fines(int fineId, int loanId, int userId, BigDecimal fineAmount, boolean paidStatus, LocalDate paymentDate) {
		this.fineId = fineId;
		this.loanId = loanId;
		this.userId = userId;
		this.fineAmount = fineAmount;
		this.paidStatus = paidStatus;
		this.paymentDate = paymentDate;
	}

	// Default constructor
	public Fines() {
	}

	// Getters and Setters
	public int getFineId() {
		return fineId;
	}

	public void setFineId(int fineId) {
		this.fineId = fineId;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public BigDecimal getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(BigDecimal fineAmount) {
		this.fineAmount = fineAmount;
	}

	public boolean isPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(boolean paidStatus) {
		this.paidStatus = paidStatus;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	// Mark the fine as paid and set the payment date
	public void payFine(LocalDate paymentDate) {
		this.paidStatus = true;
		this.paymentDate = paymentDate;
	}

	// Check if the fine is paid
	public boolean isPaid() {
		return paidStatus;
	}

	// Print fine details
	@Override
	public String toString() {
		return "Fine{" + "fineId=" + fineId + ", loanId=" + loanId + ", userId=" + userId + ", fineAmount=" + fineAmount
				+ ", paidStatus=" + paidStatus + ", paymentDate=" + paymentDate + '}';
	}
}
