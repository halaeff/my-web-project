package by.gsu.epamlab.interfaces;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.controllers.Constants;

public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void forward(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);		
	}
	
	protected void forwardError(String message, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(Constants.KEY_ERROR_MESSAGE, message);
		forward(Constants.JUMP_ERROR, request, response);
	}
}
