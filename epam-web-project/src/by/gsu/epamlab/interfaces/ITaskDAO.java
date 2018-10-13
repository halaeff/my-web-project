package by.gsu.epamlab.interfaces;

import java.sql.Date;
import java.util.List;

import by.gsu.epamlab.bean.Task;
import by.gsu.epamlab.bean.User;

public interface ITaskDAO {
	List<Task> getTasks(User user);
	List<Task> getTasks(String user, String taskType, Date date);
}
