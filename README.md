
# UserProfileManager

**UserProfileManager** is a Spring Boot-based application designed for user profile management. 
It provides operations such as viewing, updating profiles, and uploading avatars.

---

## 📋 Features

- **Get User Profile**:
    - Method: `GET`
    - Endpoint: `/api/profile`
    - Description: Retrieves a user profile by their `userId`.

- **Update User Profile**:
    - Method: `PUT`
    - Endpoint: `/api/profile`
    - Description: Updates a user profile with validation.

- **Upload Avatar**:
    - Method: `POST`
    - Endpoint: `/api/upload-avatar`
    - Description: Allows uploading an avatar for a user. Supported formats: `.jpg`, `.jpeg`, `.png`.

---

## 🛠️ Tech Stack

- **Backend**: Kotlin, Spring Boot
- **ORM**: Hibernate / JPA
- **Database**: PostgreSQL
- **Validation**: Jakarta Bean Validation
- **File Upload**: Spring MultipartFile

---

## 📂 Project Structure

```
src/
└── main/
    ├── kotlin/ekaterinabeidel/userprofilemanager/
    │   ├── annotations/         # Custom annotations
    │   ├── configuration/       # Configuration files (Swagger)
    │   ├── controller/          # REST API Controllers
    │   ├── dto/                 # Data Transfer Objects
    │   ├── entity/              # JPA Entities
    │   ├── enums/               # Enumerations
    │   ├── repository/          # Database Repositories
    │   ├── service/             # Business Logic Layer
    │   ├── service/impl/        # Service Implementations
    │   ├── util/                # Utilities (e.g., Mapper)
    │   ├── exception/           # Custom Exceptions
    │   └── handler/             # Exception Handlers
    └── resources/
        ├── application.properties  # Spring Boot Configuration
        ├── data.sql                # Initial Data for the Database
        └── schema.sql              # Database Schema Definition

```

---

## 🏃 Getting Started

1. **Clone the Repository**
   ```bash
   git clone https://github.com/ekaterinabeidel/UserProfileManager
   cd UserProfileManager
   ```

2. **Install Dependencies**
   Ensure Maven is installed and run:
   ```bash
   ./mvnw clean install
   ```

3. **Configure the Database**
   Set up PostgreSQL database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/user_profile_manager
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. **Run the Application**
   Start the application with:
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the Application**
   The application will be accessible at:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## 🚀 API Examples

### 1. Get User Profile
**Request**:
```http
GET /api/profile?userId=1
```
**Response**:
```json
{
  "name": "Albert",
  "surname": "Einstein",
  "jobTitle": "Theoretical Physicist",
  "phone": "+79991234567",
  "address": "Princeton",
  "interests": [
    "Relativity",
    "Quantum Mechanics"
  ],
  "profileLink": "https://example.com/profiles/einstein",
  "avatarUrl": "https://example.com/avatar1.jpg",
  "visibility": "PUBLIC"
}
```

### 2. Update User Profile
**Request**:
```http
PUT /api/profile?userId=1
Content-Type: application/json
```
**Request Body**:
```json
{
  "name": "Albert",
  "surname": "Einstein",
  "jobTitle": "Theoretical Physicist",
  "phone": "+79991234567",
  "address": "Princeton",
  "interests": [
    "Relativity",
    "Quantum Mechanics"
  ],
  "profileLink": "https://example.com/profiles/einstein",
  "visibility": "PUBLIC"
}
```
**Response**:
```json
{
  "name": "Albert",
  "surname": "Einstein",
  "jobTitle": "Theoretical Physicist",
  "phone": "+79991234567",
  "address": "Princeton",
  "interests": [
    "Relativity",
    "Quantum Mechanics"
  ],
  "profileLink": "https://example.com/profiles/einstein",
  "avatarUrl": "https://example.com/avatar1.jpg",
  "visibility": "PUBLIC"
}
```
### 3. Upload Avatar
**Request**:
```http
POST /api/upload-avatar?userId=1
Content-Type: multipart/form-data
```
**Request Body**:
```
file: avatar.jpg
```
**Response**:
```json
{
  "URL": "http://localhost:8080/uploads/avatar.jpg"
}
```
---

## 🛑 Constraints & Validation

- Name and Surname: Minimum 2 characters, maximum 50 characters, only letters.
- Phone Number: International format starting with `+`.
- Links: Must start with `http://` or `https://`.
- Avatar: Only `.jpg`, `.jpeg`, `.png` formats, up to 5 MB.

---

## 📑 API Documentation

This project uses **Swagger** for API documentation. You can access the API documentation via the following endpoint once the application is running:

```
http://localhost:8080/swagger-ui/index.html
```

### Key Features of Swagger:
- Visual representation of API endpoints.
- Test API endpoints directly from the documentation.
- Explore available request parameters and responses.

To enable or modify Swagger, check the configuration files under `src/main/kotlin/ekaterinabeidel/userprofilemanager/configuration/`.

---
## ✨ Additional Information

**Contact**:
If you have any questions, feel free to contact me at [ek.beidel@gmail.com](mailto:ek.beidel@gmail.com).

---
