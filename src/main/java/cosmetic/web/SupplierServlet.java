package cosmetic.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.SupplierDao;
import cosmetic.model.Supplier;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/supplier")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupplierDao supplierDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServlet() {
    	this.supplierDao = new SupplierDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("admin/supplier.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("supplier_name");
		String phone = request.getParameter("phone");
		String place = request.getParameter("place");
		
		Supplier addSupplier = new Supplier(0,name, phone,place);
		
		try {
			if(supplierDao.addSupplier(addSupplier)) {
				request.getSession().setAttribute("success", "Record Successfull Added, we have "+supplierDao.countSupplier()+" suppliers");
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

}
