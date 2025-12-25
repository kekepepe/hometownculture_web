# Hometown Culture Display System (Wenzhou Theme)

## Project Overview
This represents a comprehensive final course assignment for Java Web Development. The application is a "Hometown Culture Display System" focused on showcasing the rich heritage of **Wenzhou**. It is built using the standard Java EE technology stack (JSP + Servlet + JDBC) without any external frameworks, strictly adhering to the assignment constraints.

## Technology Stack
- **IDE**: Eclipse IDE for Enterprise Java Developers
- **Language**: Java 15
- **Server**: Apache Tomcat 9.0 (Servlet 4.0)
- **Database**: MySQL 8.0
- **Frontend**: JSP, JSTL, CSS
- **Backend**: Native Servlet, JDBC

## Features
1.  **User Management**:
    - User Registration (`RegisterServlet`)
    - Secure Login with Session Management (`LoginServlet`)
    - Access Control via Filters (`LoginFilter`)
2.  **Culture Display**:
    - Dynamic listing of culture items (Food, Scenery, Memories) fetched from the database.
    - Categorization (e.g., "Food", "Memories") and Location tagging.
3.  **Wenzhou Theme**: Content specific to Wenzhou (e.g., Fish Balls, Jiangxin Islet, Nanxi River).
4.  **Robust Architecture**: 
    - MVC Pattern (Model-View-Controller)
    - DAO Pattern for Database Access
    - Centralized Database Utility (`DBUtil`)

## Project Structure
```text
hometownculture_web/
├── src/
│   └── com/hometown/
│       ├── dao/          # Data Access Objects (UserDAO, CultureItemDAO)
│       ├── model/        # JavaBeans (User, CultureItem)
│       ├── servlet/      # Controllers (LoginServlet, MainServlet, etc.)
│       └── util/         # Utilities (DBUtil - Connection Manager)
├── WebContent/
│   ├── css/              # Stylesheets
│   ├── images/           # Images for culture items
│   ├── WEB-INF/
│   │   ├── lib/          # JAR Dependencies (mysql-connector, jstl)
*   │   └── web.xml       # (Minimal) Deployment Descriptor
│   ├── login.jsp         # Login View
│   ├── register.jsp      # Registration View
│   ├── main.jsp          # Main Dashboard
│   ├── header.jsp        # Reusable Header
│   └── footer.jsp        # Reusable Footer
└── database_setup.sql    # Database Initialization Script
```

## Setup Instructions

### 1. Database Configuration
1.  Ensure MySQL 8.0 is running.
2.  Open your MySQL client (e.g., Workbench).
3.  Execute the `database_setup.sql` script located in the project root.
    - This will create the `hometown_culture` database and the `users` and `culture_items` tables.
    - It also inserts mock data for Wenzhou culture items.

### 2. Eclipse Project Import
1.  Open Eclipse.
2.  Select `File` > `Open Projects from File System...`.
3.  Point to the `hometownculture_web` folder.
4.  Click `Finish`.

### 3. Dependencies
Ensure the following JAR files are in `WebContent/WEB-INF/lib` (and added to the Build Path):
*   `mysql-connector-j-8.x.x.jar`
*   `jstl-1.2.jar`

### 4. Database Connection
Open `src/com/hometown/util/DBUtil.java` and update the password field:
```java
private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";
```

## Running the Application
1.  Right-click the project in Eclipse Project Explorer.
2.  Select `Run As` > `Run on Server`.
3.  Choose **Tomcat v9.0**.
4.  The application should launch in your browser at `http://localhost:8080/hometownculture_web/`.

## Troubleshooting
- **Login Fails**: Check the Eclipse Console for "DEBUG" messages. Ensure the database password in `DBUtil.java` is correct.
- **404 Errors**: Ensure Tomcat is started and the URL path matches the project name.
- **Encoding Issues**: The project is configured for UTF-8. Ensure your Eclipse workspace is set to UTF-8 (`Preferences` > `General` > `Workspace`).

---
*Created for University Java Web Assignment - 2025*
