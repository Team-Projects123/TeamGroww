# TeamGroww project - Library Management System (LMS) - Maven Project

## Overview
The Library Management System (LMS) is a web-based application designed to streamline the management of books, loans, fines, reservations and viewing logs data. The technologies, including Servlets, JSP, JSTL, and EL. The LMS allows librarian-admin to manage books, loans, reservations,fines and systemlogs efficiently while providing users(reading purpose users) with a platform to access their books, issue and returning them with other features also.

## Features

### Admin Features:
As a librarian-admin, you can:
1. **Manage Users:**
   - View users.
   - Delete users.
2. **Manage Books:**
   - Add books.
   - View books.
   - Delete books.
3. **Manage Loans:**
   - Add loans.
   - View loans.
   - Delete loans.
4. **Manage Fines:**
   - View fines.
   - Update fines.
   - Clear fines.
5. **Manage Reservations:**
   - View reservations.
   - Add reservations.
6. **Manage System Logs:**
   - View logs.

### User Features:
As a user (non-librarian), you can:
1. **View Books:**
   - Details of books.
2. **Issue and Return Books:**
   - Issuing and returning books as online.
3. **Paying Fines:**
   - Paying fines to clear late fines.
4. **Reservations:**
   - Reservation for unavailable books.
5. **Profile Updating:**
   - Update personal information.

## How It Works:

1. **Users Registration and Login:**
   - Users register and login as librarian to manage books, users, loans, fines, reservations, systemlogs data.
   - Users register and login to view books, issuing and returning books, paying delayed books.
2. **Books, Loans, Fines, Reservations and System Logs Management by Librarian:**
   - Adding, viewing and deleting books.
   - Adding, Viewing and deleting loans.
   - Adding, Updating and clearing fines.
   - Viewing logs.

## Technologies Used
- **Backened:** JAVA (Servlets, JSP,JSTL,EL)
- **Frontend:** HTML,CSS, JavaScript
- **Build Tool:** Maven
- **Database:** MySQL (for storing user data, courses, assignments, etc.)
- **IDE:** Eclipse/IntelliJ IDEA (for development)

## Installation Guide

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/project-name.git
   ```
2. **Build the Project using Maven:**
   ```bash
   mvn clean install
   ```
3. **Deploy the Application:**
   - Deploy the application to a server such as Tomcat, using the `WAR` file generated in the `target` directory.
4. **Setup Database:**
   - Import the database schema and configure the database connection in `web.xml` or through application settings.
5. **Access the Application:**
   - Open the browser and navigate to the deployed URL to access the LMS.

## Screenshots

![img/Screenshot 2025-01-06 191314.png](<Screenshot 2025-01-06 191314.png>) 
![img/Screenshot 2025-01-06 190428.png](<Screenshot 2025-01-06 190428.png>)
![img/Screenshot 2025-01-06 190534.png](<Screenshot 2025-01-06 190534.png>) 
![img/Screenshot 2025-01-06 190559.png](<Screenshot 2025-01-06 190559.png>) 
![img/Screenshot 2025-01-06 190614.png](<Screenshot 2025-01-06 190614.png>) 
![img/Screenshot 2025-01-06 190705.png](<Screenshot 2025-01-06 190705.png>) 
![img/Screenshot 2025-01-06 190725.png](<Screenshot 2025-01-06 190725.png>) 
![img/Screenshot 2025-01-06 190749.png](<Screenshot 2025-01-06 190749.png>) 
![img/Screenshot 2025-01-06 190806.png](<Screenshot 2025-01-06 190806.png>) 
![img/Screenshot 2025-01-06 190816.png](<Screenshot 2025-01-06 190816.png>) 
![img/Screenshot 2025-01-06 190855.png](<Screenshot 2025-01-06 190855.png>) 
![img/Screenshot 2025-01-06 190911.png](<Screenshot 2025-01-06 190911.png>) 
![img/Screenshot 2025-01-06 190925.png](<Screenshot 2025-01-06 190925.png>) 
![img/Screenshot 2025-01-06 190941.png](<Screenshot 2025-01-06 190941.png>) 
![img/Screenshot 2025-01-06 191000.png](<Screenshot 2025-01-06 191000.png>) 
![img/Screenshot 2025-01-06 191044.png](<Screenshot 2025-01-06 191044.png>) 
![img/Screenshot 2025-01-06 191057.png](<Screenshot 2025-01-06 191057.png>) 
![img/Screenshot 2025-01-06 191117.png](<Screenshot 2025-01-06 191117.png>) 
![img/Screenshot 2025-01-06 191132.png](<Screenshot 2025-01-06 191132.png>) 
![img/Screenshot 2025-01-06 191150.png](<Screenshot 2025-01-06 191150.png>) 
![img/Screenshot 2025-01-06 191207.png](<Screenshot 2025-01-06 191207.png>) 
![img/Screenshot 2025-01-06 191228.png](<Screenshot 2025-01-06 191228.png>) 
![img/Screenshot 2025-01-06 191250.png](<Screenshot 2025-01-06 191250.png>) 
![img/Screenshot 2025-01-06 191303.png](<Screenshot 2025-01-06 191303.png>)





## License

This project is licensed under the MIT License.

---

This README provides an overview of the LMS system, its features, and instructions on installation and usage. It should guide both developers and users on how to interact with the system effectively.
