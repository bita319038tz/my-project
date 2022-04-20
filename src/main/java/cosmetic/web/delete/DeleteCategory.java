package cosmetic.web.delete;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.CategoryDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategory() {
    	this.categoryDao = new CategoryDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				if(categoryDao.deleteCategory(id)) {
					request.getSession().setAttribute("success", "Category has been successfull deleted, We have "+categoryDao.countCategory()+" categories");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
