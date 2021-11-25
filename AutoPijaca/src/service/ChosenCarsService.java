package service;

import dao.ChosenCarsDAO;

public class ChosenCarsService {

	ChosenCarsDAO dao = new ChosenCarsDAO();

	public Boolean pretvoriStringRegistracijuUboolean(String registration) {
		
		return dao.pretvoriStringRegistracijuUboolean(registration);
	}
	
	
	
}
