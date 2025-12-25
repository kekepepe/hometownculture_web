<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <jsp:include page="header.jsp" />

        <h2>Explore Wenzhou Culture</h2>

        <c:forEach var="item" items="${items}">
            <div class="item-card">
                <img src="${pageContext.request.contextPath}/${item.imageUrl}" alt="${item.title}">
                <div class="item-details">
                    <h3>
                        <c:out value="${item.title}" />
                    </h3>
                    <div class="meta">
                        <strong>Type:</strong>
                        <c:out value="${item.type}" /> |
                        <strong>Category:</strong>
                        <c:out value="${item.category}" /> |
                        <strong>Location:</strong>
                        <c:out value="${item.location}" />
                    </div>
                    <p>
                        <c:out value="${item.description}" />
                    </p>
                </div>
            </div>
        </c:forEach>

        <jsp:include page="footer.jsp" />