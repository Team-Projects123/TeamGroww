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

![Screenshot 2025-01-06 190428](https://github.com/user-attachments/assets/35906020-14ab-46b0-a5f7-d19ef101c43b)
![Screenshot 2025-01-06 190534](https://github.com/user-attachments/assets/0b444585-2ab6-4830-a9bf-35011caa2f4a)
![Screenshot 2025-01-06 190559](https://github.com/user-attachments/assets/c75081c8-d013-44ca-b103-c706e391f5f3)
![Screenshot 2025-01-06 190614](https://github.com/user-attachments/assets/0932b579-79ae-4f49-88c9-250cf5345e13)
![Screenshot 2025-01-06 190705](https://github.com/user-attachments/assets/3ea8b29f-2cb5-4802-9741-53dbc8e9b12e)
![Screenshot 2025-01-06 190725](https://github.com/user-attachments/assets/a6ddbaa8-6e21-4c7b-8d40-151838127286)
![Screenshot 2025-01-06 190749](https://github.com/user-attachments/assets/8b0cd806-d960-4342-8708-58382019bafc)
![Screenshot 2025-01-06 190806](https://github.com/user-attachments/assets/8327320f-1029-4ff1-ba87-77a274c4c44a)
![Screenshot 2025-01-13 001726](https://github.com/user-attachments/assets/531a010f-233f-49fe-b84b-325291462328)
![Screenshot 2025-01-13 001856](https://github.com/user-attachments/assets/8a306fdc-639b-461a-b722-223168dad1fb)
![Screenshot 2025-01-13 001905](https://github.com/user-attachments/assets/9a993665-c5b6-4239-a08c-78de2d282059)

![Screenshot 2025-01-06 190911](https://github.com/user-attachments/assets/939e9727-272c-4ce8-a6c1-7679eb432351)
![Screenshot 2025-01-06 190925](https://github.com/user-attachments/assets/e260cd19-fad1-4ef2-984e-2d4bf544c20b)
![Screenshot 2025-01-06 190941](https://github.com/user-attachments/assets/2826a77e-cbfc-48fc-878c-3e227151fd28)
![Screenshot 2025-01-06 191000](https://github.com/user-attachments/assets/cff05a26-b03e-4dae-9d95-ad5d6ed9fc5b)
![Screenshot 2025-01-06 191044](https://github.com/user-attachments/assets/a787f42e-fb06-4e1a-90df-db9eb756409b)
![Screenshot 2025-01-06 191057](https://github.com/user-attachments/assets/49ad4dc8-0f6a-46cf-97ff-4d78c6f66e41)
![Screenshot 2025-01-06 191117](https://github.com/user-attachments/assets/6be8f5cc-c8c8-4120-8ed4-4f7eb0a30a80)
![Screenshot 2025-01-06 191132](https://github.com/user-attachments/assets/911d1961-45d9-4829-b0d8-d8021f37274e)
![Screenshot 2025-01-06 191150](https://github.com/user-attachments/assets/5f7a3b27-2e56-4439-bb27-940717ece512)
![Screenshot 2025-01-06 191207](https://github.com/user-attachments/assets/10a492bb-7d7d-45ce-9ad5-69650c9ebe91)
![Screenshot 2025-01-06 191228](https://github.com/user-attachments/assets/93d9d9be-5c0a-4eec-8438-3f751f25e74d)
![Screenshot 2025-01-06 191250](https://github.com/user-attachments/assets/69e9fb0b-d48f-4aca-a5fd-d5d7502225d2)
![Screenshot 2025-01-06 191303](https://github.com/user-attachments/assets/5e92749c-8ba9-44db-83ce-72906876f127)
![Screenshot 2025-01-06 191314](https://github.com/user-attachments/assets/1cfcdf64-28c7-47f4-abfb-de5b31c98f75)





---
