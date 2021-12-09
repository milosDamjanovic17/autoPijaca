package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.User;
import model.UserDetails;
import service.ChosenCarsService;

/**
 * Servlet implementation class PodaciOkupoviniController
 */
@WebServlet("/PodaciOkupoviniController")
public class PodaciOkupoviniController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ChosenCarsService service = new ChosenCarsService();
		
		String idUser = request.getParameter("idUser");
		String idCar = request.getParameter("idCar");
		
		System.out.println(idUser);
		System.out.println(idCar);
		
		Car car = service.vratiCarPoId(idCar);

		
		User user = service.vratiUseraPoId(idUser);
		UserDetails details = service.vratiUserDetailsPoUser(user);
		
		
		request.setAttribute("car", car);
		request.setAttribute("details", details);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/podaciOkupovini.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
