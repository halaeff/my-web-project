<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="by.gsu.epamlab.controllers.ConstantsJSP"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/style.css">

<script Language="JavaScript">
	function sendForm(taskType) {
		if(taskType=='Someday'){
			document.formTaskType.currDate.value = prompt('Input the date YYYY-MM-DD', getCurrDate())
		}else{
			document.formTaskType.currDate.value = getCurrDate();
		}
		document.formTaskType.tasksType.value = taskType;
		document.formTaskType.submit();
	}
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
</script>
</head>

<body>


	<div class="body-top">
		<ul>
			<li>User: ${user.name}</li>
			<li>Role: ${user.role}</li>

			<c:if test="${user.role eq 'ADMIN'}">
				<li><h4>my respect!</h4></li>
			</c:if>

			<li><form name="formOut" ACTION="logout" method="post">
					<input class="button-logout" type="submit" value="Logout" />

				</form></li>
		</ul>
	</div>




	<div class="body-tasks">
		<p>task here</p>
		<div class="body-tasks-type">
			<form name="formTaskType" ACTION="task" method="post">	
				<ul>
					<li><a href="JavaScript:sendForm('Today')">Today</a></li>
					<li><a href="JavaScript:sendForm('Tomorrow')">Tomorrow</a></li>
					<li><a href="JavaScript:sendForm('Someday')">Someday</a></li>
					<li><a href="JavaScript:sendForm('Fixed')">Fixed</a></li>
					<li><a href="JavaScript:sendForm('Recycled')">Recycled</a></li>
				</ul>
				<input type="hidden" name="tasksType"> <input type="hidden"
					id="currDate" value="" name=<%=ConstantsJSP.KEY_TASKS_DATE%>>
			</form>
		</div>

		<table>
			<c:forEach var="task" items="${tasks}" varStatus="status">
				<tr>
					<td>Task name: ${task.name}</td>
					<td>Task date: ${task.date}</td>
					<td><a href="JavaScript:editTask(${task.id})">edit task</a> </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>

	<footer>
		<p>
			Developed by Khalaev Vladimir <a href="mailto:halaeff@yandex.ru">halaeff@yandex.ru</a>
		</p>
	</footer>
</body>
</html>