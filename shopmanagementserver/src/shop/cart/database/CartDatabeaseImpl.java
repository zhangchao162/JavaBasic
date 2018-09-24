package shop.cart.database;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import shop.cart.pojo.CartItem;
import shop.product.database.databaseServiceImpl;
import shop.utils.Util;

public class CartDatabeaseImpl implements CartDatabase{
	
	Util<HashMap<String, CartItem>> util = new Util<>();
	Properties props = new Properties();
	
	@Override
	public boolean addItemToCart(String userId, CartItem item) throws Exception {
		HashMap<String, CartItem> itemMap = new HashMap<>();
		props.load(databaseServiceImpl.class.getResourceAsStream("common.properties"));
		HashMap<String, HashMap<String, CartItem>> cartMap = util.readMapFromDOC(props.getProperty("CART_DATA_PATH"));
		itemMap.put(item.getpId(), item);
		cartMap.put(userId, itemMap);
		return util.writeMapToDOC(cartMap, props.getProperty("CART_DATA_PATH"));
	}

	@Override
	public boolean addNewUserItemToCart(String userId, CartItem item) throws Exception {
		HashMap<String, HashMap<String, CartItem>> cartMap = null;
		File file = new File(props.getProperty("CART_DATA_PATH"));
		if (file.exists()) {
			// 如果文件存在，则加载
			cartMap = util.readMapFromDOC(props.getProperty("CART_DATA_PATH"));
		} else {
			// 如果文件不存在，则构造一个购物车的hashmap
			cartMap = new HashMap<String, HashMap<String, CartItem>>();
		}
		HashMap<String,CartItem> userItems = new HashMap<>();
		userItems.put(item.getpId(), item);
		cartMap.put(userId, userItems);
		
		return util.writeMapToDOC(cartMap, props.getProperty("CART_DATA_PATH"));
	}

	@Override
	public boolean removeItemFromCart(String userId, String pId) throws Exception {
		HashMap<String, HashMap<String, CartItem>> cartMap = util.readMapFromDOC(props.getProperty("CART_DATA_PATH"));
		HashMap<String, CartItem> items = cartMap.get(userId);
		items.remove(pId);
		
		return util.writeMapToDOC(cartMap, props.getProperty("CART_DATA_PATH"));
	}

	@Override
	public boolean updateItemBuyNum(String userId, String pId, int buyNum) throws Exception {
		HashMap<String, HashMap<String, CartItem>> cartMap = util.readMapFromDOC(props.getProperty("CART_DATA_PATH"));
		cartMap.get(userId).get(pId).setBuyNum(buyNum);
		
		return util.writeMapToDOC(cartMap, props.getProperty("CART_DATA_PATH"));
	}

	@Override
	public List<CartItem> getAllItemsFromCart(String userId) throws Exception {
		ArrayList<CartItem> pList = new ArrayList<>();
		HashMap<String, HashMap<String, CartItem>> cartMap = util.readMapFromDOC(props.getProperty("CART_DATA_PATH"));
		HashMap<String, CartItem> userMap = cartMap.get(userId);
		Collection<CartItem> items = userMap.values();
		for (CartItem cartItem : items) {
			pList.add(cartItem);
		}
		return pList;
	}

	@Override
	public boolean checkIfUserExist(String userId) throws Exception {
		HashMap<String, HashMap<String, CartItem>> cartMap = util.readMapFromDOC(props.getProperty("CART_DATA_PATH"));
		if(cartMap.containsKey(userId)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean checkIfItemExist(String userId, String pId) throws Exception {
		HashMap<String, HashMap<String, CartItem>> cartMap = util.readMapFromDOC(props.getProperty("CART_DATA_PATH"));
		HashMap<String, CartItem> userItems = cartMap.get(userId);
		if(userItems.containsKey(pId)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public CartItem getItemById(String userId, String pId) throws Exception {
		HashMap<String, HashMap<String, CartItem>> cartMap = util.readMapFromDOC(props.getProperty("CART_DATA_PATH"));
		HashMap<String, CartItem> userItems = cartMap.get(userId);
		CartItem cartItem = userItems.get(pId);
		return cartItem;
	}

}
