package by.gsu.epamlab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.gsu.epamlab.bean.Task;
import by.gsu.epamlab.bean.User;
import by.gsu.epamlab.connection.ConnectToDB;
import by.gsu.epamlab.interfaces.ITaskDAO;

public class TaskImplDB implements ITaskDAO {
	private static final Logger LOGGER = Logger.getLogger(TaskImplDB.class.getName());
	private static Connection cn = null;

	@Override
	public List<Task> getTasks(User user) {
		Connection cn = ConnectToDB.getConnection();
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Task> tasks = new ArrayList<>();
		try {

			st = cn.createStatement();
			ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS);
			ps.setString(ConstantsSQL.LOGIN_IND, user.getName());
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(ConstantsSQL.ID_IND);
				String name = rs.getString(ConstantsSQL.NAME_IND);
				Date date = rs.getDate(ConstantsSQL.DATE_IND);
				Task task = new Task(id, name, date);
				tasks.add(task);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		} finally {
			ConnectToDB.close(cn, rs, st, ps);
		}
		return tasks;
	}

	public List<Task> getTasks(String userLogin, String tasksType, Date date) {
		cn = ConnectToDB.getConnection();
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Task> tasks = new ArrayList<>();
		try {
			st = cn.createStatement();
			ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS);
			TasksType tType = TasksType.valueOf(tasksType.toUpperCase());
			ps = getPreparedStatement(tType, date);
			ps.setString(ConstantsSQL.LOGIN_IND, userLogin);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(ConstantsSQL.ID_IND);
				String name = rs.getString(ConstantsSQL.NAME_IND);
				Date taskDate = rs.getDate(ConstantsSQL.DATE_IND);
				Task task = new Task(id, name, taskDate);
				tasks.add(task);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		} finally {
			ConnectToDB.close(cn, rs, st, ps);
		}
		return tasks;
	}

	private PreparedStatement getPreparedStatement(TasksType tasksType, Date date) {
		PreparedStatement ps = null;
		try {
			switch (tasksType) {
			case TODAY: {
				ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS_BY_DATE);
				ps.setDate(ConstantsSQL.PS_DATE_IND, date);
				break;
			}
			case TOMORROW: {
				ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS_BY_DATE);
				
				ps.setDate(ConstantsSQL.PS_DATE_IND, datePlusDay(date));
				break;
			}
			case SOMEDAY: {
				ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS_BY_DATE);
				ps.setDate(ConstantsSQL.PS_DATE_IND, date);
				break;
			}
			case FIXED: {
				ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS_FIXED);
				break;
			}
			case RECYCLED: {
				ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS_RECYCLED);
				break;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	
	private static Date datePlusDay(final Date date) {
		date.setDate(date.getDate()+1);		
		return date;
	}

}
