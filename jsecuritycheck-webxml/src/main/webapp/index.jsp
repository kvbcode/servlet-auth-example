<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
    java.security.Principal principal = request.getUserPrincipal();
    if (principal!=null){
        pageContext.setAttribute("isLoggedUser", true);
        pageContext.setAttribute("userName", principal.getName());
    }else{
        pageContext.setAttribute("userName", "Anonymous");
    };
%>
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
        <ul>
            <li><a href="${url_userinfo}">Current user information</a></li>
            <li><a href="${url_secured_user}">User page (secured)</a></li>
            <li><a href="${url_secured_admin}">Administrator page(secured)</a></li>
            <c:if test="${isLoggedUser}">
                <li><a href="${url_logout}">Logout</a></li>
            </c:if>
        </ul>
    </body>
</html>