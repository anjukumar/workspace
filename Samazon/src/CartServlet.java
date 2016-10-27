

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbCartUtil;
import customTools.DbProductUtil;
import model.Samazoncart;
import model.Samazonproduct;
import model.Samazonuser;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			
		String nextURL= "/cart.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			HttpSession session = request.getSession();
		int productid = Integer.parseInt(request.getParameter("productid"));
		System.out.println("Productid. *****************************" +productid);
		String nextURL ="/error.jsp";
		Date date = new Date();
		Samazonproduct product = DbProductUtil.productbyid(productid);
		
		Samazonuser user = (Samazonuser) session.getAttribute("user");
		Samazoncart cart = new Samazoncart();

		System.out.println("Setting parameters ");
		cart.setSamazonproduct(product);
		cart.setSamazonuser((Samazonuser) session.getAttribute("user"));
		cart.setOrderdate(date);
		cart.setOrderstatus("n");
		System.out.println("Adding into the cart");


		DbCartUtil.insert(cart);
		System.out.println("Added");

		session.setAttribute("cart", cart);
		
		List<Samazoncart> order = null;
		System.out.println("User id test: " + user.getUserid());
		
		order= DbCartUtil.getcartList((int) user.getUserid());
		session.setAttribute("order", order);
		System.out.println("Taking new order");



		int totalprice = 0;
		
	
			for(int totalitems = 0 ; totalitems <order.size(); totalitems++) 
		{
			totalprice += order.get(totalitems).getSamazonproduct().getPrice();
			
		}

		
		session.setAttribute("totalprice", totalprice);
		System.out.println("Current Balance is : " +totalprice);

		
		nextURL= "/cart.jsp";
		response.sendRedirect(request.getContextPath()+nextURL);
	}

}


