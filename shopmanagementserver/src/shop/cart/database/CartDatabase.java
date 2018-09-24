package shop.cart.database;

import java.util.List;

import shop.cart.pojo.CartItem;

public interface CartDatabase {
	public boolean addItemToCart(String userId, CartItem item) throws Exception;
	
	public boolean addNewUserItemToCart(String userId, CartItem item) throws Exception;

	public boolean removeItemFromCart(String userId, String pId) throws Exception;

	public boolean updateItemBuyNum(String userId, String pId, int buyNum) throws Exception;

	public List<CartItem> getAllItemsFromCart(String userId) throws Exception;
	
	// 判断数据库中是否有某人的购物车
	public boolean checkIfUserExist(String userId) throws Exception;
	
	// 判断某人的购物车有指定的商品
	public boolean checkIfItemExist(String userId, String pId) throws Exception;

	// 根据指定的id从购物车中取出购物项
	public CartItem getItemById(String userId, String pId) throws Exception;
}
