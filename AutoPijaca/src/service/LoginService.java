package service;

import common.CommonMethods;
import dao.RegistracijaLoginLogic;
import validacija.Validacija;

public class LoginService {
	
	CommonMethods common = new CommonMethods();
	Validacija validacija = new Validacija();
	RegistracijaLoginLogic logic = new RegistracijaLoginLogic();

	public void ispisiParametre(String userName, String password) {
		
		
		common.ispisiParametre(userName,password);
	}

	public boolean loginNullProvera(String userName, String password) {
		// TODO Auto-generated method stub
		return validacija.loginNullProvera(userName, password);
	}

	public boolean userLoginProvera(String userName, String password) {
		// TODO Auto-generated method stub
		return logic.userLoginProvera(userName,password);
	}
	
	
	

}
