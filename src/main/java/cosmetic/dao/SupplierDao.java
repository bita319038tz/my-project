package cosmetic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cosmetic.model.Supplier;

	public class SupplierDao {
		
		protected Connection getConnection() {
			JDBC jdbc = new JDBC();
			return jdbc.getConnection();
		}

		
		public boolean addSupplier(Supplier supplier) throws SQLException{
			boolean inserted = false;
			try {
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `supplier`(`Supplier_id`, `Supplier_name`, `Contact_no`, `Place`) VALUES (?,?,?,?)");
				preparedStatement.setString(1, null);
				preparedStatement.setString(2, supplier.getSupplier_name());
				preparedStatement.setString(3, supplier.getContact_no());
				preparedStatement.setString(4, supplier.getPlace());
				
				if(preparedStatement.executeUpdate() > 0) {
					return true;
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return inserted;
		}

		public List<Supplier> getSupplier() {
			List<Supplier> supplier = new ArrayList<>();
			try {
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("Select * from supplier");
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					supplier.add(new Supplier(resultSet.getInt("supplier_id"),resultSet.getString("Supplier_name"),resultSet.getString("Contact_no"),resultSet.getString("Place")));
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			
			return supplier;
		}

		
		public boolean deleteSupplier(int id) throws SQLException{
			boolean deleted = false;
			try {
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("Delete from supplier where supplier_id = ?");
				preparedStatement.setInt(1, id);
				
				if(preparedStatement.executeUpdate() > 0) {
					return true;
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			return deleted;
		}
		
		public Integer countSupplier() throws SQLException{
			int count = 0;
			try {
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("Select count(supplier_id) as 'count' from supplier");
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
