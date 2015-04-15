package shop.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import shop.constants.JspConstants;
import shop.dao.UserDao;
import shop.model.User;
import shop.services.UserActionService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		UserActionService userRegistrationService = new UserActionService();
		User user = userRegistrationService.findUserByLoginPass(request);
		if (user != null) {
			forward = JspConstants.USER_LOGGED_PAGE;
			request.setAttribute("user", user);
		} else {
			forward = JspConstants.INVALID_AVTORIZATION_PAGE;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
