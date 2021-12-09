package service;

import java.util.List;

import dao.AdminDAO;
import dao.ChosenCarsDAO;
import model.Car;
import model.User;
import model.UserDetails;

public class ChosenCarsService {

	ChosenCarsDAO dao = new ChosenCarsDAO();
	AdminDAO adminDao = new AdminDAO();

	public Boolean pretvoriStringRegistracijuUboolean(String registration) {
		
		return dao.pretvoriStringRegistracijuUboolean(registration);
	}

	public List<Car> getChosenCars(String manufacturer, String model, Double priceFrom, Double priceTo, String yearFrom,
			String yearTo, Boolean isRegister) {
		// TODO Auto-generated method stub
		return dao.getChosenCars(manufacturer, model, priceFrom, priceTo, yearFrom, yearTo, isRegister);
	}

	public Car vratiCarPoId(String idCar) {
		
		return dao.vratiCarPoId(idCar);
	}

	public User vratiUseraPoId(String idUser) {
		
		return adminDao.returnUserFromId(idUser);
	}

	public UserDetails vratiUserDetailsPoUser(User user) {
		
		return adminDao.returnDetailsFromUser(user);
	}
	
	
	
}
