package by.gsu.epamlab.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.bean.Role;
import by.gsu.epamlab.bean.User;
import by.gsu.epamlab.factories.UserFactory;
import by.gsu.epamlab.interfaces.BaseController;
import by.gsu.epamlab.interfaces.IUserDAO;

public class RegController extends BaseController {
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String realPath = getServletConfig().getServletContext().getRealPath(
				Constants.NAME_PROJECT_ROOT)
				+ Constants.NAME_CLASSES_ROOT;
		String strDAO = config.getInitParameter(Constants.KEY_DAO);
		UserFactory.setGlobals(realPath, strDAO);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(ConstantsJSP.KEY_LOGIN);
		String password = request.getParameter(ConstantsJSP.KEY_PASSWORD);
		if (login == null || password == null) {
			forwardError(Constants.ERROR_NULL, request, response);
			return;
		}
		login = login.trim();
		password = password.trim();
		if(Constants.KEY_EMPTY.equals(login) || Constants.KEY_EMPTY.equals(password)) {
			forwardError(Constants.ERROR_EMPTY, request, response);
			return;
		}

		IUserDAO userDAO = UserFactory.getClassFromFactory();
		User user = userDAO.regUser(login, password);
		if(user.getRole() == Role.USER) {
			
			request.setAttribute("user", user);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.JUMP_MAIN);	
			rd.forward(request, response);			
			
		} else {
			
			forwardError(Constants.USER_ALREADY_EXISTS, request, response);
			
		}
	}
}
