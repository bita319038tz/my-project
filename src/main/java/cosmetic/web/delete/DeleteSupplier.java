package cosmetic.web.delete;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.CustomerDao;
import cosmetic.dao.SupplierDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteSupplier")
public class DeleteSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
	private SupplierDao SupplierDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSupplier() {
    	this.SupplierDao = new SupplierDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				if(customerDao.deleteCustomer(id)) {
					request.getSession().setAttribute("success", "Supplier has been successfull deleted, We have "+SupplierDao.countSupplier()+" suppliers");
					response.sendRedirect("admin/supplier.jsp");
				}else {
					request.getSession().setAttribute("error", "Something went wrong");
					response.sendRedirect("admin/supplier.jsp");
				}
			} catch (SQLException e) {
				request.getSession().setAttribute("error", e.getLocalizedMessage());
				response.sendRedirect("admin/supplier.jsp");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}


	
	
