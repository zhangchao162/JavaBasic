package shop.cart.service;

import java.util.List;

import shop.cart.database.CartDatabase;
import shop.cart.database.CartDatabeaseImpl;
import shop.cart.pojo.CartItem;
import shop.product.database.databaseService;
import shop.product.database.databaseServiceImpl;
import shop.product.pojo.Product;

public class CartServiceImpl implements CartService{
	CartDatabase cartdatabase = new CartDatabeaseImpl();
	databaseService database = new databaseServiceImpl();
	@Override
	public boolean addItemToCart(String userId, String pId, int buyItem) throws Exception {
		boolean addItemToCart;
		
		// 先判断购物车数据中有该用户
		boolean checkIfUserExist = cartdatabase.checkIfUserExist(userId);
		
		if(checkIfUserExist) {
			// 判断该商品是否存在与购物车中
			boolean checkIfItemExist = cartdatabase.checkIfItemExist(userId, pId);
			if(checkIfItemExist) {
				
				CartItem item = cartdatabase.getItemById(userId, pId);
				
				addItemToCart = cartdatabase.updateItemBuyNum(userId, pId, buyItem + item.getBuyNum());
				
			}else {
				// 先根据pId从商品管理模块的dao中获取商品信息
				Product productsById = database.getProductsById(pId);
				CartItem item = new CartItem();
				item.set(pId, productsById.getpName(), productsById.getPrice(), buyItem);
				
				// 再利用购物车dao将这个购物项目添加到用户已经有的购物车数据表中
				addItemToCart = cartdatabase.addItemToCart(userId, item);
			}
			
		}else {
			// 先根据pId从商品管理模块的dao中获取商品信息
			Product productsById = database.getProductsById(pId);
			CartItem item = new CartItem();
			item.set(pId, productsById.getpName(), productsById.getPrice(), buyItem);
			
			// 再利用购物车dao将这个购物项目添加到新的购物车数据表中
			addItemToCart = cartdatabase.addNewUserItemToCart(userId, item);
		}
				
		return addItemToCart;
	}

	@Override
	public boolean removeItemFromCart(String userId, String pId) throws Exception {
		return cartdatabase.removeItemFromCart(userId, pId);
	}

	@Override
	public boolean updateItemBuyNum(String userId, String pId, int buyNum) throws Exception {
		return cartdatabase.updateItemBuyNum(userId, pId, buyNum);
	}

	@Override
	public List<CartItem> getAllItems(String userId) throws Exception {
		return cartdatabase.getAllItemsFromCart(userId);
	}

}
