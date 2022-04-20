package cosmetic.web.delete;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.CustomerDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomer() {
    	this.customerDao = new CustomerDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				if(customerDao.deleteCustomer(id)) {
					request.getSession().setAttribute("success", "Customer has been successfull deleted, We have "+customerDao.countCustomer()+" customers");
					response.sendRedirect("admin/customer.jsp");
				}else {
					request.getSession().setAttribute("error", "Something went wrong");
					response.sendRedirect("admin/customer.jsp");
				}
			} catch (SQLException e) {
				request.getSession().setAttribute("error", e.getLocalizedMessage());
				response.sendRedirect("admin/customer.jsp");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
