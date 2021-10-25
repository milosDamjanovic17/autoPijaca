package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			System.out.println("Sva polja su popunjena...");
			// trazimo da li postoji user u DB
			// ako user postoji vrati TRUE preusmeri ga na njegovu stranu, ako ne postoji vrati FALSE
			boolean userLoginProvera = servis.userLoginProvera(userName,password);
			if(userLoginProvera) {
				System.out.println("========> USER EXISTS");
			}else {
				System.out.println("========> FAIL");
			}
			
		}else {
			System.out.println("moras popuniti sva polja!");
		}
		
	}

}
