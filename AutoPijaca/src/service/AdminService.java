package service;

import java.util.List;

import common.CommonMethods;
import dao.AdminDAO;
import model.User;
import model.UserType;

public class AdminService {

	AdminDAO dao = new AdminDAO();
	CommonMethods common = new CommonMethods();

	public List<User> vratiSveUsere() {
		// TODO Auto-generated method stub
		return dao.vratiSveUsere();
	}

	public UserType vratiUserType(String userType) {
		// TODO Auto-generated method stub
		return common.vratiUserType(userType);
	}

	public List<User> vratiUserePoUserTypeu(UserType type) {
		// TODO Auto-generated method stub
		return dao.vratiUserePoUserTypeu(type);
	}
	
}
