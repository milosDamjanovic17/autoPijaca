package service;

import dao.AdminDAO;
import model.User;

public class AddBalanceService {

	AdminDAO dao = new AdminDAO();
	
	public User returnUserFromUsername(String username) {
		
		return dao.returnUserFromUsername(username);
	}

	public boolean dodajBalanceUseru(User user, Double parseBalanceFromString) {
		
		return dao.dodajBalanceUseru(user, parseBalanceFromString);
	}



}
