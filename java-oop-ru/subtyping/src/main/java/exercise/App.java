package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
import java.util.HashMap;
import java.util.stream.Collectors;
public class App {
	//public static HashMap<String,String> swapKeyValue(HashMap<String,String> curStorageData) {
	public static KeyValueStorage swapKeyValue(KeyValueStorage storage) {
		//var entries = curStorageData.entrySet();
		//for (var entry : entries) {
		//	String extrKey = entry.getKey();
		//	String extrVal = entry.getValue();
		//	entries.remove(extrKey);
		//	entries.put(extrVal, extrKey);
		//}
		//HashMap<String, String> invCurStorageData = curStorageData.inverse();
		Map<String, String> curStorageData = new HashMap<>();
		curStorageData = storage.toMap();
		//Map<String, String> curStorageData = storage.toMap();
		var entries = curStorageData.entrySet();
		for (var entry : entries) {
			storage.unset(entry.getKey());
			storage.set(entry.getValue(), entry.getKey());
			
		}
		//Map<String, String> mapInversed = 
		//	curStorageData.entrySet()
		//		.stream()
		//		.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		//HashMap<String, String> newMap = new HashMap<>();
		//for (Map.Entry<String, String> change : curStorageData.entrySet()) {
        //    newMap.put(change.getValue(), change.getKey());
        //}
		//KeyValueStorage invStorage = new InMemoryKV(mapInversed);
		//KeyValueStorage invStorage = new InMemoryKV(newMap);
		//return invStorage;
		//HashMap<String, String> invCurStorageData = curStorageData.inverse();
		return storage;
	}
}
// END
