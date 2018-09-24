package shop.product.service;

import java.util.List;

import shop.product.pojo.Product;

public interface ProductService {
	// 查询所有商品
	public List<Product> getAllProducts() throws Exception;

	// 按照类别名称查询商品
	public List<Product> getProductsByCateName(String Category) throws Exception;

	// 按照价格范围查询商品
	public List<Product> getProductsByPriceRange(float min, float max) throws Exception;

	// 根据商品ID查询商品
	public Product getProductsById(String pId) throws Exception;

	// 根据商品字符串信息添加商品到数据库
	public boolean addProduct(String productInfoString) throws Exception;

	// 修改商品名称
	public boolean updateProductName(String pId, String pName) throws Exception;

	// 修改商品价格
	public boolean updateProductPrice(String pId, float price) throws Exception;

	// 修改商品库存数
	public boolean updateProductStock(String pId, int stockNum) throws Exception;

	// 修改商品状态 status状态值约定  0：下架；1：上架；2：已被删除
	public boolean updateProductStatus(String pId, String status) throws Exception;
}
