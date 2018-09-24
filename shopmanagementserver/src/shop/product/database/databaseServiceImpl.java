package shop.product.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import shop.product.pojo.Product;
import shop.utils.Util;

public class databaseServiceImpl implements databaseService{
	
	Util<Product> util = new Util<>();
	Properties props = new Properties();
	
	@Override
	public List<Product> getAllProducts() throws Exception {
		
		// º”‘ÿ ˝æ›
		props.load(databaseServiceImpl.class.getResourceAsStream("common.properties"));
		HashMap<String,Product> pMap = util.readMapFromDOC(props.getProperty("PRODUCT_DATA_BASE_PATH"));
		Collection<Product> pdts = pMap.values();
		ArrayList<Product> pList = new ArrayList<>();
		for (Product p : pdts) {
			pList.add(p);
		}
		
		return pList;
	}

	@Override
	public List<Product> getProductsByCateName(String Category) throws Exception {
		
		props.load(databaseServiceImpl.class.getResourceAsStream("common.properties"));
		HashMap<String,Product> pMap = util.readMapFromDOC(props.getProperty("PRODUCT_DATA_BASE_PATH"));
		Collection<Product> pdts = pMap.values();
		ArrayList<Product> pList = new ArrayList<>();
		
		for (Product p : pdts) {
			if(p.getpCategory().contains(Category)) {
				pList.add(p);
			}
		}
		return pList;
	}

	@Override
	public List<Product> getProductsByPriceRange(float min, float max) throws Exception {
		
		props.load(databaseServiceImpl.class.getResourceAsStream("common.properties"));
		HashMap<String, Product> pMap = util.readMapFromDOC(props.getProperty("PRODUCT_DATA_BASE_PATH"));
		Collection<Product> pdts = pMap.values();
		ArrayList<Product> pList = new ArrayList<>();
		
		for (Product p : pdts) {
			if(p.getPrice() > min && p.getPrice() < max) {
				pList.add(p);
			}	
		}
		return pList;
	}

	@Override
	public Product getProductsById(String pId) throws Exception {
		props.load(databaseServiceImpl.class.getResourceAsStream("common.properties"));
		HashMap<String, Product> pMap = util.readMapFromDOC(props.getProperty("PRODUCT_DATA_BASE_PATH"));
		
		return pMap.get(pId);
	}

	@Override
	public boolean addProduct(Product product) throws Exception {
		props.load(databaseServiceImpl.class.getResourceAsStream("common.properties"));
		HashMap<String, Product> pMap = util.readMapFromDOC(props.getProperty("PRODUCT_DATA_BASE_PATH"));
		
		pMap.put(product.getpId(), product);
		
		util.writeMapToDOC(pMap, props.getProperty("PRODUCT_DATA_BASE_PATH"));
		
		return true;
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
		props.load(databaseServiceImpl.class.getResourceAsStream("common.properties"));
		HashMap<String, Product> pMap = util.readMapFromDOC(props.getProperty("PRODUCT_DATA_BASE_PATH"));
		
		pMap.put(product.getpId(), product);
		
		util.writeMapToDOC(pMap, props.getProperty("PRODUCT_DATA_BASE_PATH"));
		
		return true;
	}

}
