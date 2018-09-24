package shop.cart.service;

import java.util.List;

import shop.cart.pojo.CartItem;

public interface CartService {
	/**
	 * --��
	 * @throws Exception 
	 */
	public boolean addItemToCart(String userId, String pId, int buyItem) throws Exception;
	
	/**
	 * --ɾ
	 * @throws Exception 
	 */
	public boolean removeItemFromCart(String userId, String pId) throws Exception;
	
	/**
	 *  --��
	 * @throws Exception 
	 */
	public boolean updateItemBuyNum(String userId, String pId, int buyNum) throws Exception;
	
	/**
	 * --��
	 * @throws Exception 
	 */
	public List<CartItem> getAllItems(String userId) throws Exception;
}
