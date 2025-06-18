# 📘 Day3-Task: MongoDB Java Enrollment App

This Java application demonstrates the use of MongoDB to manage student enrollments in courses, using **both embedded and referenced documents** to highlight their structural differences.

---

## 🛠️ Features Implemented

- 📥 Insert sample **students** and **courses**
- 🔁 Create **embedded** enrollment documents (student + course inside)
- 🔗 Create **referenced** enrollment documents (using ObjectIds)
- 🔍 Query and print both types with full details
- ✏️ Update student name and observe difference in effect:
  - Embedded: name change doesn’t reflect automatically
  - Referenced: name change reflects everywhere
- 📊 Create **index** on student `name` for efficient queries

---

## 📸 Screenshots

Here are MongoDB Compass screenshots showing inserted collections and documents:

### ✅ Courses Collection
![Day3(Courses)MongoDb](https://github.com/user-attachments/assets/a4fb1f2b-ac43-4143-b1ab-2d6ad93bebc3)

### ✅ Enrollments Collection
![Day3(Enrollment)Mongodb](https://github.com/user-attachments/assets/fa6c5c9e-3820-48b4-8164-acdd69f398db)

### ✅ Console Output (Java Execution)
![Day3(MongoDb)](https://github.com/user-attachments/assets/0814275d-5526-42db-aa08-dbe29aaf5c0c)

### ✅ Students Collection
![Day3(Students)Mongodb](https://github.com/user-attachments/assets/c23ba718-6e92-4bbd-9885-ebfc32503622)

---

## 🧰 Tools Used

- ☕ Java 17
- 🍃 MongoDB
- 📦 MongoDB Java Driver (v4.11.0)
- 💻 IntelliJ IDEA (2025.1)
- 🧪 MongoDB Compass (GUI Viewer)

---
## 📂 Repo Structure

Day3_24MCAB44/
├── README.md
├── pom.xml
├── src/
│ └── main/
│ ├── java/
│ │ ├── org/example/Main.java
│ │ └── model/
│ │ ├── Student.java
│ │ ├── Course.java
│ │ ├── Enrollment.java
│ │ └── EnrollmentRef.java

