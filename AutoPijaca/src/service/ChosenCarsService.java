package service;

import java.util.List;

import dao.ChosenCarsDAO;
import model.Car;

public class ChosenCarsService {

	ChosenCarsDAO dao = new ChosenCarsDAO();

	public Boolean pretvoriStringRegistracijuUboolean(String registration) {
		
		return dao.pretvoriStringRegistracijuUboolean(registration);
	}

	public List<Car> getChosenCars(String manufacturer, String model, Double priceFrom, Double priceTo, String yearFrom,
			String yearTo, Boolean isRegister) {
		// TODO Auto-generated method stub
		return dao.getChosenCars(manufacturer, model, priceFrom, priceTo, yearFrom, yearTo, isRegister);
	}
	
	
	
}
