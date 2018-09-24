package shop.user.database;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import shop.user.pojo.User;
import shop.utils.Util;

public class UserDataBaseImpl implements UserDataBase {

	Util<User> util = new Util<>();
	Properties props = new Properties();

	@Override
	public boolean addUser(User user) throws Exception {
		HashMap<String, User> userMap = null;
		// ȡ������User���ݿ�
		props.load(UserDataBaseImpl.class.getResourceAsStream("common.properties"));
		File file = new File(props.getProperty("USER_DATA_PATH"));
		if (file.exists()) {
			userMap = util.readMapFromDOC(props.getProperty("USER_DATA_PATH"));
		} else {
			userMap = new HashMap<>();
		}
		// �����û���ӵ�userMap��
		userMap.put(user.getAccount(), user);

		// ������userMap����д���ļ�
		return util.writeMapToDOC(userMap, props.getProperty("USER_DATA_PATH"));
	}

	@Override
	public boolean removeUser(String account) throws Exception {
		// ȡ������User���ݿ�
		HashMap<String, User> userMap = util.readMapFromDOC(props.getProperty("USER_DATA_PATH"));

		// ɾ���û�����
		User remove = userMap.remove(account);
		if (remove == null) {
			return false;
		}

		// ������userMap����д���ļ�
		return util.writeMapToDOC(userMap, props.getProperty("USER_DATA_PATH"));
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		// ȡ������User���ݿ�
		HashMap<String, User> userMap = util.readMapFromDOC(props.getProperty("USER_DATA_PATH"));

		// �����û�����
		userMap.put(user.getAccount(), user);

		// ������userMap����д���ļ�
		return util.writeMapToDOC(userMap, props.getProperty("USER_DATA_PATH"));
	}

	@Override
	public User getUserByAccount(String account) throws Exception {
		HashMap<String, User> userMap = util.readMapFromDOC(props.getProperty("USER_DATA_PATH"));
		return userMap.get(account);
	}

	@Override
	public List<User> getUserByAgeRange(int maxAge, int minAge) throws Exception {
		ArrayList<User> uList = new ArrayList<>();
		HashMap<String, User> userMap = util.readMapFromDOC(props.getProperty("USER_DATA_PATH"));
		Collection<User> user = userMap.values();
		for (User u : user) {
			if (u.getAge() <= maxAge && u.getAge() >= minAge) {
				uList.add(u);
			}
		}
		return uList;
	}

	@Override
	public List<User> getUserByVipRange(int minVip, int maxVip) throws Exception {
		ArrayList<User> uList = new ArrayList<>();
		HashMap<String, User> userMap = util.readMapFromDOC(props.getProperty("USER_DATA_PATH"));
		Collection<User> user = userMap.values();
		for (User u : user) {
			if (u.getVipLevel() >= minVip && u.getVipLevel() <= maxVip) {
				uList.add(u);
			}
		}

		return uList;
	}

	@Override
	public List<User> getUserByName(String name) throws Exception {
		ArrayList<User> uList = new ArrayList<>();
		HashMap<String, User> userMap = util.readMapFromDOC(props.getProperty("USER_DATA_PATH"));
		Collection<User> user = userMap.values();
		for (User u : user) {
			if (u.getName().contains(name)) {
				uList.add(u);
			}
		}
		return uList;
	}

}
