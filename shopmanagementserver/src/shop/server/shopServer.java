package shop.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class shopServer {
	
	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(9999);
		
		boolean flag = true;
		
		while(flag) {
			Socket sc = ss.accept();
			/**
			 *  -- 接收请求
			 */
			InputStream in = sc.getInputStream();
			byte[] b = new byte[1024];
			int num = in.read(b);
			String str = new String(b, 0, num);
			System.out.println("Receive a request:" + str);
			
			/**
			 *  -- 反馈请求
			 */
			OutputStream out = sc.getOutputStream();
			out.write("Connection Succeeded!".getBytes());
			
			out.close();
			in.close();
			sc.close();
		}
		
		
	}
	
}
