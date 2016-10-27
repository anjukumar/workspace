

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbCartUtil;
import customTools.DbProductUtil;
import customTools.DbUserUtil;
import model.Samazoncart;
import model.Samazonproduct;
import model.Samazonuser;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		doGet(request, response);
		String useremail = request.getParameter("useremail");
		String userpassword = request.getParameter("userpassword");

		String nextURL ="/error.jsp";

		Samazonuser user=null;	
		
        List<Samazonproduct> product = null;
    	List<Samazoncart> order = null;
    	
		HttpSession session = request.getSession();
		System.out.println("Taking input............");
		if(DbUserUtil.isValidUser(useremail,userpassword))
		{
			System.out.println("Checking if user is valid.........");
			user = DbUserUtil.getUserByEmail(useremail);
			session.setAttribute("user", user);
			System.out.println("User valid");
			
			product =  DbProductUtil.product();
			session.setAttribute("product", product);
			
			order= DbCartUtil.getcartList((int) user.getUserid());
			session.setAttribute("order", order);
			
			nextURL="/Home";
		}

		else
		{
			System.out.println("Invalid  id password.........");
			nextURL="/LoginPage.jsp"; 
		}
		response.sendRedirect(request.getContextPath()+nextURL);
	}
	}


