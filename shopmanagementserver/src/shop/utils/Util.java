package shop.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


public class Util<T> {
	
	public HashMap<String, T> readMapFromDOC(String dataPath) throws Exception {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataPath));
		@SuppressWarnings("unchecked")
		HashMap<String, T> pMap = (HashMap<String, T>) ois.readObject();
		ois.close();

		return pMap;
	}
	
	public boolean writeMapToDOC(HashMap<String, T> pMap, String dataPath) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataPath));
		oos.writeObject(pMap);
		oos.close();

		return true;
	}
}
