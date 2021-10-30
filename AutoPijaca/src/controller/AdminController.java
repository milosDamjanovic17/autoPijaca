package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.AdminService;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminService service = new AdminService();
		
		List<User> userList = new ArrayList<>();
		
		userList = service.vratiSveUsere();
		
		
		if(userList != null) {
			//RequestDispatcher dispatcher = request.getRequestDispatcher(userList);
			System.out.println("Lista usera ima clanova: " +userList.size());
			request.setAttribute("userListKey", userList);
			response.sendRedirect("jsp/admin.jsp");
		}
	}

}
