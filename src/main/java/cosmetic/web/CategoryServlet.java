package cosmetic.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.CategoryDao;
import cosmetic.model.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        this.categoryDao = new CategoryDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("admin/categories.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Category addCategory = new Category(name);
		try {
			if(categoryDao.addCategory(addCategory)) {
				request.getSession().setAttribute("success", "Record Successfull Added, we have "+categoryDao.countCategory()+" categories");
				response.sendRedirect("admin/categories.jsp");
			}else {
				request.getSession().setAttribute("error", "Something went wrong");
				response.sendRedirect("admin/categories.jsp");
			}
		} catch (SQLException e) {
			request.getSession().setAttribute("error", e.getLocalizedMessage());
			response.sendRedirect("admin/categories.jsp");
		}
	}

}
