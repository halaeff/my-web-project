package by.gsu.epamlab.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		

<<<<<<< HEAD

	
=======
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {

			System.out.println("logout before " + cookie.getName() + " " + cookie.getValue());
			cookie.setMaxAge(0);
			cookie.setValue(null);
			cookie.setPath("/");
			System.out.println("logout after " + cookie.getName() + " " + cookie.getValue());
			response.addCookie(cookie);
		}
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println("\n_________________________________");
				Cookie c1 = cookies[i];
				String name1 = c1.getName();
				String value1 = c1.getValue();
				String path = c1.getPath();
				System.out.println("Path:" + path + "<BR>");
				System.out.println(name1 + " = " + value1 + "<BR>");

				System.out.println("_________________________________\n");
			}
		}
>>>>>>> branch 'master' of https://github.com/halaeff/my-web-project.git
		request.getRequestDispatcher(Constants.JUMP_INDEX).forward(request, response);
	}

}
