<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="by.gsu.epamlab.controllers.ConstantsJSP"%>
<%@ taglib uri="/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/style.css">

<script src="scripts/javascript.js">
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


	<div class="body-tasks" id="body-tasks">
		<div class="body-tasks-type" id="body-tasks-type">
			<a href="JavaScript:hideAndShowDiv('body-tasks','create-task-form')">Create
				task</a>
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
			<tr>
				<td>Task name:</td>
				<td>Task date:</td>
			</tr>
			<c:forEach var="task" items="${tasks}" varStatus="status">
				<tr>
					<td>${task.name}</td>
					<td>${task.date}</td>
					<td width=75px align="right"><a
						href="JavaScript:editTask('edit')">Edit</a></td>
					<td><a href="JavaScript:editTask('delete')">Delete</a></td>
					<td><a href="JavaScript:editTask('complete')">Complete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="create-task-form" hidden>
		<a href="JavaScript:hideAndShowDiv('create-task-form','body-tasks')">back</a>
		<form name="createTaskForm" action="create" method="post">
			<table>
				<tr>
					<th>Name of task</th>
					<th>Date of task</th>
				</tr>
				<tr>
					<td><input type="text" name="nameOfTask"></td>
					<td><input type="date" name="dateOfTask" id="dateOfTask"></td>
				</tr>
			</table>
	<input type="hidden" name="dateSQL">
			<a href="JavaScript:createTask()">Create</a>
		</form>
	</div>
	<br>

	<footer>
		<p>
			Developed by Khalaev Vladimir <a href="mailto:halaeff@yandex.ru">halaeff@yandex.ru</a>
		</p>
	</footer>
</body>
</html>