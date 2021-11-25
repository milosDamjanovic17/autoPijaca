package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ChosenCarsService;

/**
 * Servlet implementation class ChosenCarsController
 */
@WebServlet("/ChosenCarsController")
public class ChosenCarsController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ChosenCarsService service = new ChosenCarsService();
		
		
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String priceFromForm = request.getParameter("priceFrom");
		String priceToForm = request.getParameter("priceTo");//sredi ako je prazno
		String yearFrom = request.getParameter("yearFrom");//sredi ako je prazno
		String yearTo = request.getParameter("yearTo");
		String registration = request.getParameter("registration");
		
		//if null, sredi
		Double priceFrom = Double.parseDouble(priceFromForm);
		Double priceTo = Double.parseDouble(priceToForm);
		
		Boolean isRegister = service.pretvoriStringRegistracijuUboolean(registration);
		
		
		System.out.println("manufacturer: " +manufacturer);
		System.out.println("model: " +model);
		System.out.println("priceFrom: " +priceFrom);
		System.out.println("priceTo: " +priceTo);
		System.out.println("myearFrom: " +yearFrom);
		System.out.println("yearTo: " +yearTo);
		System.out.println("registration: " +registration);
		
		
		
		
		
	}

}
