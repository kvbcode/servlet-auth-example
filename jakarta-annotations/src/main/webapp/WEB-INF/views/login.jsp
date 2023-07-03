<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login</h2>

        <form action="${pageContext.request.contextPath}/login" method="post">
        <div>Username: <input type="text" name="j_username"></div>
        <div>Password: <input type="password" name="j_password"></div>
        <div><input type="submit" value="Submit"><input type="reset" value="Reset"></div>
        </form>
    </body>
</html>