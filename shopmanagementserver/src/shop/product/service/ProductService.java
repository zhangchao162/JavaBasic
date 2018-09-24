package shop.product.service;

import java.util.List;

import shop.product.pojo.Product;

public interface ProductService {
	// ��ѯ������Ʒ
	public List<Product> getAllProducts() throws Exception;

	// ����������Ʋ�ѯ��Ʒ
	public List<Product> getProductsByCateName(String Category) throws Exception;

	// ���ռ۸�Χ��ѯ��Ʒ
	public List<Product> getProductsByPriceRange(float min, float max) throws Exception;

	// ������ƷID��ѯ��Ʒ
	public Product getProductsById(String pId) throws Exception;

	// ������Ʒ�ַ�����Ϣ�����Ʒ�����ݿ�
	public boolean addProduct(String productInfoString) throws Exception;

	// �޸���Ʒ����
	public boolean updateProductName(String pId, String pName) throws Exception;

	// �޸���Ʒ�۸�
	public boolean updateProductPrice(String pId, float price) throws Exception;

	// �޸���Ʒ�����
	public boolean updateProductStock(String pId, int stockNum) throws Exception;

	// �޸���Ʒ״̬ status״ֵ̬Լ��  0���¼ܣ�1���ϼܣ�2���ѱ�ɾ��
	public boolean updateProductStatus(String pId, String status) throws Exception;
}
