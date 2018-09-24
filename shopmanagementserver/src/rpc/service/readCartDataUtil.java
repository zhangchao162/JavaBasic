package rpc.service;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.util.List;

import shop.cart.pojo.CartItem;
import shop.cart.service.CartService;
import shop.cart.service.CartServiceImpl;

public class readCartDataUtil {
	
	public CartService cartServiceInstance() {
		CartService cartServiceInstance = (CartService)Proxy.newProxyInstance(CartService.class.getClassLoader(), 
				new Class<?>[] {CartService.class}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {

						String name = arg1.getName();
						if(name.equals("addItemToCart")) {
							
							Socket sc = new Socket("222.18.157.194", 9999);
							OutputStream outputStream = sc.getOutputStream();
							InputStream inputStream = sc.getInputStream();
							
							outputStream.write("CartService_addItemToCart".getBytes());
							
							byte[] b = new byte[1024];
							int num = inputStream.read(b);
							String string = new String(b, 0, num);
							String[] split = string.split(",");
							CartService cartService = new CartServiceImpl();
							
							boolean addItemToCart = cartService.addItemToCart(split[0], split[1], Integer.parseInt(split[2]));
							
							inputStream.close();
							outputStream.close();
							sc.close();
							
							return addItemToCart;
												
						}
						if(name.equals("removeItemFromCart")) {
							
							Socket sc = new Socket("222.18.157.194", 9999);
							OutputStream outputStream = sc.getOutputStream();
							InputStream inputStream = sc.getInputStream();
							
							outputStream.write("CartService_removeItemFromCart".getBytes());
							
							byte[] b = new byte[1024];
							int num = inputStream.read(b);
							String string = new String(b, 0, num);
							String[] split = string.split(",");
							CartService cartService = new CartServiceImpl();
							
							boolean removeItemFromCart = cartService.removeItemFromCart(split[0], split[1]);
							
							inputStream.close();
							outputStream.close();
							sc.close();
							
							return removeItemFromCart;
						}
						if(name.equals("updateItemBuyNum")) {
							
							Socket sc = new Socket("222.18.157.194", 9999);
							OutputStream outputStream = sc.getOutputStream();
							InputStream inputStream = sc.getInputStream();
							
							outputStream.write("CartService_updateItemBuyNum".getBytes());
							
							byte[] b = new byte[1024];
							int num = inputStream.read(b);
							String string = new String(b, 0, num);
							String[] split = string.split(",");
							CartService cartService = new CartServiceImpl();
							
							boolean updateItemBuyNum = cartService.updateItemBuyNum(split[0], split[1], Integer.parseInt(split[2]));
							
							inputStream.close();
							outputStream.close();
							sc.close();
							
							return updateItemBuyNum;
							
						}else {
							
							Socket sc = new Socket("222.18.157.194", 9999);
							OutputStream outputStream = sc.getOutputStream();
							InputStream inputStream = sc.getInputStream();
							
							outputStream.write("CartService_getAllItems".getBytes());
							
							ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
							@SuppressWarnings("unchecked")
							List<CartItem> pList = (List<CartItem>) objectInputStream.readObject();
														
							objectInputStream.close();
							inputStream.close();
							outputStream.close();
							sc.close();
							
							return pList;
						}
					}
				});
		
		return cartServiceInstance;
	}
	
}
