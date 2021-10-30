package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserType;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "ovo je login", urlPatterns = { "/pathToLogin" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LoginService servis = new LoginService();
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		servis.ispisiParametre(userName, password);
		
		//validacija: user i pass moraju biti popunjeni
		
		boolean nullProvera = servis.loginNullProvera(userName, password);
		if(nullProvera) {
			
			// trazimo da li postoji user u DB
			// ako user postoji vrati != null objekat preusmeri ga na njegovu stranu, ako ne postoji vrati null
			User userLoginProvera = servis.userLoginProvera(userName,password);
			if(userLoginProvera != null) {
				System.out.println("========> USER EXISTS");
				//kreiranje httpSession objekta za pravljenje unique strane korisnika
				HttpSession session = request.getSession();
				//ubaci usera u HTTPsession object
				session.setAttribute("userKey", userLoginProvera);
				//prebaci ga na stranicu za kupca
				if (userLoginProvera.getUserType().equals(UserType.BUYER)) {
					//prebaci ga na stranicu za KUPCA/BUYER
					response.sendRedirect("jsp/buyer.jsp");
				}else if(userLoginProvera.getUserType().equals(UserType.SELLER)) {
					//prebaci ga na stranicu za PRODAVCA/SELLER
					response.sendRedirect("jsp/seller.jsp");
				}else {
					//prebaci ga na admin stranicu
					response.sendRedirect("jsp/admin.jsp");
				}
			}else {
				System.out.println("========> FAIL");
				response.sendRedirect("html_stranica/failed_login.html");
			}
				
		}else {
			response.sendRedirect("html_stranica/failed_login.html");
		}
		
	}

}
