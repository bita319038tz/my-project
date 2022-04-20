package cosmetic.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.ProductDao;
import cosmetic.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        this.productDao = new ProductDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("admin/product.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int category = Integer.parseInt(request.getParameter("category"));
		Product addProduct = new Product(name,price, category);
		try {
			if(productDao.addProduct(addProduct)) {
				request.getSession().setAttribute("success", "Record Successfull Added, we have "+productDao.countProduct()+" products");
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

}
