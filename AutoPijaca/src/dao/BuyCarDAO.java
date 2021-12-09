package dao;

import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Car;
import model.SaveTransaction;
import model.UserDetails;

public class BuyCarDAO {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	
	public UserDetails returnUserDetailsFromId(String userDetailsId) {
		
		UserDetails userDetails = null;
		
		int idUserDetails = Integer.parseInt(userDetailsId);
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				userDetails = session.get(UserDetails.class, idUserDetails);
				Hibernate.initialize(userDetails.getCars());
					
				
				System.out.println("Retrieveing user from DB...");
				session.getTransaction().commit();
				return userDetails;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u returnUserDetailsFromID metodi.....");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}


	public void prebaciAutomobilSaProdavcaNaKupca(Car car, UserDetails prodavac, UserDetails kupac) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			
			try {
				 // dodaj auto kod kupca
				car.setUserDetails(kupac);
				kupac.getCars().add(car);
				
				// nadji auto koji se podudara sa prosledjenim ID i obrisi iz kolekcije prodavca
				for(Car c: prodavac.getCars()) {
					if(c.getIdCar() == car.getIdCar()) {
						System.out.println("obrisan automobil " +c.getManufacturer() +" " +c.getModel());
						prodavac.getCars().remove(c);
					}
				}
				
				// regulacija balansa
				prodavac.setBalance(prodavac.getBalance() + car.getPrice());
					System.out.println("novi balance prodavca: " +prodavac.getBalance());
				kupac.setBalance(kupac.getBalance() - car.getPrice());
					System.out.println("novi balance kupca: " +kupac.getBalance());
					
				 // updateuj tabele i stanje
				session.update(car);
				session.update(prodavac);
				session.update(kupac);
				
				session.getTransaction().commit();
				System.out.println("automobili prebaceni........");
			} catch (Exception e) {
				System.out.println("nesto je puklo prilikom prebacivanja kola.......");
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
		
		
	}


	public void sacuvajTransakciju(Car car, UserDetails prodavac, UserDetails kupac) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		SaveTransaction trx = new SaveTransaction();
		
		try {
			
			trx.setBuyer(kupac);
			trx.setSeller(prodavac);
			trx.setCar(car);
			trx.setDate(new Date());
			
			session.persist(trx);
			session.getTransaction().commit();
			System.out.println("transakcija sacuvana........");
		} catch (Exception e) {
			System.out.println("nesto je puklo prilikom trasakcije.......");
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
	}
	
	
	
}
