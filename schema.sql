create database Library;

use Library;

create table users(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    u_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    u_address TEXT,
    u_role VARCHAR(20)
);

CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    author VARCHAR(100),
    genre VARCHAR(50),
    publisher VARCHAR(100),
    isbn VARCHAR(13),
    copies_total INT,
    copies_available INT
);

CREATE TABLE loans (
    loan_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    user_id INT,
    issue_date DATE,
    due_date DATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES Books(book_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE fines (
    fine_id INT PRIMARY KEY AUTO_INCREMENT,
    loan_id INT,
    user_id INT,
    fine_amount DECIMAL(10, 2),
    paid_status BOOLEAN DEFAULT FALSE,
    payment_date DATE,
    FOREIGN KEY (loan_id) REFERENCES Loans(loan_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE systemlogs (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    action VARCHAR(255),
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    details TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    book_id INT,
    reservation_date DATE DEFAULT CURRENT_DATE,
    status ENUM('Active', 'Completed', 'Cancelled') DEFAULT 'Active',
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);
desc users;
desc loans;
desc books;
desc fines;
desc reservations;
desc systemlogs;



select * from users;
select * from books;
select * from loans;
select * from fines;
select * from reservations;
select * from systemlogs;
