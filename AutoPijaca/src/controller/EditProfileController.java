package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDetails;
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

		
		//1. Pronadji u bazi UserDetails ciji je user sa prihvacenim idUser
		User user = service.returnUserFromId(idUser);
		UserDetails details = service.returnUserDetailsFromUser(user);
		
		if (details == null) {
			response.sendRedirect("html_stranica/failed_UserDetails.html");
		}else {
			//2. Setuj UserDetails i sacuvaj u bazi izmene
			boolean editUserDetailsCheck = service.setUserDetails(firstName, lastName, phone, email, country, city, street, details);
			if(editUserDetailsCheck) {
				response.sendRedirect("jsp/seller.jsp");
			}else {
				response.sendRedirect("html_stranica/failed_UserDetails.html");
			}
			
			
			
		}
		
		


		
		
		
	}

}
