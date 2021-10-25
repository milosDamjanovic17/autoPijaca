package service;

import common.CommonMethods;
import dao.RegistracijaLoginLogic;
import model.User;
import validacija.Validacija;

public class RegistracijaService {

	
	Validacija valid = new Validacija();
	RegistracijaLoginLogic logic = new RegistracijaLoginLogic();
	CommonMethods common = new CommonMethods();
	
	public void ispisiParametre(String username, String password, String repeatedPassword, String userType) {
		
		valid.ispisiParametre(username, password, repeatedPassword, userType);
	}

	public boolean validacijaPass(String password) {
		// TODO Auto-generated method stub
		return valid.validacijaPass(password);
	}

	public boolean repeatedPassCheck(String password, String repeatedPassword) {
		// TODO Auto-generated method stub
		return valid.repeatedPassCheckMethod(password, repeatedPassword);
	}

	public User popuniusera(String userName, String password, String repeatedPassword, String tipUsera) {
		
		return common.popuniUsera(userName, password, repeatedPassword, tipUsera);
	}

	public boolean upisiUsera(User user) {
		// TODO Auto-generated method stub
		return logic.upisiUsera(user);
	}
	
	
}
