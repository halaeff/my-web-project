package by.gsu.epamlab.factories;

import by.gsu.epamlab.controllers.Constants;
import by.gsu.epamlab.dao.TaskImplDB;
import by.gsu.epamlab.interfaces.ITaskDAO;

public class TaskFactory {
	private static String tasksSource;
	private static ITaskDAO taskDAO;
	
	
	public static void setGlobals(String realPath, String strDAO) {
		tasksSource = realPath + Constants.INPUT_FILENAME;
		/*
		 * Add 2nd type. hardcoded impl task and change false way
		 */
		taskDAO = Constants.KEY_DAO.equals(strDAO) ? new TaskImplDB() : new TaskImplDB();
	}
	
	public static String getUsersSourceName() {
		return tasksSource;
	}

	public static ITaskDAO getClassFromFactory() {
		return taskDAO;
	}


}
