

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DbCartUtil;
import model.Samazoncart;

/**
 * Servlet implementation class FinalCheckoutServlet
 */
@WebServlet("/FinalCheckoutServlet")
public class FinalCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalCheckoutServlet() {
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
		List<Samazoncart> order = null;
		order= DbCartUtil.getcartList();
		HttpSession session = request.getSession();
		session.setAttribute("order", order);
		int totalprice = 0;
			for(int totalitems = 0 ; totalitems <order.size(); totalitems++) 
			{
				 totalprice += order.get(totalitems).getSamazonproduct().getPrice();
			}
			System.out.println("Current Balance is : " +totalprice);
			
			String nextURL= "/checkout.jsp"+totalprice;
			
			response.sendRedirect(request.getContextPath()+nextURL);
		}
	}


