

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
       super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("action");
		switch(action)
		{
		case "logout":
			request.getSession().invalidate();
			Cookie[] cookies=request.getCookies();
			
			for(Cookie cookie:cookies)
			{	
				if(cookie.getName().equals("username"))
				{
					cookie.setValue(null);
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					
				}
			}
			response.sendRedirect(request.getContextPath()+"/SiteController?action=logins");
			break;
		case "successlogin":
			request.getRequestDispatcher("MemberArea.jsp").forward(request, response);;
			break;
		default:
			break;
		
		}
			
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
