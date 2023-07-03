<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="url_login" value="/login"/>
<c:url var="url_userinfo" value="/userinfo"/>
<c:url var="url_secured_user" value="/secured/user.jsp"/>
<c:url var="url_secured_admin" value="/secured/admin.jsp"/>
<c:url var="url_logout" value="/logout"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <h2>Welcome ${userName}</h2>
            <p>
                <c:choose>
                    <c:when test="${isLoggedUser}">
                        <a href="${url_logout}">Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${url_login}">Login</a>
                    </c:otherwise>
                </c:choose>
            </p>
        <ul>
            <li><a href="${url_userinfo}">Current user information</a></li>
            <li><a href="${url_secured_user}">User page (secured)</a></li>
            <li><a href="${url_secured_admin}">Administrator page(secured)</a></li>
        </ul>
    </body>
</html>