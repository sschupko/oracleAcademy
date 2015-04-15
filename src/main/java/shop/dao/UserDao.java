package shop.dao;

import java.util.List;

import shop.model.User;

public interface UserDao {

	void checkUser(User user);

	void addUser(User user);

	void deleteUser(String userLogin);

	List<User> getAllUsers();

	User getUserByLogin(String login);

}