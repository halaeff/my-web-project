<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="by.gsu.epamlab.controllers.ConstantsJSP"%>
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
			<li><a href="index.jsp">Main page</a></li>
		</ul>
	</div>
	<br>
	<div class="block-form-style">
		<form name="loginForm" class="form-style"
			action="<c:url value='/login'/>" method="post">
			<input type="text" placeholder="Login" class="input-style"		name=<%=ConstantsJSP.KEY_LOGIN%>><br> 
			<input type="password" placeholder="Password" class="input-style"	name=<%=ConstantsJSP.KEY_PASSWORD%> value=""><br> 
			<input type="submit" value="Login" class="input-style"> 
			<input type="hidden" id="currDate" value=""	name=<%=ConstantsJSP.KEY_TASKS_DATE%>>
		</form>


	</div>
<script>
		function getCurrDate() {
			var currDate = new Date();
			var dd = currDate.getDate();
			var mm = currDate.getMonth() + 1; //January is 0 but in SQL is 1
			var yyyy = currDate.getFullYear();

			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}
			currDate = yyyy + '-' + mm + '-' + dd;
			return currDate;
		}
		document.loginForm.currDate.value = getCurrDate();
	</script>
	<script src="/scripts/javascript.js" language="javascript"></script>
	<div id="curDate"></div>
	<footer>
		<p>
			Developed by Khalaev Vladimir <a href="mailto:halaeff@yandex.ru">halaeff@yandex.ru</a>
		</p>
	</footer>
</body>

</html>
