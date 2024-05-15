package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{
	private HashMap<String,String> storageData; //= new HashMap<String, String>();
	InMemoryKV(HashMap<String,String> inputStorageData){
		storageData = new HashMap<String, String>();
		storageData = inputStorageData;
	}
	//@Override 
	public void set(String key, String value){ 
		storageData.put(key, value);
	}
	//@Override
	public void unset(String key){
		if (storageData.containsKey(key)) {
			storageData.remove(key);
		}
	}
	//@Override
	public String get(String key, String defaultValue) {
		if (storageData.containsKey(key)) {
			return storageData.get(key);
		}
		else {
			return defaultValue;
		}
			
	}
	//@Override
	public Map<String, String> toMap() {
		return storageData;
	}
}
// END
