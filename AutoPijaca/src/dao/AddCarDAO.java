package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Car;
import model.UserDetails;

public class AddCarDAO {
	
	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	public Boolean daLiJeAutoRegistrovan(String isRegistered) {
		
		
		if(isRegistered == null) {
			return false;
		}else {
			return true;
		}
	}

	public Car fillCar(String manufacturer, String model, Double price, String year, Boolean isRegister,
			UserDetails details) {
		
		Car car = new Car();
			car.setManufacturer(manufacturer);
			car.setModel(model);
			car.setPrice(price);
			car.setYear(year);
			car.setIsRegistered(isRegister);
			car.setUserDetails(details);
		
		return car;
	}

	public boolean insertCarInDB(Car car) {
	
		Session session = sf.openSession();
			session.beginTransaction();
		
			try {
				
				session.persist(car);
				session.getTransaction().commit();
				System.out.println("Saving Car in DB");
				return true;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u inserCarInDB...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}

	}

	public boolean spojiUserDetailsIcar(UserDetails details, Car car) {

		Session session = sf.openSession();
		session.beginTransaction();
	
		try {
			//preuzimam perzsistenti objekat iz base tipa UserDetails
			UserDetails detailsFromDB = session.get(UserDetails.class, details.getIdUserDetails());
			//inicijalizujem listu Cars jer je FetchType.LAZY
			Hibernate.initialize(detailsFromDB.getCars()); // posto je fetchType LAZY, moram rucno da inicijalizujem tu listu
			//dodajem Car u listu tj spajam UserDetails i Car
			detailsFromDB.getCars().add(car);
			session.saveOrUpdate(detailsFromDB);
			
			session.getTransaction().commit();
			System.out.println("Ubacio u UserDetails listu...");
			return true;
		} catch (Exception e) {
			System.out.println("Nesto je puklo u spojiUserDetailsIcar...");
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}

	}

}
