package service;

import java.util.List;

import dao.AdminDAO;
import model.User;

public class AdminService {

	AdminDAO dao = new AdminDAO();

	public List<User> vratiSveUsere() {
		// TODO Auto-generated method stub
		return dao.vratiSveUsere();
	}
	
}
