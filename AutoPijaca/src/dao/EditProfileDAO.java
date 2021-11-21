package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Address;
import model.Contact;
import model.UserDetails;


public class EditProfileDAO {

	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	public boolean setUserDetails(String firstName, String lastName, String phone, String email, String country,
			String city, String street, UserDetails details) {
		
		Session session = sf.openSession();
			session.beginTransaction();

		
			try {
				// pristupam jedinstvenoj UserDetails klasi i instanciram je u UserDetails persistedUserFromDB promenljivoj
				UserDetails persistedUserFromDB = session.get(UserDetails.class, details.getIdUserDetails()); 
				System.out.println("session.get je ok");
				
				
				persistedUserFromDB.setFirstName(firstName);
				persistedUserFromDB.setLastName(lastName);
				
				if(persistedUserFromDB.getContact() == null) {
					Contact contact = new Contact();
					contact.setPhone("default");
					contact.setEmail("default");
					persistedUserFromDB.setContact(contact);
				}else {
					persistedUserFromDB.getContact().setPhone(phone);
					persistedUserFromDB.getContact().setEmail(email);
				}
				
				if (persistedUserFromDB.getAddress() == null) {
					Address address = new Address();
					address.setCountry("default");
					address.setCity("default");
					address.setStreet("default");
					persistedUserFromDB.setAddress(address);
				} else {
					persistedUserFromDB.getAddress().setCountry(country);
					persistedUserFromDB.getAddress().setCity(city);
					persistedUserFromDB.getAddress().setStreet(street);
				}

				
				System.out.println("Updating userDetails in DB........");
				session.update(persistedUserFromDB);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Nesto je puklo u setUserDetailsu...");
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} finally {
				session.close();
			}
		
	}
		
}
