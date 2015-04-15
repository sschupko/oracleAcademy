package shop.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import shop.dao.UserDao;
import shop.model.User;
import shop.utils.JdbcDatabaseConnector;

public class JdbcUserDaoImpl implements UserDao {
	
	//-------
	private Connection connection;

	public JdbcUserDaoImpl() {
		connection = JdbcDatabaseConnector.getConnection();
	}
	
	public void checkUser(User user) {
	        try {
	            PreparedStatement ps = connection.prepareStatement("select uname from users where login = ?");
	            ps.setString(1, user.getLogin());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) // found
	            {
	                updateUser(user);
	            } else {
	                addUser(user);
	            }
	        } catch (Exception ex) {
	            System.out.println("Error in check() -->" + ex.getMessage());
	        } 
	    }
	    /* (non-Javadoc)
		 * @see shop.dao.UderDao#addUser(shop.model.User)
		 */
	    public void addUser(User user) {
	        try {
	        	System.err.println();
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(login, password, firstName, lastName, age, gender, dob ,email) values (?, ?, ?, ?,?,?,?,?)");
	            // Parameters start with 1
	            preparedStatement.setString(1, user.getLogin());
	            preparedStatement.setString(2, user.getPassword());
	            preparedStatement.setString(3, user.getFirstName());     
	            preparedStatement.setString(4, user.getLastName());  
	            preparedStatement.setInt(5, user.getAge());  
	            preparedStatement.setString(6, user.getGender());  
	            preparedStatement.setDate(7, (Date) user.getDob());
	            preparedStatement.setString(8, user.getEmail()); 
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    /* (non-Javadoc)
		 * @see shop.dao.UderDao#deleteUser(java.lang.String)
		 */
	    public void deleteUser(String userLogin) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where login=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, userLogin);
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    /* (non-Javadoc)
		 * @see shop.dao.UderDao#updateUser(shop.model.User)
		 */
	    public void updateUser(User user) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update users set password=?, firstName=?, lastName=?, age=?, gender=?, dob=? ,email=? where login=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, user.getPassword());
	            preparedStatement.setString(2, user.getFirstName());
	            preparedStatement.setString(3, user.getLastName());
	            preparedStatement.setInt(4, user.getAge());
	            preparedStatement.setString(5, user.getGender());
	            preparedStatement.setDate(6, (Date)user.getDob());
	            preparedStatement.setString(7, user.getEmail());
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    /* (non-Javadoc)
		 * @see shop.dao.UderDao#getAllUsers()
		 */
	    public List<User> getAllUsers() {
	        List<User> users = new ArrayList<User>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from users");
	            while (rs.next()) {
	                User user = new User();
	                user.setLogin(rs.getString("login"));
	                user.setFirstName(rs.getString("firstName"));
	                user.setLastName(rs.getString("lastName"));
	                user.setPassword(rs.getString("password"));
	                user.setAge(rs.getInt("age"));
	                user.setGender(rs.getString("gender"));
	                user.setDob(rs.getDate("dob"));
	                user.setEmail(rs.getString("email"));
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return users;
	    }
	 
	    /* (non-Javadoc)
		 * @see shop.dao.UderDao#getUserByLogin(java.lang.String)
		 */
	    public User getUserByLogin(String login) {
	        User user = null;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where login=?");
	            preparedStatement.setString(1, login);
	            ResultSet rs = preparedStatement.executeQuery();
	 
	            if (rs.next()) {
	            	user=new User();
		                user.setLogin(rs.getString("login"));
		                user.setFirstName(rs.getString("firstName"));
		                user.setLastName(rs.getString("lastName"));
		                user.setPassword(rs.getString("password"));
		                user.setAge(rs.getInt("age"));
		                user.setGender(rs.getString("gender"));
		                user.setDob(rs.getDate("dob"));
		                user.setEmail(rs.getString("email"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return user;
	    }
	
}
