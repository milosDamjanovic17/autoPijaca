package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EditProfileService;

/**
 * Servlet implementation class EditProfileController
 */
@WebServlet(description = "za editovanje userDetails", urlPatterns = { "/EditProfileController" })
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EditProfileService service = new EditProfileService();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String idUser = request.getParameter("idUser");
		
		System.out.println("First name: " +firstName);
		System.out.println("Last name: " +lastName);
		System.out.println("Phone: " +phone);
		System.out.println("Email: " +email);
		System.out.println("Country: " +country);
		System.out.println("City: " +city);
		System.out.println("Street: " +street);
		System.out.println("USER ID: " +idUser);
		
		
	}

}
