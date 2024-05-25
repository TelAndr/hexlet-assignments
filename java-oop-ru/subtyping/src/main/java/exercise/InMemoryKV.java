package exercise;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{
	private Map<String,String> storageData; //= new HashMap<String, String>();
	InMemoryKV(Map<String,String> inputStorageData){
		storageData = new LinkedHashMap<>(); //<String, String>();
		//storageData = inputStorageData;
		inputStorageData.forEach(storageData::putIfAbsent);
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
