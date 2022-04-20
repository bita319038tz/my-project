package cosmetic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cosmetic.model.Product;

public class ProductDao {
	
	protected Connection getConnection() {
		JDBC jdbc = new JDBC();
		return jdbc.getConnection();
	}
	
	public boolean addProduct(Product product) throws SQLException{
		boolean inserted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Insert into products  values (?,?,?,?)");
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setInt(3, product.getCategoryId());
			preparedStatement.setString(4, product.getProductPrice());
			
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return inserted;
	}


	public List<Product> getAllProducts() {
		List<Product> product = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from products p JOIN categories c ON p.category_id = c.category_id order by product_name");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				product.add(new Product(resultSet.getInt("product_id"),resultSet.getString("product_name"),resultSet.getString("product_price"),resultSet.getInt("category_id"),resultSet.getString("category_name")));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return product;
	}

	
	public boolean deleteProduct(int id) throws SQLException{
		boolean deleted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Delete from products where product_id = ?");
			preparedStatement.setInt(1, id);
			
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return deleted;
	}
	
	public Integer countProduct() throws SQLException{
		int count = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select count(product_id) as 'count' from products");
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
