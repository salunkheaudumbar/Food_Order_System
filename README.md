Food Order System
A scalable backend service for processing food delivery orders using:
- Java 21
- Spring Boot 3.x
- MySQL
- Redis (for async order queue)
🚀 Features
- Place an order (validated request)
- Fetch all orders with pagination
- Order status tracking
- Redis-based async queue for order processing
- Exception handling (validation & not found)
⚙️ Setup Instructions
1. Clone the Repository
git clone https://github.com/your-username/food-order-system.git
cd food-order-system
2. Configure Database
Run the following SQL script:
CREATE DATABASE orderdb;
USE orderdb;

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    items TEXT NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    order_time TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL
);
Update application.yml:
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/orderdb
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect

  redis:
    host: localhost
    port: 6379
3. Install Redis
Download & run Redis (on Windows, WSL, or Docker). Run: redis-server
4. Build & Run
mvn clean install
mvn spring-boot:run
📡 API Endpoints (Postman/REST)
1️⃣ Place an Order (POST /api/orders)
Request: {"customerName": "John Doe", "items": "Burger, Fries, Coke", "totalAmount": 450.50}
Response: {... sample order JSON ...}
2️⃣ Get All Orders (GET /api/orders?page=0&size=5)
Response: [... list of orders ...]
3️⃣ Get Order by ID (GET /api/orders/{id})
Response: {... single order JSON ...}
4️⃣ Update Order Status (PUT /api/orders/{id}/status)
Request: {"status": "COMPLETED"}
Response: {"id": 1, "status": "COMPLETED"}
5️⃣ Delete Order (DELETE /api/orders/{id})
Response: {"message": "Order deleted successfully"}
🔄 Redis Queue Testing
1. Place an order (POST /api/orders)
2. Check Redis queue: redis-cli -> LRANGE orderQueue 0 -1
3. See consumer logs in Spring Boot console
📝 Tech Stack
- Java 21
- Spring Boot 3.4
- Hibernate / JPA
- MySQL
- Redis
- Maven
👨‍💻 Author
Developed by **Your Name** 🚀
