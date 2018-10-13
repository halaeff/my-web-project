package by.gsu.epamlab.dao;

public class ConstantsSQL {
	public static final String SELECT_LOGIN = "Select login,password,isAdmin from users where login=?";
	public static final String INSERT_USERS = "Insert into Users ('name','password','isAdmin') values(?,?,?)";
	public static final String SELECT_TASKS = "Select id, name, date from tasks where userLogin = ?";

	public static final String SELECT_TASKS_BY_DATE = "Select id, name, date from tasks where userLogin = ? and date=? and isRecycled='0'";

	public static final String SELECT_TASKS_FIXED = "Select id, name, date from tasks where userLogin = ? and isFixed='1' and isRecycled='0'";
	public static final String SELECT_TASKS_RECYCLED = "Select id, name, date from tasks where userLogin = ? and isRecycled='1'";
	public static final String INSERT_TASK = "Insert into tasks (name,date,userLogin,isFixed,isRecycled) VALUES (?,?,?,'0','0')";
	public static final String UPDATE_TASK = "Update tasks set name=?, date=? where id=?";
	public static final String COMPLETE_TASK = "Update tasks set isFixed='1' where id=?";
	public static final String DELETE_TASK = "Update tasks set isRecycled='1' where id=?";
	public static final int SELECT_LOGIN_LOGIN_IND = 1;
	public static final int SELECT_LOGIN_PASSWORD_IND = 2;
	public static final int SELECT_LOGIN_IS_ADMIN_IND = 3;
	public static final int SELECT_TASKS_ID_IND = 1;
	public static final int SELECT_TASKS_NAME_IND = 2;
	public static final int SELECT_TASKS_DATE_IND = 3;
	public static final int SELECT_TASKS_FIXED_IND = 5;
	public static final int SELECT_TASKS_RECYCLED_IND = 6;
	public static final int SELECT_TASKS_PS_DATE_IND = 2;

	public static final int TASK_NAME_IND = 1;
	public static final int TASK_DATE_IND = 2;
	public static final int INSERT_TASK_USERLOGIN_IND = 3;
	public static final int UPDATE_TASK_ID_IND = 3;
	public static final int TASK_ID = 1;

}
