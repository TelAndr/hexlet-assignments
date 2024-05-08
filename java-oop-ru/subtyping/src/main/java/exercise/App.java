package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
	public static HashMap<String,String> swapKeyValue(HashMap<String,String> curStorageData) {
		var entries = curStorageData.entrySet();
		for (var entry : entries) {
			String extrKey = entry.getKey();
			String extrVal = entry.getValue();
			entries.remove(extrKey);
			entries.put(extrVal, extrKey);
		}
		//HashMap<String, String> invCurStorageData = curStorageData.inverse();
	}
}
// END
