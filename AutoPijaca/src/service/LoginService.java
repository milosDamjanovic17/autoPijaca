package service;

import common.CommonMethods;
import dao.RegistracijaLoginLogic;
import model.User;
import validacija.Validacija;

public class LoginService {
	
	CommonMethods common = new CommonMethods();
	Validacija validacija = new Validacija();
	RegistracijaLoginLogic logic = new RegistracijaLoginLogic();

	public void ispisiParametre(String userName, String password) {
		
		
		common.ispisiParametre(userName,password);
	}

	public boolean loginNullProvera(String userName, String password) {
		
		return validacija.loginNullProvera(userName, password);
	}

	public User userLoginProvera(String userName, String password) {
		
		return logic.userLoginProvera(userName,password);
	}
	
	
	

}
