package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Car;

public class ChosenCarsDAO {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	public Boolean pretvoriStringRegistracijuUboolean(String registration) {
		
		/* 
		 * ako je 0 vrati neregistrovane
		 * ako je 1 vrati registrovane
		 * ako je 2 vrati i registrovane i neregistrovane
		 * */
		
		
		Boolean returnValue;
		
		if(registration.equals("0")) {
			returnValue = false;
		}else if(registration.equals("1")){
			returnValue = true;
		}else {
			returnValue = null;
		}
		
		
		return returnValue;
	}

	@SuppressWarnings("unchecked")
	public List<Car> getChosenCars(String manufacturer, String model, Double priceFrom, Double priceTo, String yearFrom,
			String yearTo, Boolean isRegister) {
		
		List<Car> listaAutomobila = new ArrayList<Car>();
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				String hql = "from Car where 1=1";
				
				if(manufacturer != null && !manufacturer.equals("")) {
					hql += " and manufacturer = :manufacturer ";
				}
				
				if(model != null && !model.equals("")) {
					hql += " and model = :model";
				}
				
				if(priceFrom != null) {
					hql += " and price >= :priceFrom";
				}
				
				if(priceTo != null) {
					hql += " and price <= :priceTo";
				}
				
				if(!yearFrom.equals("0")) {
					hql += " and year >= :yearFrom";
				}
				
				if(!yearFrom.equals("0")) {
					hql += " and year <= :yearTo";
				}
				
				if(isRegister != null) {
					if(isRegister) {
						hql += " and isRegistered = true";
					}else {
						hql += " and isRegistered = false";
					}
				}
				
				System.out.println(hql);
				
				Query query = session.createQuery(hql);
				
				if(manufacturer != null && !manufacturer.equals("")) {
					query.setParameter("manufacturer", manufacturer);
				}
				
				if(model != null && !model.equals("")) {
					query.setParameter("model", model);
				}
				
				if(priceFrom != null) {
					query.setParameter("priceFrom", priceFrom);
				}
				
				if(priceTo != null) {
					query.setParameter("priceTo", priceTo);
				}
				
				if(!yearFrom.equals("0")) {
					query.setParameter("yearFrom", yearFrom);
				}
				
				if(!yearFrom.equals("0")) {
					query.setParameter("yearTo", yearTo);
				}
				
				listaAutomobila = (List<Car>)query.getResultList();
				
				
				
				session.getTransaction().commit();
				System.out.println("Returning cars list........." +listaAutomobila.size() +" rows");
				return listaAutomobila;
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("Nesto je puklo u getChosenCars metodi......");
				e.printStackTrace();
				return null;
			} finally {
				session.close();
			}

	}

	public Car vratiCarPoId(String idCar) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				Car car = session.get(Car.class, Integer.parseInt(idCar));
				System.out.println("preuzimam auto sa id = " +idCar);
				
				session.getTransaction().commit();
				return car;
			} catch (Exception e) {
				System.out.println("nesto je puklo u vratiCarPoId metodi......");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}
		
	}
	
	
}
