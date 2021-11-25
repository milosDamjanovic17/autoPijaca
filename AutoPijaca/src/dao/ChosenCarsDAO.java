package dao;

import org.hibernate.SessionFactory;

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
	
	
}
