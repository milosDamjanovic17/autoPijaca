package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.RegistracijaService;

/**
 * Servlet implementation class RegistracijaController
 */
@WebServlet(description = "ovo je servlet za registraciju", urlPatterns = { "/pathToRegistracija" })
public class RegistracijaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistracijaController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//povezivanje na serivs
		RegistracijaService servis = new RegistracijaService();
		
		//prihvatanje parametara iz requesta
		System.out.println("Dobrodosli u doGet metodu...");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		String tipUsera = request.getParameter("tipUsera");
		
		//ispis parametara
		servis.ispisiParametre(userName, password, repeatedPassword, tipUsera);
		
		//valdiacija passworda
		boolean validacija = servis.validacijaPass(password);
		
		if(validacija) {
			//sve ok nastavljamo ka registraciji
			//provera da li je repeated pass isti kao i ukucan
			boolean repeatedPassCheck = servis.repeatedPassCheck(password, repeatedPassword);
			if(repeatedPassCheck) {
				System.out.println("Repeated pass ok");
				User user = servis.popuniusera(userName, password, repeatedPassword, tipUsera);
				//sacuvaj user u DB
				boolean upisiUseraUbazu = servis.upisiUsera(user);
				if(upisiUseraUbazu) {
					// ako je upisan u bazu ici ce na index stranicu
					response.sendRedirect("index.html");
				}else {
					//ako je fail vratice ga na registraciju
					response.sendRedirect("html_stranica/registracija.html");
				}
			}else {
				response.sendRedirect("html_stranica/registracijaWrongRepeatedPass.html");
			}
		}else {
			//ako nije ok pass, vrati clientu odgovor
			response.sendRedirect("html_stranica/wrong_password.html");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
