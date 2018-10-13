
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