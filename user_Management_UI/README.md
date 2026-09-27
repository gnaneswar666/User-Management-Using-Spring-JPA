# User Management UI (React + Vite)

Frontend web application for the User Management system built using React, Vite, Axios, React Router, and Bootstrap.

---

## 🚀 Getting Started

1. **Install Dependencies**:
   ```bash
   npm install
   ```

2. **Run Development Server**:
   ```bash
   npm run dev
   ```

3. **Backend API Dependency**:
   Ensure the Spring Boot backend service (`UserManagement Microservice`) is running on port `9091`.
   API Endpoint configuration is defined in `src/services/userManagament.js`:
   ```javascript
   export const api = "http://localhost:9091/api/User";
   ```

Refer to the root [README.md](../README.md) for complete project overview and database configuration setup.
