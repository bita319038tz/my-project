package cosmetic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cosmetic.model.Category;

public class CategoryDao {
	
	protected Connection getConnection() {
		JDBC jdbc = new JDBC();
		return jdbc.getConnection();
	}

	
	public boolean addCategory(Category category) throws SQLException{
		boolean inserted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Insert into categories values (?,?)");
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, category.getCategory_name());
			
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return inserted;
	}

	public List<Category> getAllCategory() {
		List<Category> categories = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from categories order by category_name");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				categories.add(new Category(resultSet.getInt("category_id"),resultSet.getString("category_name")));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return categories;
	}

	public Integer countCategory() {
		int total = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select count(category_id) as 'total' from categories");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				total = resultSet.getInt("total");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return total;
	}
	
	public boolean deleteCategory(int id) throws SQLException{
		boolean deleted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Delete from categories where category_id = ?");
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
