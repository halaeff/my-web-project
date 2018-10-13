package by.gsu.epamlab.dao;

public class ConstantsSQL {
	public static final String SELECT_LOGIN = "Select login,password,isAdmin from users where login=?";
	public static final String INSERT_USERS = "Insert into Users ('name','password','isAdmin') values(?,?,?)";
	public static final String SELECT_TASKS = "Select id, name, date from tasks where userLogin = ?";
	public static final String INSERT_TASKS = "Insert into Tasks ('name', 'date', 'userLogin') values(?,?,?)";
	public static final String SELECT_TASKS_TODAY = "Select id, name, date from tasks where userLogin = ? and date=?";
	public static final String SELECT_TASKS_BY_DATE = "Select id, name, date from tasks where userLogin = ? and date=?";
	public static final String SELECT_TASKS_TOMORROW = "Select id, name, date from tasks where userLogin = ? and date=?";
	public static final String SELECT_TASKS_SOMEDAY = "Select id, name, date from tasks where userLogin = ? and date=?";
	public static final String SELECT_TASKS_FIXED = "Select id, name, date from tasks where userLogin = ? and fixed=1";
	public static final String SELECT_TASKS_RECYCLED = "Select id, name, date from tasks where userLogin = ? and recycled=1";
	public static final int LOGIN_IND = 1;
	public static final int PASSWORD_IND = 2;
	public static final int IS_ADMIN_IND = 3;
	public static final int ID_IND = 1;
	public static final int NAME_IND = 2;
	public static final int DATE_IND = 3;
	public static final int FIXED_IND = 5;
	public static final int RECYCLED_IND = 6;
	public static final int PS_DATE_IND = 2;
	
}
