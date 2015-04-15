package shop.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.constants.JspConstants;
import shop.model.User;
import shop.services.UserActionService;

/**
 * Servlet implementation class UserManager
 */
public class UserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserActionService userActionService = new UserActionService();
		List<User> users = userActionService.getAllUsers();
		request.setAttribute("users", users);
		
		RequestDispatcher view = request.getRequestDispatcher(JspConstants.USER_MANAGEMENT_PAGE);
		view.forward(request, response);
	}

}
