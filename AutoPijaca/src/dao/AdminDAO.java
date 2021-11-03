package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;
import model.UserDetails;

public class AdminDAO {

	SessionFactory sf = HibernateUtil.createSessionFactory();

	public List<User> vratiSveUsere() {
		
		List<User> listaUsera = new ArrayList<>();
		
		Session session = sf.openSession();
			session.beginTransaction();
			
			
			try {
				
				String hql = "from User";
				Query query = session.createQuery(hql);
				
				listaUsera = (List<User>)query.getResultList();
					System.out.println("Preuzeo sve usere...");
				session.getTransaction().commit();
				return listaUsera;
			} catch (Exception e) {
				session.getTransaction().rollback();
				e.printStackTrace();
				System.out.println("nesto je puklo u metodi vratiSveUsere");
				return null;
			} finally {
				session.close();
			}

	}

	public User returnUserFromUsername(String username) {
		
		User user = null;
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				
				String hql = "from User where username = :usernameInput";
				Query query = session.createQuery(hql);
					query.setParameter("usernameInput", username);
					
				user = (User) query.getSingleResult(); //PREDPOSTAVLJAM DA SVAKI KORISNIK IMA UNIQUE USERNAME ZATO VRACAM SINGLE RESULT
				System.out.println("Retrieveing user from DB...");
				session.getTransaction().commit();
				return user;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u returnFromUsername metodi.....");
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			} finally {
				session.close();
			}

	}

	public boolean dodajBalanceUseru(User user, Double balance) {
		
		Session session = sf.openSession();
			session.beginTransaction();
		
			try {
				
				User userFromDB = session.get(User.class, user.getIdUser()); // ovde smestam usera kog sam dobio is userInputa na sajtu, da bih mogao posle da pristupim njegovim podacima u veznoj tabeli UserDetails
				String hql = "from UserDetails where user = :userFromDB";
				Query query = session.createQuery(hql);
					query.setParameter("userFromDB", userFromDB);
					
				UserDetails details = (UserDetails)query.getSingleResult();
				
				if(details.getBalance() != null) {
					details.setBalance(details.getBalance() + balance);
				}else {
					details.setBalance(balance);
				}
				
				session.update(details);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u dodajBalanceUseru");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}
			
	}
	
	
}
