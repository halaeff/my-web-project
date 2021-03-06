package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.bean.Task;
import by.gsu.epamlab.bean.User;
import by.gsu.epamlab.factories.TaskFactory;
import by.gsu.epamlab.interfaces.BaseController;
import by.gsu.epamlab.interfaces.ITaskDAO;

public class TaskController extends BaseController {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String realPath = getServletConfig().getServletContext().getRealPath(Constants.NAME_PROJECT_ROOT)
				+ Constants.NAME_CLASSES_ROOT;
		String strDAO = config.getInitParameter(Constants.KEY_DAO);
		TaskFactory.setGlobals(realPath, strDAO);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
=======
		// User user = (User) request.getAttribute(Constants.KEY_USER);
		// String userLogin = null;
		// String userRole = null;
>>>>>>> branch 'master' of https://github.com/halaeff/my-web-project.git

		HttpSession session = request.getSession();
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/halaeff/my-web-project.git
		User user = (User) session.getAttribute(Constants.KEY_USER);
<<<<<<< HEAD
=======
		System.out.println("user without getSession" + request.getAttribute(Constants.KEY_USER));
		System.out.println("user: " + user.getName());
>>>>>>> branch 'master' of https://github.com/halaeff/my-web-project.git
		String tasksType = null;
<<<<<<< HEAD
		ITaskDAO taskDAO = TaskFactory.getClassFromFactory();
		if (request.getParameter(Constants.KEY_TASK_ACTION) != null) {
			if (request.getParameter(Constants.KEY_TASK_ACTION).equals("edit")) {
				System.out.println("editTask");
				String newTaskName = request.getParameter(Constants.KEY_TASK_NAME);
				Date newTaskDate = Date.valueOf(request.getParameter(Constants.KEY_TASK_DATE));
				int taskId = Integer.valueOf(request.getParameter(Constants.KEY_TASK_ID));
				taskDAO.editTask(taskId, newTaskName, newTaskDate);
			} else if (request.getParameter(Constants.KEY_TASK_ACTION).equals("create")) {
				String taskName = request.getParameter(Constants.KEY_TASK_NAME);
				Date taskDate = Date.valueOf(request.getParameter(Constants.KEY_TASK_DATE));
				taskDAO.createTask(user.getName(), taskName, taskDate);
			} else if (request.getParameter(Constants.KEY_TASK_ACTION).equals("delete")) {
				int taskId = Integer.valueOf(request.getParameter(Constants.KEY_TASK_ID));
				taskDAO.deleteTask(taskId);
			}else if (request.getParameter(Constants.KEY_TASK_ACTION).equals("complete")) {
				int taskId = Integer.valueOf(request.getParameter(Constants.KEY_TASK_ID));
				taskDAO.completeTask(taskId);
			}
		}
=======
>>>>>>> branch 'master' of https://github.com/halaeff/my-web-project.git
		if (request.getParameter(Constants.KEY_TASKS_TYPE) == null) {
			tasksType = Constants.KEY_TODAY;
		} else {
			tasksType = request.getParameter(Constants.KEY_TASKS_TYPE);
		}
		System.out.println(request.getParameter(ConstantsJSP.KEY_TASKS_DATE));
		Date date = Date.valueOf(request.getParameter(ConstantsJSP.KEY_TASKS_DATE));
<<<<<<< HEAD
=======
		System.out.println("Date: " + date);
		ITaskDAO taskDAO = TaskFactory.getClassFromFactory();

>>>>>>> branch 'master' of https://github.com/halaeff/my-web-project.git
		List<Task> tasks = taskDAO.getTasks(user.getName(), tasksType, date);

		request.setAttribute(Constants.KEY_TASK, tasks);
		forward(Constants.JUMP_MAIN, request, response);

	}

}
