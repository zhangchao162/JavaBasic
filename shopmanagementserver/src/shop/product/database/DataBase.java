package shop.product.database;

import java.util.HashMap;

import shop.product.pojo.Product;

public class DataBase {

	/**
	 * --创建hashmap，用于存储product数据
	 */
	HashMap<Integer, Product> pdtMap = new HashMap<>();

	public HashMap<Integer, Product> getPdtMap() {
		return pdtMap;
	}

	public void setPdtMap(HashMap<Integer, Product> pdtMap) {
		this.pdtMap = pdtMap;
	}

	private DataBase() {
		super();
	}
	
	/**
	 * -- 保证不同的client获得的productDB是同一个DB
	 */
	
	/**
	 * -- 懒汉式单例，返回productDB
	 */
/*	
	static DataBase pdtDB = null;
	
	public static DataBase getDataBase() {
		if(pdtDB == null) {
			pdtDB = new DataBase();
			return pdtDB;
		}
		return pdtDB;
	}
*/	
	
	/**
	 * -- 饿汉式单例，返回productDB
	 */
	static DataBase pdtDB = new DataBase();
	
	public static DataBase getDataBase() {
		
		return pdtDB;
	}
	
}
