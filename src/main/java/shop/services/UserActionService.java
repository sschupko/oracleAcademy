package shop.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;

import shop.dao.UserDao;
import shop.dao.impl.HibernateUserDaoImpl;
import shop.model.User;
import shop.utils.UserFieldstValidator;
public class UserActionService {
	private UserDao dao;

	public UserActionService() {
		dao = new HibernateUserDaoImpl();
	}
@Transactional
	public void registrateNewUser(HttpServletRequest request) {
		if(!isValidRegistrationInfo(request)){
			return;
		}
		User user = new User();
		user.setLogin(request.getParameter("login"));
		String authentificationCode = prepareAuthentificationCode(request);
		request.setAttribute("md5", authentificationCode);
		user.setPassword(authentificationCode);
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		try {
			Date parsedDate = new SimpleDateFormat("yyyy/MM/dd").parse(request
					.getParameter("dob"));
			user.setDob(new java.sql.Date(parsedDate.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setAge(request.getParameter("age"));
		user.setGender(request.getParameter("gender"));
		user.setEmail(request.getParameter("email"));
		dao.addUser(user);
	}

	private boolean isValidRegistrationInfo(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		UserFieldstValidator validator = new UserFieldstValidator();
		if (!validator.isValidLogin(request.getParameter("login"))) {
			errors.put("login", "Login should starts from letter and have more then 4 chars. Please input a valid login");
		}
		if (!validator.isValidPassword(request.getParameter("password"))) {
			errors.put("password", "Password should contains letters and numbers!. Please input a valid password");

		}
		if (!validator.isValidFirstName(request.getParameter("firstName"))) {
			errors.put("firstName", "First name should consists from non-numbers only. Please correct first name");

		}
		if (!validator.isValidLastName(request.getParameter("lastName"))) {
			errors.put("lastName", "Last name should consists from non-numbers only. Please correct last name");

		}
		if (!validator.isValidDob(request.getParameter("dob"))) {
			errors.put("dob", "Incorrect format of date of birth. Please correct the date");

		}
		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			return false;
		}
		return true;
	}

	public User findUserByLoginPass(HttpServletRequest request) {
		String login = request.getParameter("login");
		User user = dao.getUserByLogin(login);
		if (user != null
				&& user.getPassword().equals(
						prepareAuthentificationCode(request))) {
			return user;
		}
		return null;
	}
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	private String prepareAuthentificationCode(HttpServletRequest request) {
		String authentificationCode = DigestUtils.md5Hex(request
				.getParameter("password"));
		return authentificationCode;
	}
}
