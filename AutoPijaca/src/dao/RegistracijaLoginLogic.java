package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;
import model.UserDetails;

public class RegistracijaLoginLogic {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public boolean upisiUsera(User user) {
		
		UserDetails details = new UserDetails();
			details.setUser(user);
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			
			try {
				
				session.persist(user); //cuvam usera u DB
				session.persist(details);
				
				session.getTransaction().commit();
				System.out.println("User " +user.getUserName() +" upisan u DB");
				return true;
			} catch (Exception e) {
				
				System.out.println("Nesto je puklo...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}
		
	}

	public User userLoginProvera(String userName, String password) {
		
		User user = null;
		Session session = sf.openSession(); // sa getCurrentSessionom ne moramo posle da pozivamo zatvaranje sesije
			session.beginTransaction();
			
			try {
				
				String hql = "from User where username = :inputUserName and password = :inputPassword";
				Query query = session.createQuery(hql);
					query.setParameter("inputUserName", userName);
					query.setParameter("inputPassword", password);
					
				user = (User)query.getSingleResult();
				if(user != null) {
					System.out.println("user found");
					session.getTransaction().commit();
					return user;
				}else {
					System.out.println("user not found");
					session.getTransaction().commit();
					return null;
				}
			} catch (Exception e) {
				System.out.println("Nesto je puklo u userLoginProvera metodi");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			}finally {
				session.close();
			}
	}
	

}
