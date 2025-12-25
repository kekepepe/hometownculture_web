<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wenzhou Culture Display</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header>
    <div class="logo">Wenzhou Culture</div>
    <nav>
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <span>Welcome, ${sessionScope.user.username}!</span>
                <a href="${pageContext.request.contextPath}/MainServlet">Home</a>
                <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
                <a href="${pageContext.request.contextPath}/register.jsp">Register</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>
<div class="container">
