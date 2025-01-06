package com.user.model;
import java.time.LocalDate;

public class Reservations {
    private int reservationId;        // Unique identifier for the reservation
    private int userId;               // ID of the user making the reservation
    private int bookId;               // ID of the book being reserved
    private LocalDate reservationDate; // Date when the reservation was made
    private String status;            // Status of the reservation (Active, Completed, or Cancelled)

    // Constructor with all fields
    public Reservations(int reservationId, int userId, int bookId, LocalDate reservationDate, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.bookId = bookId;
        this.reservationDate = reservationDate;
        this.status = status;
    }

    // Default constructor
    public Reservations() {}

    // Getters and Setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    // Mark the reservation as completed
    public void completeReservation() {
        this.status = "Completed";
    }

    // Mark the reservation as cancelled
    public void cancelReservation() {
        this.status = "Cancelled";
    }

    // Print reservation details
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", reservationDate=" + reservationDate +
                ", status='" + status + '\'' +
                '}';
    }

	
}

