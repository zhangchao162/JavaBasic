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
		
		// ���жϹ��ﳵ�������и��û�
		boolean checkIfUserExist = cartdatabase.checkIfUserExist(userId);
		
		if(checkIfUserExist) {
			// �жϸ���Ʒ�Ƿ�����빺�ﳵ��
			boolean checkIfItemExist = cartdatabase.checkIfItemExist(userId, pId);
			if(checkIfItemExist) {
				
				CartItem item = cartdatabase.getItemById(userId, pId);
				
				addItemToCart = cartdatabase.updateItemBuyNum(userId, pId, buyItem + item.getBuyNum());
				
			}else {
				// �ȸ���pId����Ʒ����ģ���dao�л�ȡ��Ʒ��Ϣ
				Product productsById = database.getProductsById(pId);
				CartItem item = new CartItem();
				item.set(pId, productsById.getpName(), productsById.getPrice(), buyItem);
				
				// �����ù��ﳵdao�����������Ŀ��ӵ��û��Ѿ��еĹ��ﳵ���ݱ���
				addItemToCart = cartdatabase.addItemToCart(userId, item);
			}
			
		}else {
			// �ȸ���pId����Ʒ����ģ���dao�л�ȡ��Ʒ��Ϣ
			Product productsById = database.getProductsById(pId);
			CartItem item = new CartItem();
			item.set(pId, productsById.getpName(), productsById.getPrice(), buyItem);
			
			// �����ù��ﳵdao�����������Ŀ��ӵ��µĹ��ﳵ���ݱ���
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
