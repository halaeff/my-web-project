package by.gsu.epamlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.gsu.epamlab.bean.Role;
import by.gsu.epamlab.bean.User;
import by.gsu.epamlab.connection.ConnectToDB;
import by.gsu.epamlab.interfaces.IUserDAO;

public class DBUserImpl implements IUserDAO {
	private static final Logger LOGGER = Logger.getLogger(DBUserImpl.class.getName());
	private static Connection cn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;

	@Override
	public User getUser(String login, String password) {
		Role role = null;
		cn = ConnectToDB.getConnection();
		rs = getUserFromDB(login, password);
		try {
			if (rs.next()) {
				String cmpName = rs.getString(ConstantsSQL.SELECT_LOGIN_LOGIN_IND);
				String cmpPassword = rs.getString(ConstantsSQL.SELECT_LOGIN_PASSWORD_IND);
				boolean cmpIsAdmin = rs.getBoolean(ConstantsSQL.SELECT_LOGIN_IS_ADMIN_IND);
				if (cmpIsAdmin) {
					role = Role.getRole(login, password, cmpName, cmpPassword, Role.ADMIN);
				} else {
					role = Role.getRole(login, password, cmpName, cmpName, Role.USER);
				}
				return new User(login, role);
			} else
				return new User(login, Role.VISITOR);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		} finally {
			ConnectToDB.close(cn, rs, st, ps);
		}
		return null;
	}

	private ResultSet getUserFromDB(String login, String password) {
		try {
			st = cn.createStatement();
			ps = cn.prepareStatement(ConstantsSQL.SELECT_LOGIN);
			ps.setString(ConstantsSQL.SELECT_LOGIN_LOGIN_IND, login);
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return rs;
	}

	@Override
	public User regUser(String login, String password) {
		cn = ConnectToDB.getConnection();
		try {
			ps = cn.prepareStatement(ConstantsSQL.INSERT_USERS);
			ps.setString(ConstantsSQL.SELECT_LOGIN_LOGIN_IND, login);
			ps.setString(ConstantsSQL.SELECT_LOGIN_PASSWORD_IND, password);
			ps.setBoolean(ConstantsSQL.SELECT_LOGIN_IS_ADMIN_IND, false);
			synchronized (new String()) {
				rs = getUserFromDB(login, password);
				if (!rs.next()) {
					st = cn.createStatement();
					ps.executeUpdate();
					return new User(login, Role.USER);
				} else {
					return new User(login, Role.VISITOR);
				}
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		} finally {
			ConnectToDB.close(cn, rs, st, ps);
		}
		return null;
	}
}
