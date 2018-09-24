package shop.cart.database;

import java.util.List;

import shop.cart.pojo.CartItem;

public interface CartDatabase {
	public boolean addItemToCart(String userId, CartItem item) throws Exception;
	
	public boolean addNewUserItemToCart(String userId, CartItem item) throws Exception;

	public boolean removeItemFromCart(String userId, String pId) throws Exception;

	public boolean updateItemBuyNum(String userId, String pId, int buyNum) throws Exception;

	public List<CartItem> getAllItemsFromCart(String userId) throws Exception;
	
	// �ж����ݿ����Ƿ���ĳ�˵Ĺ��ﳵ
	public boolean checkIfUserExist(String userId) throws Exception;
	
	// �ж�ĳ�˵Ĺ��ﳵ��ָ������Ʒ
	public boolean checkIfItemExist(String userId, String pId) throws Exception;

	// ����ָ����id�ӹ��ﳵ��ȡ��������
	public CartItem getItemById(String userId, String pId) throws Exception;
}
