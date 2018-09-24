package shop.product.database;

import java.util.List;

import shop.product.pojo.Product;

public interface databaseService {
	
	// ��ѯ������Ʒ
	public List<Product> getAllProducts() throws Exception;

	// ����������Ʋ�ѯ��Ʒ
	public List<Product> getProductsByCateName(String Category) throws Exception;

	// ���ռ۸�Χ��ѯ��Ʒ
	public List<Product> getProductsByPriceRange(float min, float max) throws Exception;

	// ������ƷID��ѯ��Ʒ
	public Product getProductsById(String pId) throws Exception;

	// �����Ʒ�����ݿ�
	public boolean addProduct(Product product) throws Exception;
	
	// ������Ʒ����
	public boolean updateProduct(Product product) throws Exception;
	
}
