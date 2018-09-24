package shop.product.database;

import java.util.List;

import shop.product.pojo.Product;

public interface databaseService {
	
	// 查询所有商品
	public List<Product> getAllProducts() throws Exception;

	// 按照类别名称查询商品
	public List<Product> getProductsByCateName(String Category) throws Exception;

	// 按照价格范围查询商品
	public List<Product> getProductsByPriceRange(float min, float max) throws Exception;

	// 根据商品ID查询商品
	public Product getProductsById(String pId) throws Exception;

	// 添加商品到数据库
	public boolean addProduct(Product product) throws Exception;
	
	// 更新商品数据
	public boolean updateProduct(Product product) throws Exception;
	
}
