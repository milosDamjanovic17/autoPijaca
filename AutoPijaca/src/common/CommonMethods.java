package common;

import model.User;
import model.UserType;

public class CommonMethods {

	public User popuniUsera(String userName, String password, String repeatedPassword, String tipUsera) {
		
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			if(tipUsera.equals("prodavac")) {
				user.setUserType(UserType.SELLER);
			}else {
				user.setUserType(UserType.BUYER);
			}
		
		
		return user;
	}

	public void ispisiParametre(String userName, String password) {
		System.out.println("LOGIN PARAMETERS:");
		System.out.println("=================");
		System.out.println("Username: " +userName);
		System.out.println("Password: " +password);
		
	}


}