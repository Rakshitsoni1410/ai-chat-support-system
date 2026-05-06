# 🤖 AI Chat Support System (Spring Boot)

A backend-based AI Chat Support System built using **Spring Boot, MySQL, JPA, and Security**.  
This project simulates a chatbot system where users can register, send messages, and receive responses.

---

## 🚀 Features

- User Registration & Login
- Secure Authentication (Spring Security)
- Chat Message Storage
- MySQL Database Integration
- REST APIs for chatbot communication
- Scalable backend architecture

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3.5.1
- Spring Data JPA
- Spring Security
- MySQL
- Maven

---

## 📂 Project Structure
com.chatbot.system
│
├── controller
├── service
├── repository
├── model
├── dto
├── config
└── util


---

## ⚙️ Setup Instructions

### 1. Clone Repository
```bash
git clone https://github.com/your-username/ai-chat-support-system.git
2. Configure Database

Create MySQL database:

CREATE DATABASE chatbot_db;

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/chatbot_db
spring.datasource.username=root
spring.datasource.password=your_password
3. Run Project
./mvnw spring-boot:run
📡 API Endpoints (Coming Soon)
POST /api/auth/register
POST /api/auth/login
POST /api/chat/send
GET /api/chat/history/{userId}
📸 Future Enhancements
AI integration (OpenAI / NLP)
JWT Authentication
React frontend UI
Real-time chat (WebSocket)
👨‍💻 Author

MCA Student Project
Built for learning Spring Boot backend development.

⭐ Purpose

This project is built for:

MCA academic project
Backend development practice
Interview portfolio

---

# 🚀 FINAL STEP (IMPORTANT)

After this:

### Push to GitHub:
```bash
git init
git add .
git commit -m "Initial commit - AI Chatbot Backend"
git branch -M main
git remote add origin https://github.com/your-username/ai-chat-support-system.git
git push -u origin main
