<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Web project Epam lab</title>
</head>
<body>
	<div class="body-top">
		<ul>
			<li>User: guest</li>
			<li><a href="login.jsp">Login</a></li>
			<li><a href="registration.jsp">Registrate</a></li>
		</ul>
	</div>
	<div >
		<h3>${errorMessage}</h3>
	</div>

	<footer>
		<p>
			Developed by Khalaev Vladimir <a href="mailto:halaeff@yandex.ru">halaeff@yandex.ru</a>
		</p>
	</footer>
</body>
</html>