<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <jsp:include page="header.jsp" />

    <h2>Login</h2>
    <p class="error">${requestScope.error}</p>
    <c:if test="${param.registered}">
        <p class="success">Registration successful! Please login.</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <div class="form-group">
            <label>Username:</label>
            <input type="text" name="username" required>
        </div>
        <div class="form-group">
            <label>Password:</label>
            <input type="password" name="password" required>
        </div>
        <button type="submit" class="btn">Login</button>
    </form>

    <jsp:include page="footer.jsp" />