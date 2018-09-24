package shop.product.database;

import java.util.HashMap;

import shop.product.pojo.Product;

public class DataBase {

	/**
	 * --����hashmap�����ڴ洢product����
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
	 * -- ��֤��ͬ��client��õ�productDB��ͬһ��DB
	 */
	
	/**
	 * -- ����ʽ����������productDB
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
	 * -- ����ʽ����������productDB
	 */
	static DataBase pdtDB = new DataBase();
	
	public static DataBase getDataBase() {
		
		return pdtDB;
	}
	
}
