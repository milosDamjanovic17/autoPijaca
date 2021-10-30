package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

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
				session.getTransaction().commit();
				return listaUsera;
			} catch (Exception e) {
				session.getTransaction().rollback();
				e.printStackTrace();
				System.out.println("nesto je puklo u metodu vratiSveUsere");
				return null;
			} finally {
				session.close();
			}

	}
	
	
}
