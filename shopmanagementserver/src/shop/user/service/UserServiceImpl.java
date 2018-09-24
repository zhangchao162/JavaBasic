package shop.user.service;

import shop.user.database.UserDataBase;
import shop.user.database.UserDataBaseImpl;
import shop.user.pojo.User;

public class UserServiceImpl implements UserService{
	
	UserDataBase userdatabase = new UserDataBaseImpl();
	
	@Override
	public boolean checkIfAccountExist(String account) throws Exception {
		User user = userdatabase.getUserByAccount(account);
		return user!=null;
	}

	@Override
	public boolean addUser(User user) throws Exception {
		return userdatabase.addUser(user);
	}

	@Override
	public boolean userLogin(String account, String password) throws Exception {
		User user = userdatabase.getUserByAccount(account);
		if(user != null) {
			return user.getPasswd().equals(password);
		}else {
			return false;
		}
	}

	@Override
	public boolean updateUserName(String account, String newName) throws Exception {
		User user = userdatabase.getUserByAccount(account);
		if(user==null) {
			return false;
		}
		user.setName(newName);
		
		userdatabase.updateUser(user);
		return true;
	}

	@Override
	public boolean updateUserAge(String account, int newAge) throws Exception {
		User user = userdatabase.getUserByAccount(account);
		if(user==null) {
			return false;
		}
		user.setAge(newAge);
		
		userdatabase.updateUser(user);
		return true;
	}

	@Override
	public boolean removeUser(String account) throws Exception {
		return userdatabase.removeUser(account);
	}

}
