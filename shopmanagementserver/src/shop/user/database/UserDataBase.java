package shop.user.database;

import java.util.List;

import shop.user.pojo.User;

public interface UserDataBase {
	/**
	 * -- �� -- �����ݿ���������
	 * @throws Exception 
	 */
	public boolean addUser(User user) throws Exception;

	/**
	 * -- �Ƴ�һ���û�
	 * @throws Exception 
	 */
	public boolean removeUser(String account) throws Exception;

	/**
	 * -- �޸��û� -- Ҫ��service���Ҫ�޸ĵ��û�����������ȫ������
	 * @throws Exception 
	 */
	public boolean updateUser(User user) throws Exception;

	/**
	 * --�����û��˺Ų�ѯ�û���Ϣ
	 * @throws Exception 
	 */
	public User getUserByAccount(String account) throws Exception;

	/**
	 * --���������ѯ�û���Ϣ
	 * @throws Exception 
	 */
	public List<User> getUserByAgeRange(int maxAge, int minAge) throws Exception;

	/**
	 * --����vip�ȼ���Χ��ѯ�û�
	 * @throws Exception 
	 */
	public List<User> getUserByVipRange(int minVip, int maxVip) throws Exception;

	/**
	 * --����������ѯ�û�
	 * @throws Exception 
	 */
	public List<User> getUserByName(String name) throws Exception;

}
