package shop.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import shop.dao.UserDao;
import shop.services.UserActionService;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final String WELLCOME_JSP_PAGE = "/pages/wellcome.jsp";
	private static final String REGISTRATION_JSP_PAGE = "/pages/registrationPage.jsp";
	private static final long serialVersionUID = 1L;
	UserDao dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		UserActionService userActionService = new UserActionService();
		userActionService.registrateNewUser(request);
		if(request.getAttribute("errors")!=null){
			forward = REGISTRATION_JSP_PAGE;
		}else{
			forward = WELLCOME_JSP_PAGE;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
