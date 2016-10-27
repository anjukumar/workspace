

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
import model.Samazoncart;
import model.Samazonproduct;
import model.Samazonuser;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		HttpSession session = request.getSession();
		
	
		
		int productid = Integer.parseInt(request.getParameter("productid"));
		
		Samazonuser user = (Samazonuser) session.getAttribute("user");
		
		Samazoncart cart = (Samazoncart)session.getAttribute("cart");
		
		int cartid = (int) cart.getCartid();
		
		System.out.println("cartid test " +cartid);
		
		
		cart= DbCartUtil.productbyid(productid);
		
		System.out.println("Deleting from the cart");
		DbCartUtil.delete(cart);
		System.out.println("Deleted");
		
	
		List<Samazoncart> order = null;
		
		
		order= DbCartUtil.getcartList((int) user.getUserid());
		session.setAttribute("order", order);
		System.out.println("Fetched the new list");		

		int totalprice = 0 ;
		for(int totalitems = 0 ; totalitems <order.size(); totalitems++) 
		{
			 totalprice =+ order.get(totalitems).getSamazonproduct().getPrice();
			
		}
		
		session.setAttribute("totalprice", totalprice);
		System.out.println("Current Balance is : " +totalprice);

		
		String nextURL= "/CartServlet";
		response.sendRedirect(request.getContextPath()+nextURL);
		System.out.println("Display");	
	}

}
