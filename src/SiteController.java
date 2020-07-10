

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	String action=request.getParameter("action");
	switch(action)
	{
	case "login":
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		break;
		default:
			break;
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action=request.getParameter("action");
		switch(action)
		{
		case "loginsubmit":
			authenticate(request, response);
			break;
		default:
			break;
		
		}
	}
public void authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("username");
	String userpassword=request.getParameter("userpassword");
	if(username.equals("priya") && userpassword.equals("abc123"))
	{
		request.getSession().invalidate();
		HttpSession session=request.getSession(true);
		session.setMaxInactiveInterval(300);
		Cookie cUsername=new Cookie("username",username);
		response.addCookie(cUsername);
		response.sendRedirect(request.getContextPath()+"/MemberController?action=successlogin");
	
	}
	else
	{
		response.sendRedirect(request.getContextPath()+"/SiteController?action=login");
	}
}
}
