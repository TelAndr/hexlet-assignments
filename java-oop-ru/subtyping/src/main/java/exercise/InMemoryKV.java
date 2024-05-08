package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV {
	private HashMap<String,String> storageData; //= new HashMap<String, String>();
	InMemoryKV(HashMap<String,String> inputStorageData){
		storageData = new HashMap<String, String>();
		storageData = inputStorageData;
	}
	@Override
	void set(String key, String value){
		storageData.put(key, value);
	}
	void unset(String key){
		if (storageData.containsKey(key)) {
			storageData.remove(key);
		}
	}
}
// END
