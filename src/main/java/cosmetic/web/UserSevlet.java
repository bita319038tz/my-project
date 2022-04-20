package cosmetic.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.UserDao;
import cosmetic.model.User;

/**
 * Servlet implementation class UserSevlet
 */
@WebServlet("/user")
public class UserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSevlet() {
        this.userDao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("user.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String userName = request.getParameter("username");
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");
		User addUser = new User(userName,"12345",fullname,phone,role);
		try {
			if(userDao.addUser(addUser)) {
				request.getSession().setAttribute("success", "Record Successfull Added, We have "+userDao.countUsers()+" users");
				response.sendRedirect("admin/user.jsp");
			}else {
				request.getSession().setAttribute("error", "Something went wrong");
				response.sendRedirect("admin/user.jsp");
			}
		} catch (SQLException e) {
			request.getSession().setAttribute("error", e.getLocalizedMessage());
			response.sendRedirect("admin/user.jsp");
		}
	}

}
