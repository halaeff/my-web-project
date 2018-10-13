package by.gsu.epamlab.factories;

import by.gsu.epamlab.controllers.Constants;
import by.gsu.epamlab.dao.DBUserImpl;
import by.gsu.epamlab.dao.HardcodedUserImpl;
import by.gsu.epamlab.interfaces.IUserDAO;

public class UserFactory {
	private static String usersSource;
	private static IUserDAO userDAO;
	
	
	public static void setGlobals(String realPath, String strDAO) {
		usersSource = realPath + Constants.INPUT_FILENAME;
		userDAO = Constants.KEY_DAO.equals(strDAO) ? new DBUserImpl() : new HardcodedUserImpl();
	}
	
	public static String getUsersSourceName() {
		return usersSource;
	}

	public static IUserDAO getClassFromFactory() {
		return userDAO;
	}


}
