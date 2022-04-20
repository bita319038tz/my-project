package cosmetic.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.CustomerDao;
import cosmetic.model.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
    	this.customerDao = new CustomerDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("admin/customer.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		Customer addCustomer = new Customer(name,phone);
		try {
			if(customerDao.addCustomer(addCustomer)) {
				request.getSession().setAttribute("success", "Record Successfull Added, we have "+customerDao.countCustomer()+" customers");
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

}
