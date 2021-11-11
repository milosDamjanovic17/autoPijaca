package controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserType;
import service.AdminService;

/**
 * Servlet implementation class AdminPrikaziController
 */
@WebServlet("/AdminPrikaziController")
public class AdminPrikaziController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminService service = new AdminService();
		
		String userType = request.getParameter("userType");
		System.out.println("Parametar: " +userType);
		
		UserType type =  service.vratiUserType(userType);
		
		//vrati mi sve usere po odabranom tipu
		List<User> users = service.vratiUserePoUserTypeu(type);
		
		if(users != null && !users.isEmpty()) {
			// listu usera pakujem u request object
			request.setAttribute("usersKey", users);
			// radim redirection postojocege request na stranu prikaziUsere.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/prikaziUsere.jsp");
			// spakuj request u response
			dispatcher.forward(request, response); //forwarduj request u response => jer response salje na view

		}else {
			response.sendRedirect("jsp/admin.jsp");
		}
		
		
	}

}
