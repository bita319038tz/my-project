package cosmetic.web.delete;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.ProductDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
    	this.productDao = new ProductDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				if(productDao.deleteProduct(id)) {
					request.getSession().setAttribute("success", "Product has been successfull deleted, We have "+productDao.countProduct()+" products");
					response.sendRedirect("admin/product.jsp");
				}else {
					request.getSession().setAttribute("error", "Something went wrong");
					response.sendRedirect("admin/product.jsp");
				}
			} catch (SQLException e) {
				request.getSession().setAttribute("error", e.getLocalizedMessage());
				response.sendRedirect("admin/product.jsp");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
