package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.UserDetails;
import service.BuyCarService;

/**
 * Servlet implementation class BuyCarController
 */
@WebServlet("/BuyCarController")
public class BuyCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BuyCarService service = new BuyCarService();
		
		String idCar = request.getParameter("idCar");
		String idBuyerUserDetails = request.getParameter("idBuyerUserDetails");
		
		System.out.println(idCar);
		System.out.println(idBuyerUserDetails);
		
		// izvadi ponovo objekat Car i izvuci prodavca iz automobila i UserDetails 
		Car car = service.vratiCarPoId(idCar);
		UserDetails prodavac = service.vratiUserDetailsPoId(car.getUserDetails().getIdUserDetails().toString());
		UserDetails kupac = service.vratiUserDetailsPoId(idBuyerUserDetails);
		// proveri da li kupac ima dovoljno novca(balance)
		if(kupac.getBalance() >= car.getPrice()) {
			// ako ima dovoljno novca prebaci auto na novog usera i regulisi balance
			service.prebaciAutomobilSaProdavcaNaKupca(car, prodavac, kupac);
			// sacuvaj transakciju
			service.sacuvajTransakciju(car,prodavac,kupac);
			
			response.sendRedirect("jsp/buyer.jsp");
		}else {
			response.sendRedirect("jsp/buyerInsufficientBalance.jsp");
		}

		
		
		
		
	}

}
