package shop.user.service;

import shop.user.pojo.User;

public interface UserService {
	/**
	 * -- ���Ҫע����˺��Ƿ��Ѿ�����
	 * @param account
	 * @return
	 * @throws Exception 
	 */
	public boolean checkIfAccountExist(String account) throws Exception;
	
	/**
	 * --����û������ݿ�
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public boolean addUser(User user) throws Exception;
	
	public boolean userLogin(String account, String password) throws Exception;
	
	public boolean updateUserName(String account, String newName) throws Exception;
	
	public boolean updateUserAge(String account, int newAge) throws Exception;
	
	/**
	 * --ע���˺�
	 * @param account
	 * @return
	 * @throws Exception 
	 */
	public boolean removeUser(String account) throws Exception;
}
