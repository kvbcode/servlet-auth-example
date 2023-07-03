<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin welcome page</title>
    </head>
    <body>
        <h2>Hello <%= request.getUserPrincipal().getName() %>!</h2>
        <p>Доступ к этой странице имеют только пользователя с ролью ROLE_ADMIN</p>
        <p><a href="${pageContext.request.contextPath}/">Вернутся</a></p>
    </body>
</html>