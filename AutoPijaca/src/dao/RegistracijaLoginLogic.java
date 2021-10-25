package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class RegistracijaLoginLogic {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public boolean upisiUsera(User user) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			
			try {
				
				session.persist(user); //cuvam usera u DB
				
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

	public boolean userLoginProvera(String userName, String password) {
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				String hql = "from User where username = :inputUserName and password = :inputPassword";
				Query query = session.createQuery(hql);
				query.setParameter("inputUserName", userName);
				query.setParameter("inputPassword", password);
				
				User user =(User)query.getSingleResult();
				if(user != null) {
					System.out.println("user found");
				}else {
					System.out.println("user not found");
				}
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u userLoginProvera metodi");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}
		
	}
	

}
