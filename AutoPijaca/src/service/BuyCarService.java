package service;

import dao.BuyCarDAO;
import dao.ChosenCarsDAO;
import model.Car;
import model.UserDetails;

public class BuyCarService {

	BuyCarDAO dao = new BuyCarDAO();
	ChosenCarsDAO chosenCarsDao = new ChosenCarsDAO();
	
	
	public Car vratiCarPoId(String idCar) {
		
		return chosenCarsDao.vratiCarPoId(idCar);
	}


	public UserDetails vratiUserDetailsPoId(String idBuyerUserDetails) {
		
		return dao.returnUserDetailsFromId(idBuyerUserDetails);
	}


	public void prebaciAutomobilSaProdavcaNaKupca(Car car, UserDetails prodavac, UserDetails kupac) {
		
		dao.prebaciAutomobilSaProdavcaNaKupca(car, prodavac, kupac);
	}


	public void sacuvajTransakciju(Car car, UserDetails prodavac, UserDetails kupac) {
		
		dao.sacuvajTransakciju(car, prodavac, kupac);
	}
	
	
	
	
	
	
}
