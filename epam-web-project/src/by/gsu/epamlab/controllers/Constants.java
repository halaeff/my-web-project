package by.gsu.epamlab.controllers;

import by.gsu.epamlab.interfaces.IUserDAO;

public class Constants {
	public static final String NAME_CLASSES_ROOT = "WEB-INF\\classes\\";
	public static final String NAME_PROJECT_ROOT = "/";
	public static final String INPUT_FILENAME = "by\\gsu\\epamlab\\resources\\users.csv";
	public static final String KEY_USER = "user";
	public static final String KEY_TASK = "tasks";
	public static final String KEY_TASKS_TYPE = "tasksType";
	public static final String KEY_TASKS_DATE = "tasksDate";
	public static final String KEY_TODAY = "today";
	public static final String KEY_DAO = "db";
	
    public static final String JUMP_MAIN = "/main.jsp";
    public static final String JUMP_ERROR = "/index.jsp";
    public static final String JUMP_INDEX = "/index.jsp";
    public static final String JUMP_TASK = "/task";
    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    public static final String KEY_EMPTY = "";
    public static final String ERROR_EMPTY = "Login is empty.";
    public static final String ERROR_NULL = "Login or password are absent.";
    public static final String ERROR_SOURCE = "Input source proccessing problems.";
    public static final String ERROR_PASSWORD = "Password is invalid.";
    public static final String USER_ALREADY_EXISTS = "User with this name already exists.";
    public static final String CONNECTION_EXCEPTION = "Database connection is failed";
    
    public static final String USER_DAO = IUserDAO.class.getName();

}
