package service;

import dao.AddCarDAO;
import dao.AdminDAO;
import model.Car;
import model.User;
import model.UserDetails;

public class AddCarService {

	AddCarDAO dao = new AddCarDAO();
	AdminDAO adminDAO = new AdminDAO();
	
	
	public User returnUserfromID(String idUser) {
		
		return adminDAO.returnUserFromId(idUser);
	}


	public UserDetails returnUserDetailsFromUser(User user) {

		return adminDAO.returnDetailsFromUser(user);
	}


	public Boolean daLiJeAutoRegistrovan(String isRegistered) {

		return dao.daLiJeAutoRegistrovan(isRegistered);
	}


	public Car fillCar(String manufacturer, String model, Double price, String year, Boolean isRegister,
			UserDetails details) {

		return dao.fillCar(manufacturer, model, price, year, isRegister,
				details);
	}


	public boolean insertCarInDB(Car car) {
		
		return dao.insertCarInDB(car);
	}


	public boolean spojiUserDetailsIcar(UserDetails details, Car car) {

		return dao.spojiUserDetailsIcar(details, car);
	}
	
	
}
