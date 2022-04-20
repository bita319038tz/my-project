package cosmetic.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cosmetic.dao.UserDao;
import cosmetic.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	this.userDao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDao.getUserByUsernameAndPassword(username, password);
		if(user == null) {
			request.getSession().setAttribute("error", "Invalid username or password");
			response.sendRedirect("index.jsp");
		}else {
			HttpSession session = request.getSession();
		    session.setAttribute("islogin", "true");
		    session.setAttribute("username", user.getUsername());
		    session.setAttribute("fullName", user.getFullName());
		    session.setAttribute("userId", user.getUserId());
			response.sendRedirect("admin/dashboard.jsp");
		}
	}

}
