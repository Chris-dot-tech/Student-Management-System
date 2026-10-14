# Student Management System

A console-based **Student Management System** developed using Java, JDBC, and MySQL. This application helps manage student and course information through database operations.

## 🚀 Features

- **Add Student** – Register new student details.
- **View Students** – Retrieve and display student records.
- **Search Student** – Find student information using an ID.
- **Update Student** – Modify existing student details.
- **Delete Student** – Remove student records.
- **Course Management** – Manage course information using Course DAO operations.
- **Database Connectivity** – Connect to MySQL using JDBC.
- **DAO Design Pattern** – Separate database operations from application logic.
- **Menu-Driven Application** – Perform operations through a console menu.

## 🛠️ Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- SQL
- Eclipse IDE
- Git and GitHub

## 📂 Project Structure

```text
Student-Management-System/
├── src/
│   ├── DAO/
│   │   ├── StudentDAO.java
│   │   └── CourseDAO.java
│   ├── DAOImpl/
│   │   ├── StudentDAOImpl.java
│   │   └── CourseDAOImpl.java
│   ├── DTO/
│   │   ├── Student.java
│   │   └── Course.java
│   ├── connection/
│   │   └── ConnectionFactory.java
│   └── main/
│       └── StudentManagement.java
├── .gitignore
└── README.md
```

## 🗄️ Database Setup

1. Install MySQL and start the MySQL server.
2. Create a database using the following SQL command:

```sql
CREATE DATABASE student_db;
```

3. Create the required student and course tables based on the SQL queries used in the project.
4. Configure the JDBC connection with your database URL, username, and password.
5. Ensure that the MySQL Connector/J driver is available in the project build path.

**Note:** Use the actual database name and table structure configured in your project. Do not commit database passwords or other credentials to a public repository.

## ▶️ How to Run

1. Clone or download this repository.
2. Import the project into Eclipse IDE.
3. Configure the MySQL database and JDBC connection.
4. Add the MySQL Connector/J library to the project build path.
5. Run `StudentManagement.java`.
6. Use the console menu to perform the available student and course management operations.

## 🎯 Learning Outcomes

- Understanding JDBC connectivity and SQL queries.
- Implementing CRUD operations using Java.
- Working with DAO and DTO design patterns.
- Using `PreparedStatement` and `ResultSet` for database operations.
- Managing relational database records.
- Organizing Java projects using packages and interfaces.

## 👨‍💻 Author

**Ephraim Christopher**

GitHub: [Chris-dot-tech](https://github.com/Chris-dot-tech)

## 📄 License

This project is intended for educational and learning purposes.
