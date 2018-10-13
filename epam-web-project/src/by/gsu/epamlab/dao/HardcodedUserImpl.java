package by.gsu.epamlab.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.gsu.epamlab.bean.Role;
import by.gsu.epamlab.bean.User;
import by.gsu.epamlab.interfaces.IUserDAO;

public class HardcodedUserImpl implements IUserDAO {
	private static List<User> users = new ArrayList<>();

	@Override
	public User getUser(String login, String password) {
		User user = getUserFromList(login, password);

		if (user != null) {
			if (password.equals(user.getPassword())) {
				return new User(login, user.getRole());
			} else {
				return new User(login, Role.FAKER);
			}
		} else {
			return new User(login, Role.VISITOR);
		}
	}

	/**
	 * this block adding users into users.
	 */
	static {
		final String ADMIN_LOGIN = "sys", ADMIN_PASSWORD = "111";
		final String USER_LOGIN = "boss", USER_PASSWORD = "000";
		final String USER1_LOGIN = "user1", USER1_PASSWORD = "000";
		users.add(new User(ADMIN_LOGIN, ADMIN_PASSWORD, Role.ADMIN));
		users.add(new User(USER_LOGIN, USER_PASSWORD, Role.USER));
		users.add(new User(USER1_LOGIN, USER1_PASSWORD, Role.USER));
		Collections.sort(users);
	}

	private static User getUserFromList(String login, String password) {
		int indexUser = Collections.binarySearch(users, new User(login, Role.USER));
		if (indexUser >= 0) {
			return users.get(indexUser);
		} else
			return null;
	}

	@Override
	public User regUser(String login, String password) {
		User user = getUserFromList(login, password);
		synchronized (new String()) {
			if (user == null) {
				users.add(new User(login, password, Role.USER));
				return new User(login, Role.USER);
			} else {
				return new User(login, Role.VISITOR);
			}
		}
	}

}
