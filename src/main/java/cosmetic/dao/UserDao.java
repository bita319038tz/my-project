package cosmetic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cosmetic.model.User;

public class UserDao {
	
	protected Connection getConnection() {
		JDBC jdbc = new JDBC();
		return jdbc.getConnection();
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {
		User user = null;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from users where username = ? AND password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				user = new User(resultSet.getInt("user_id"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("full_names"),
						resultSet.getString("user_role"),resultSet.getString("phone_number"));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}

	
	public boolean addUser(User user) throws SQLException{
		boolean inserted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Insert into users  values (?,?,?,?,?,?)");
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getFullName());
			preparedStatement.setString(5, user.getPhoneNumber());
			preparedStatement.setString(6, user.getUserRole());
			
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return inserted;
	}

	public boolean updateUser(User user, int id) throws SQLException{
		boolean updated = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Update users set full_names = ?, phone_number = ?, user_role = ? where user_id = ?");
			preparedStatement.setString(1, user.getFullName());
			preparedStatement.setString(2, user.getPhoneNumber());
			preparedStatement.setString(3, user.getUserRole());
			preparedStatement.setInt(4, id);
			
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return updated;
	}

	public User getUserById(int id) {
		User user = null;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from users where user_id = ?");
			preparedStatement.setInt(4, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				user = new User(id,resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("full_names"),
						resultSet.getString("user_role"),resultSet.getString("phone_number"));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}
	
	public Integer countUsers() {
		int total = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select count(user_id) as 'total' from users");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				total = resultSet.getInt("total");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return total;
	}

	public List<User> getAllUsers() {
		List<User> user = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from users order by full_names");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				user.add(new User(resultSet.getInt("user_id"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("full_names"),
						resultSet.getString("user_role"),resultSet.getString("phone_number")));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}

	
	public boolean deleteUser(int id) throws SQLException{
		boolean deleted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Delete from users where user_id = ?");
			preparedStatement.setInt(1, id);
			
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return deleted;
	}

}
