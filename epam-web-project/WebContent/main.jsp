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
		<a href="JavaScript:hideAndShowDiv('body-tasks','create-task-form')">Create
			task</a>
		<div class="body-tasks-type" id="body-tasks-type">

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
					<td width=75px align="right">
						<form name="editTask${task.id }" method="POST" action="task">
							<input type="hidden" name="taskId" value=${task.id }>
							<div id="hiddenElements" hidden="true">
								<input type="text" name="taskName" value=${task.name }>
								<input type="text" name="taskDate" value=${task.date }>
							</div>

						</form> <a
						href="JavaScript:editTask('${task.id }','${task.name }','${task.date }')">Edit</a>
					</td>
					<td><form name="deleteTask${task.id }"
							id="deleteTask${task.id }" method="POST" action="task">
							<input name="taskAction" type="hidden" value="delete"> <input
								type="hidden" name="taskId" value=${task.id }><input
								type="hidden" id="currDate" value=""
								name=<%=ConstantsJSP.KEY_TASKS_DATE%>>
						</form> <a href="JavaScript:deleteTask('deleteTask${task.id }')">Delete</a></td>

					<td><form name="completeTask${task.id }"
							id="completeTask${task.id }" method="POST" action="task">
							<input name="taskAction" type="hidden" value="complete">
							<input type="hidden" name="taskId" value=${task.id }><input
								type="hidden" id="currDate" value=""
								name=<%=ConstantsJSP.KEY_TASKS_DATE%>>
						</form> <a href="JavaScript:completeTask('completeTask${task.id }')">Complete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="edit-task-form" hidden="true">
		<a href="JavaScript:hideAndShowDiv('edit-task-form','body-tasks')">back</a>
		<form name="editTaskForm" action="task" method="post">
			<input name="taskAction" type="hidden" value="edit">
			<p>edit task edit task</p>
			<table>
				<tr>
					<th>Name of task</th>
					<th>Date of task</th>
				</tr>
				<tr>
					<td><input type="text" name="taskName"></td>
					<td><input type="text" name="taskDate" id="taskDate"></td>
				</tr>
			</table>
			<input type="hidden" name="taskId" value=""> <input
				type="hidden" id="currDate" value=""
				name=<%=ConstantsJSP.KEY_TASKS_DATE%>> <a
				href="JavaScript:createTask()">Edit</a> <input type="submit"
				value="ok!">
		</form>
	</div>

	<div id="create-task-form" hidden="true">
		<a href="JavaScript:hideAndShowDiv('create-task-form','body-tasks')">back</a>
		<form name="createTaskForm" action="task" method="post">
			<input name="taskAction" type="hidden" value="create">
			<table>
				<tr>
					<th>Name of task</th>
					<th>Date of task</th>
				</tr>
				<tr>
					<td><input type="text" name="taskName"></td>
					<td><input type="date" name="taskDate" id="taskDate"></td>
				</tr>
			</table>
			<input type="hidden" id="currDate" value=""
				name=<%=ConstantsJSP.KEY_TASKS_DATE%>> <a
				href="JavaScript:createTask()">Create</a>
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