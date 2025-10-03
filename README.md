# Hungry Lion Backend

Spring Boot backend for Hungry Lion. Provides authentication, JWT-based security, email verification, and dining menu scraping.

---

## Features
- **User Authentication**
  - Signup with email + password
  - Login with JWT token generation
  - Email verification via Gmail SMTP
  - Resend verification code
- **Menu Scraper**
  - Scrapes dining menu data
  - Exposes JSON by meal type
  - Refresh endpoint to re-scrape and cache

---

## Tech Stack
- **Backend**: Spring Boot 3.x, Spring Security 6, Hibernate/JPA
- **Database**: PostgreSQL
- **Authentication**: JWT, email verification
- **Email**: Jakarta Mail (Gmail SMTP)
- **Caching**: In-memory (via static cache in `menuData`)

---

## Endpoints

### Authentication (`/auth`)
- `POST /auth/signup` → Register a new user
- `POST /auth/login` → Login and get a JWT
- `POST /auth/verify` → Verify account using a code
- `POST /auth/resend?email=...` → Resend verification code

### Menu (`/menu`)
- `GET /menu/{meal}` → Get cached JSON menu for a given meal
- `POST /menu/refresh` → Refresh cached menus by scraping

---

## Security

- **Public Endpoints**:  
  `/auth/**` and `/api/auth/**` are permitted without authentication.

- **Protected Endpoints**:  
  Everything else requires a valid JWT in the `Authorization` header:

