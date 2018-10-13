package by.gsu.epamlab.interfaces;

import by.gsu.epamlab.bean.User;

public interface IUserDAO {
	public User getUser(String login, String password);
	public User regUser(String login, String password);
}
