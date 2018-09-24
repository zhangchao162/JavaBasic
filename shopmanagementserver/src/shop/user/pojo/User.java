package shop.user.pojo;

import java.io.Serializable;

public class User implements Serializable{
	// 用户账号
	private String account;
	// 用户密码
	private String passwd;
	// 用户姓名
	private String name;
	// 用户年龄
	private int age;
	// 用户VIP等级
	private int vipLevel;
	// 用户电话号码
	private String phone;
	// 用户地址
	private String addr;

	public User(String account, String passwd, String name, int age, int vipLevel, String phone, String addr) {
		super();
		this.account = account;
		this.passwd = passwd;
		this.name = name;
		this.age = age;
		this.vipLevel = vipLevel;
		this.phone = phone;
		this.addr = addr;
	}

	public User() {

	}
	
	public void set(String account, String passwd, String name, int age, int vipLevel, String phone, String addr) {

		this.account = account;
		this.passwd = passwd;
		this.name = name;
		this.age = age;
		this.vipLevel = vipLevel;
		this.phone = phone;
		this.addr = addr;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", passwd=" + passwd + ", name=" + name + ", age=" + age + ", vipLevel="
				+ vipLevel + ", phone=" + phone + ", addr=" + addr + "]";
	}
}
