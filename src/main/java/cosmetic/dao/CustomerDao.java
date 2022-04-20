package cosmetic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cosmetic.model.Customer;

public class CustomerDao {
	
	protected Connection getConnection() {
		JDBC jdbc = new JDBC();
		return jdbc.getConnection();
	}

	
	public boolean addCustomer(Customer customer) throws SQLException{
		boolean inserted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Insert into customers values (?,?,?)");
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, customer.getCustomer_name());
			preparedStatement.setString(3, customer.getCustomer_phone());
			
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return inserted;
	}

	public List<Customer> getAllCustomer() {
		List<Customer> customer = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from customers order by customer_name");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				customer.add(new Customer(resultSet.getInt("customer_id"),resultSet.getString("customer_name"),resultSet.getString("phone_number")));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return customer;
	}

	
	public boolean deleteCustomer(int id) throws SQLException{
		boolean deleted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Delete from customers where customer_id = ?");
			preparedStatement.setInt(1, id);
			
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return deleted;
	}
	
	public Integer countCustomer() throws SQLException{
		int count = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select count(customer_id) as 'count' from customers");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				count = Integer.parseInt(resultSet.getString("count"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}

}
