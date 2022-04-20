package cosmetic.web.delete;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cosmetic.dao.UserDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
    	this.userDao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				if(userDao.deleteUser(id)) {
					request.getSession().setAttribute("success", "User has been successfull deleted, We have "+userDao.countUsers()+" users");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
