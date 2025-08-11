## **E-Notes Project – Real-Time Application**

### **Technology Stack**

* **Backend**: Spring Boot REST API, JPA, AOP, Logging, Actuator, Spring Security, OAuth Login, Caching, JUnit & Mockito, SonarQube, JMeter, Swagger, Scheduler, Docker, GitHub.
* **Frontend**: Angular or React.
* **Database**: MySQL.
* **Tools**: GitHub, Spring Tool Suite (STS), Figma.
* **Deployment**: AWS Cloud.

---

### **Core Features**

#### **1. User Authentication & Authorization**

* User registration with **email verification**.
* Secure login using **JWT-based token authentication**.
* Role-based access control (**Admin**, **User**).

---

#### **2. Notes Management**

* Create, update, and delete **categories**.
* Filter and view notes by category.
* Create, edit, and delete notes.
* Save notes with **file attachments** (PDF, images, etc.).
* View or download attachments directly from notes.
* **Paginated view** for large note collections.
* Advanced **search** by title, content, or category.
* Mark notes as **favorite** and view favorite list.
* Copy notes.
* Export notes (**single or all**) in **Excel** or **PDF** formats.

---

#### **3. To-Do Management**

* Create, edit, and delete tasks.
* Assign **priority levels** (Low, Medium, High).
* Set **task status**: To-Do, In Progress, Completed.
* Set **reminders** with push notifications or email alerts.

---

### **Additional Functionalities**

* **Generic Response Handling**:

  * Centralized utility class for sending consistent success/error responses.
  * Shared exception handling for both application errors and validation failures.

---

### **Best Practices Implemented**

* **Global Exception Handling** with `@ControllerAdvice`.
* **Auditing** for tracking changes.
* **SOLID principles** in design.
* **Clean code** with proper comments, naming conventions, and modular structure.

---
to make that diagram?
