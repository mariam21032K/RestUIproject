# 🚀 Quick Start Guide

Get up and running in 5 minutes!

---

## **1. Database Setup (MySQL Workbench)**

```sql
CREATE DATABASE IF NOT EXISTS projetdb;
USE projetdb;
CREATE TABLE IF NOT EXISTS person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Age INT NOT NULL
);
```

---

## **2. Build Project**

```bash
cd d:\fac\li3\tpSOA\tp333
mvn clean package -DskipTests
```

---

## **3. Deploy to Tomcat**

```powershell
# Stop Tomcat
cd "C:\Program Files\apache-tomcat-9.0.113\bin"
.\shutdown.bat

# Remove old version
Remove-Item "C:\Program Files\apache-tomcat-9.0.113\webapps\tp333" -Recurse -Force

# Copy new WAR
Copy-Item "d:\fac\li3\tpSOA\tp333\target\tp333-0.0.1-SNAPSHOT.war" `
          "C:\Program Files\apache-tomcat-9.0.113\webapps\tp333.war"

# Start Tomcat
.\startup.bat
```

---

## **4. Access Application**

Open browser: `http://localhost:8080/tp333/`

---

## **5. Test APIs (Postman)**

### Add Person
```
POST http://localhost:8080/tp333/api/users/add
Content-Type: application/json

{"name": "John", "age": 30}
```

### Get All
```
GET http://localhost:8080/tp333/api/users/affiche
```

### Update
```
PUT http://localhost:8080/tp333/api/users/update
Content-Type: application/json

{"id": 1, "name": "Jane", "age": 28}
```

### Delete
```
DELETE http://localhost:8080/tp333/api/users/remove/1
```

---

## **6. Push to GitHub**

```powershell
cd d:\fac\li3\tpSOA\tp333
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/YOUR_USERNAME/tp333.git
git branch -M main
git push -u origin main
```

---

**Done! Your app is live! 🎉**
