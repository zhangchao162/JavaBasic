package shop.user.service;

import shop.user.pojo.User;

public interface UserService {
	/**
	 * -- 检查要注册的账号是否已经存在
	 * @param account
	 * @return
	 * @throws Exception 
	 */
	public boolean checkIfAccountExist(String account) throws Exception;
	
	/**
	 * --添加用户到数据库
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public boolean addUser(User user) throws Exception;
	
	public boolean userLogin(String account, String password) throws Exception;
	
	public boolean updateUserName(String account, String newName) throws Exception;
	
	public boolean updateUserAge(String account, int newAge) throws Exception;
	
	/**
	 * --注销账号
	 * @param account
	 * @return
	 * @throws Exception 
	 */
	public boolean removeUser(String account) throws Exception;
}
