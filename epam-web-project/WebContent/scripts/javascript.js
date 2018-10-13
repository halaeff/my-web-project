function sendForm(taskType) {
	if (taskType == 'Someday') {
		document.formTaskType.currDate.value = prompt(
				'Input the date YYYY-MM-DD', getCurrDate())
	} else {
		document.formTaskType.currDate.value = getCurrDate();
	}
	document.formTaskType.tasksType.value = taskType;
	document.formTaskType.submit();
}
function getCurrDate() {
	var currDate = new Date();
	var formattedDate = formatDate(currDate);
	return formattedDate;
}
function formatDate(date) {
	var dd = date.getDate();
	var mm = date.getMonth() + 1; // January is 0 but in SQL is 1
	var yyyy = date.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}
	date = yyyy + '-' + mm + '-' + dd;
	return date;
}
function hideAndShowDiv(hideDiv, showDiv) {
	document.getElementById(hideDiv).hidden = true;
	document.getElementById(showDiv).hidden = false;
}
function createTask(){
	var date = document.createTaskForm.dateOfTask.value;
	alert(date);
	document.createTaskForm.dateSQL.value=date;
	document.createTaskForm.submit();
}