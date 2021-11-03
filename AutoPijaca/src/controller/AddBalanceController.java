package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.AddBalanceService;

/**
 * Servlet implementation class AddBalanceController
 */
@WebServlet(description = "dodavanje balancea User", urlPatterns = { "/AddBalanceController" })
public class AddBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddBalanceService service = new AddBalanceService();
		
		String username = request.getParameter("username");
		String balance = request.getParameter("balance");
		
		
		Double parseBalanceFromString = Double.parseDouble(balance);
		User user = service.returnUserFromUsername(username);
		
		if(user != null) {
			
			boolean daLiJeDodatBalance = service.dodajBalanceUseru(user,parseBalanceFromString);
			if(daLiJeDodatBalance) {
				response.sendRedirect("html_stranica/successfullyAdeddbalanceToUser.html");
			}else {
				response.sendRedirect("html_stranica/userNameFailForAddingBalance.html");
			}
			
		}else {
			response.sendRedirect("html_stranica/userNameFailForAddingBalance.html");
		}
	}

}
