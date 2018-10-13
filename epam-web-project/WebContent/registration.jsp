<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.gsu.epamlab.controllers.ConstantsJSP" %>
<%@ taglib uri="/jstl/core" prefix="c"%>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Web Project Epam Lab</title>

</head>

<body>
    <div class="body-top">
        <ul>
            <li> <a href="index.jsp">Main page</a></li>
        </ul>
    </div>
    <br>
    <div class="block-form-style">
        <form name="loginForm" class="form-style" action="<c:url value='/registration'/>" method="post">
            <input type="text" placeholder="Login" class="input-style" name=<%= ConstantsJSP.KEY_LOGIN %>><br>
            <input type="password" placeholder="Password" class="input-style" name=<%= ConstantsJSP.KEY_PASSWORD %> value="">><br>
            <input type="submit" value="Registrate" class="input-style">
        </form>
    </div>
    <footer>
        <p> Developed by Khalaev Vladimir <a href="mailto:halaeff@yandex.ru">halaeff@yandex.ru</a></p>
    </footer>
</body>

</html>
