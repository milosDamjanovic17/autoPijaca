package service;

import dao.AdminDAO;
import dao.EditProfileDAO;
import model.User;
import model.UserDetails;


public class EditProfileService {
	
	EditProfileDAO dao = new EditProfileDAO();
	AdminDAO adminDao = new AdminDAO();

	public User returnUserFromId(String idUser) {
		
		return adminDao.returnUserFromId(idUser);
	}

	public UserDetails returnUserDetailsFromUser(User user) {
		// TODO Auto-generated method stub
		return adminDao.returnDetailsFromUser(user);
	}

	public boolean setUserDetails(String firstName, String lastName, String phone, String email, String country,
			String city, String street, UserDetails details) {
		// TODO Auto-generated method stub
		return dao.setUserDetails(firstName, lastName, phone, email, country, city, street, details);
	}



}
