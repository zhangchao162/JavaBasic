package shop.product.service;

import java.util.List;

import shop.product.database.databaseService;
import shop.product.database.databaseServiceImpl;
import shop.product.pojo.Product;

public class ProductServiceImpl implements ProductService{

	databaseService database = new databaseServiceImpl();
	
	@Override
	public List<Product> getAllProducts() throws Exception {
		return database.getAllProducts();
	}

	@Override
	public List<Product> getProductsByCateName(String Category) throws Exception {
		return database.getProductsByCateName(Category);
	}

	@Override
	public List<Product> getProductsByPriceRange(float min, float max) throws Exception {
		return database.getProductsByPriceRange(min, max);
	}

	@Override
	public Product getProductsById(String pId) throws Exception {
		return database.getProductsById(pId);
	}

	@Override
	public boolean addProduct(String productInfoString) throws Exception {
		
		String[] strings = productInfoString.split(",");
		Product product = new Product(strings[0], strings[1],Float.parseFloat(strings[2]), strings[3], Integer.parseInt(strings[4]), strings[5]);
		
		return database.addProduct(product);
	}

	@Override
	public boolean updateProductName(String pId, String pName) throws Exception {
		Product product = database.getProductsById(pId);
		product.setpName(pName);
		
		return database.updateProduct(product);
	}

	@Override
	public boolean updateProductPrice(String pId, float price) throws Exception {
		Product product = database.getProductsById(pId);
		product.setPrice(price);
		return database.updateProduct(product);
	}

	@Override
	public boolean updateProductStock(String pId, int stockNum) throws Exception {
		Product product = database.getProductsById(pId);
		product.setStockNum(stockNum);
		return database.updateProduct(product);
	}

	@Override
	public boolean updateProductStatus(String pId, String status) throws Exception {
		Product product = database.getProductsById(pId);
		product.setStatus(status);
		return database.updateProduct(product);
	}

}
