package service;

import common.CommonMethods;
import dao.AdminDAO;
import model.User;

public class AddBalanceService {

	AdminDAO dao = new AdminDAO();
	CommonMethods common = new CommonMethods();
	
	public User returnUserFromUsername(String username) {
		
		return dao.returnUserFromUsername(username);
	}

	public boolean dodajBalanceUseru(User user, Double parseBalanceFromString) {
		
		return dao.dodajBalanceUseru(user, parseBalanceFromString);
	}

	public boolean isDoubleCheck(String balance) {
		
		return common.isDoubleCheck(balance);
	}



}
