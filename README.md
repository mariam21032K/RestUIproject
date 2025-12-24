# Person Management System - REST API

A Java-based REST API for managing person records using Jersey, MySQL, and Tomcat.

## 📋 Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Testing with Postman](#testing-with-postman)
- [Troubleshooting](#troubleshooting)

---

## ✨ Features

- ✅ **Create** - Add new persons to the database
- ✅ **Read** - Retrieve all persons or search by ID
- ✅ **Update** - Modify existing person records
- ✅ **Delete** - Remove person records
- ✅ **JSON API** - RESTful endpoints with JSON request/response
- ✅ **Modern UI** - Beautiful web interface for CRUD operations
- ✅ **Error Handling** - Comprehensive error messages and logging

---

## 🔧 Prerequisites

Before you begin, ensure you have the following installed:

1. **Java JDK 8 or higher**
   - Download: https://www.oracle.com/java/technologies/downloads/
   - Verify: `java -version`

2. **Apache Tomcat 9.0+**
   - Download: https://tomcat.apache.org/download-90.cgi
   - Installation: Extract to `C:\Program Files\apache-tomcat-9.0.113` (or your preferred location)

3. **MySQL Server 5.7+**
   - Download: https://dev.mysql.com/downloads/mysql/
   - Default credentials: username: `root`, password: `root`

4. **Maven 3.6+**
   - Download: https://maven.apache.org/download.cgi
   - Verify: `mvn --version`

5. **MySQL Workbench** (Optional but recommended for database management)
   - Download: https://dev.mysql.com/downloads/workbench/

---

## 🚀 Installation & Setup

### Step 1: Create the Database

Open **MySQL Workbench** and execute the following SQL script:

```sql
-- Create database
CREATE DATABASE IF NOT EXISTS projetdb;

-- Use the database
USE projetdb;

-- Create person table
CREATE TABLE IF NOT EXISTS person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Age INT NOT NULL
);

-- Verify
SHOW TABLES;
DESC person;
```

### Step 2: Clone or Download the Project

```bash
# Clone from GitHub (if available)
git clone https://github.com/YOUR_USERNAME/tp333.git
cd tp333

# Or extract if downloaded as ZIP
```

### Step 3: Build the Project

Navigate to the project directory and run:

```bash
cd d:\fac\li3\tpSOA\tp333
mvn clean package -DskipTests
```

Expected output:
```
[INFO] BUILD SUCCESS
[INFO] Total time: 2.8 s
```

### Step 4: Deploy to Tomcat

1. **Stop Tomcat** (if running):
   ```powershell
   cd "C:\Program Files\apache-tomcat-9.0.113\bin"
   .\shutdown.bat
   ```

2. **Remove old deployment**:
   ```powershell
   Remove-Item "C:\Program Files\apache-tomcat-9.0.113\webapps\tp333" -Recurse -Force
   ```

3. **Copy new WAR file**:
   ```powershell
   Copy-Item "d:\fac\li3\tpSOA\tp333\target\tp333-0.0.1-SNAPSHOT.war" `
             "C:\Program Files\apache-tomcat-9.0.113\webapps\tp333.war"
   ```

4. **Start Tomcat**:
   ```powershell
   cd "C:\Program Files\apache-tomcat-9.0.113\bin"
   .\startup.bat
   ```

Wait for: `Server startup in X milliseconds`

---

## 🌐 Running the Application

Once Tomcat is running, access the application at:

```
http://localhost:8080/tp333/
```

You should see the **Person Management System** interface with:
- Form to add new persons
- List of all persons with edit/delete buttons
- Search functionality

---

## 📡 API Documentation

### Base URL
```
http://localhost:8080/tp333/api/users
```

### 1. Create Person (POST)

**Endpoint:** `POST /add`

**Request:**
```json
{
  "name": "John Doe",
  "age": 30
}
```

**Response:**
```json
{
  "state": "ok",
  "message": "Person added successfully"
}
```

---

### 2. Get All Persons (GET)

**Endpoint:** `GET /affiche`

**Response:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "age": 30
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "age": 25
  }
]
```

---

### 3. Get Person By ID (GET)

**Endpoint:** `GET /get/{id}`

**Example:** `GET /get/1`

**Response:**
```json
{
  "state": "ok",
  "data": {
    "id": 1,
    "name": "John Doe",
    "age": 30
  }
}
```

---

### 4. Update Person (PUT)

**Endpoint:** `PUT /update`

**Request:**
```json
{
  "id": 1,
  "name": "John Smith",
  "age": 35
}
```

**Response:**
```json
{
  "state": "ok",
  "message": "User updated"
}
```

---

### 5. Delete Person (DELETE)

**Endpoint:** `DELETE /remove/{id}`

**Example:** `DELETE /remove/1`

**Response:**
```json
{
  "state": "ok"
}
```

---

## 🧪 Testing with Postman

### Import Postman Collection

1. **Open Postman**
2. **Create a new collection** named "TP333 API"
3. **Add requests** for each endpoint (see examples below)

### Example Requests

#### Add Person
```
POST http://localhost:8080/tp333/api/users/add
Content-Type: application/json

{
  "name": "Alice Johnson",
  "age": 28
}
```

#### Get All Persons
```
GET http://localhost:8080/tp333/api/users/affiche
```

#### Update Person (ID: 1)
```
PUT http://localhost:8080/tp333/api/users/update
Content-Type: application/json

{
  "id": 1,
  "name": "Alice Smith",
  "age": 29
}
```

#### Delete Person (ID: 1)
```
DELETE http://localhost:8080/tp333/api/users/remove/1
```

---

## 📁 Project Structure

```
tp333/
├── src/
│   └── com/
│       └── info/
│           ├── db/
│           │   └── ConnexionDB.java          (Database connection)
│           ├── model/
│           │   └── Person.java               (Person entity)
│           ├── service/
│           │   ├── PersonService.java        (Interface)
│           │   └── PersonServiceImpl.java     (Implementation)
│           └── router/
│               └── RestRouter.java           (REST endpoints)
├── WebContent/
│   ├── index.html                            (UI interface)
│   ├── WEB-INF/
│   │   └── web.xml                           (Servlet configuration)
│   └── META-INF/
├── pom.xml                                   (Maven configuration)
└── README.md                                 (This file)
```

---

## 🔍 Troubleshooting

### Issue: "Cannot connect to database"

**Solution:**
1. Verify MySQL is running: `mysql -u root -p`
2. Check database exists: `SHOW DATABASES;`
3. Verify credentials in `src/com/info/db/ConnexionDB.java`:
   ```java
   String url="jdbc:mysql://localhost/projetdb";
   String login="root";
   String password="root";
   ```

### Issue: "Port 8080 already in use"

**Solution:**
1. Kill existing Tomcat: `taskkill /IM java.exe /F`
2. Or change Tomcat port in `conf/server.xml`
3. Wait 5 seconds and restart Tomcat

### Issue: "Compilation errors with Maven"

**Solution:**
```bash
mvn clean install
mvn compile
mvn package
```

### Issue: "404 Not Found" on API endpoints

**Solution:**
1. Ensure WAR file is deployed: Check `webapps/tp333` folder
2. Check Tomcat console for errors
3. Verify Tomcat is fully started (wait 10 seconds after startup)
4. Clear browser cache: `Ctrl+Shift+Delete`

### Issue: "Error adding person" on UI

**Solution:**
1. Open browser DevTools: Press `F12`
2. Go to **Console** tab
3. Try adding a person and check error messages
4. Check Tomcat console logs for SQL errors

---

## 📝 Database Schema

### person table

| Column | Type | Constraints |
|--------|------|-------------|
| id | INT | PRIMARY KEY, AUTO_INCREMENT |
| Name | VARCHAR(100) | NOT NULL |
| Age | INT | NOT NULL |

---

## 🛠️ Technologies Used

- **Backend**: Java 8, Jersey 2.35, MySQL JDBC
- **Frontend**: HTML5, CSS3, JavaScript (Vanilla)
- **Build Tool**: Maven 3.8.0
- **Server**: Apache Tomcat 9.0
- **Database**: MySQL 5.7+

---

## 📦 Dependencies

See `pom.xml` for full list:
- Jersey (REST framework)
- MySQL Connector (Database driver)
- Jackson (JSON processing)

---

## ✅ Checklist Before Deployment

- [ ] Java JDK installed and configured
- [ ] Tomcat installed and working
- [ ] MySQL server running
- [ ] Database `projetdb` created with `person` table
- [ ] Project compiled successfully with Maven
- [ ] WAR file deployed to Tomcat
- [ ] Tomcat server started
- [ ] Can access `http://localhost:8080/tp333/`
- [ ] API endpoints respond to requests

---

## 📞 Support

For issues or questions:
1. Check the **Troubleshooting** section above
2. Review Tomcat logs: `logs/catalina.out`
3. Check browser DevTools console: `F12`
4. Verify database connection in MySQL Workbench

---

## 📄 License

This project is provided as-is for educational purposes.

---

## 👨‍💻 Author

Created as a Java Web Services (SOA) project

---

**Last Updated:** December 24, 2025
