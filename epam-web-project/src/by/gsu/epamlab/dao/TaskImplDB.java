package by.gsu.epamlab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
			ps.setString(ConstantsSQL.SELECT_LOGIN_LOGIN_IND, user.getName());
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(ConstantsSQL.SELECT_TASKS_ID_IND);
				String name = rs.getString(ConstantsSQL.SELECT_TASKS_NAME_IND);
				Date date = rs.getDate(ConstantsSQL.SELECT_TASKS_DATE_IND);
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

	@Override
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
			ps.setString(ConstantsSQL.SELECT_LOGIN_LOGIN_IND, userLogin);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(ConstantsSQL.SELECT_TASKS_ID_IND);
				String name = rs.getString(ConstantsSQL.SELECT_TASKS_NAME_IND);
				Date taskDate = rs.getDate(ConstantsSQL.SELECT_TASKS_DATE_IND);
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
				ps = getPreparedStatementByDay(date);
				break;
			}
			case TOMORROW: {
				ps = getPreparedStatementByDay(datePlusDay(date));
				break;
			}
			case SOMEDAY: {
				ps = getPreparedStatementByDay(date);
				break;
			}
			case FIXED: {
				ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS_FIXED);
				System.out.println("try fixed");
				break;
			}
			case RECYCLED: {
				ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS_RECYCLED);
				break;
			}
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return ps;
	}

	private PreparedStatement getPreparedStatementByDay(Date date) {
		PreparedStatement ps = null;
		try {
			ps = cn.prepareStatement(ConstantsSQL.SELECT_TASKS_BY_DATE);
			ps.setDate(ConstantsSQL.SELECT_TASKS_PS_DATE_IND, date);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return ps;
	}

	private static Date datePlusDay(Date date) {
		date.setDate(date.getDate() + 1);

		return date;
	}

	@Override
	public void createTask(String user, String taskName, Date taskDate) {
		PreparedStatement ps = null;
		Statement st = null;
		cn = ConnectToDB.getConnection();
		try {
			ps = cn.prepareStatement(ConstantsSQL.INSERT_TASK);
			ps.setString(ConstantsSQL.TASK_NAME_IND, taskName);
			ps.setDate(ConstantsSQL.TASK_DATE_IND, taskDate);
			ps.setString(ConstantsSQL.INSERT_TASK_USERLOGIN_IND, user);
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}finally {
			ConnectToDB.close(cn, null, st, ps);
		}

	}

	@Override
	public void editTask(int taskId, String taskName, Date taskDate) {
		PreparedStatement ps = null;
		Statement st = null;
		cn = ConnectToDB.getConnection();
		try {
			ps = cn.prepareStatement(ConstantsSQL.UPDATE_TASK);
			ps.setString(ConstantsSQL.TASK_NAME_IND, taskName);
			ps.setDate(ConstantsSQL.TASK_DATE_IND, taskDate);
			ps.setInt(ConstantsSQL.UPDATE_TASK_ID_IND, taskId);
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}finally {
			ConnectToDB.close(cn, null, st, ps);
		}

	}

	@Override
	public void deleteTask(int taskId) {
		PreparedStatement ps = null;
		cn = ConnectToDB.getConnection();
		try {
			ps = cn.prepareStatement(ConstantsSQL.DELETE_TASK);
			ps.setInt(ConstantsSQL.TASK_ID, taskId);
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}finally {
			ConnectToDB.close(cn, null, null, ps);
		}		
	}
	public void completeTask(int taskId) {
		PreparedStatement ps = null;
		cn = ConnectToDB.getConnection();
		try {
			ps = cn.prepareStatement(ConstantsSQL.COMPLETE_TASK);
			ps.setInt(ConstantsSQL.TASK_ID, taskId);
			ps.executeUpdate();
			System.out.println("comleted");
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}finally {
			ConnectToDB.close(cn, null, null, ps);
		}	
	}

}
