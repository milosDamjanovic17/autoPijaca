package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.User;
import model.UserDetails;
import service.AddCarService;

/**
 * Servlet implementation class AddCarController
 */
@WebServlet("/AddCarController")
public class AddCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		AddCarService service = new AddCarService();
		
		String idUser = request.getParameter("idUser");
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String priceFromForm = request.getParameter("price");
		Double price = Double.parseDouble(priceFromForm);
		String year = request.getParameter("year");
		String isRegistered = request.getParameter("isRegistered");
		
		Boolean isRegister =service.daLiJeAutoRegistrovan(isRegistered);
		

		User user = service.returnUserfromID(idUser);
		UserDetails details = service.returnUserDetailsFromUser(user);
		Car car = service.fillCar(manufacturer, model, price, year, isRegister, details);
		
		boolean insertCarInDB = service.insertCarInDB(car);
		
		if(insertCarInDB) {
			
			boolean spojiUserDetailsIcar = service.spojiUserDetailsIcar(details,car);
			if(spojiUserDetailsIcar) {
				System.out.println("SVE OK.......");
			}else {
				response.sendRedirect("jsp/seller.jsp");
			}
			
		}else {
			response.sendRedirect("jsp/seller.jsp");
		}
		
		
		
	}

}
