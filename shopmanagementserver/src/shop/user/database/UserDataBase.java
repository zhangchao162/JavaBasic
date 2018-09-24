package shop.user.database;

import java.util.List;

import shop.user.pojo.User;

public interface UserDataBase {
	/**
	 * -- 增 -- 往数据库增加数据
	 * @throws Exception 
	 */
	public boolean addUser(User user) throws Exception;

	/**
	 * -- 移除一个用户
	 * @throws Exception 
	 */
	public boolean removeUser(String account) throws Exception;

	/**
	 * -- 修改用户 -- 要求service层把要修改的用户的所有数据全部返回
	 * @throws Exception 
	 */
	public boolean updateUser(User user) throws Exception;

	/**
	 * --根据用户账号查询用户信息
	 * @throws Exception 
	 */
	public User getUserByAccount(String account) throws Exception;

	/**
	 * --根据年龄查询用户信息
	 * @throws Exception 
	 */
	public List<User> getUserByAgeRange(int maxAge, int minAge) throws Exception;

	/**
	 * --根据vip等级范围查询用户
	 * @throws Exception 
	 */
	public List<User> getUserByVipRange(int minVip, int maxVip) throws Exception;

	/**
	 * --根据姓名查询用户
	 * @throws Exception 
	 */
	public List<User> getUserByName(String name) throws Exception;

}
