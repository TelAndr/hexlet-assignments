package exercise;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

// BEGIN
public class SingleTag extends Tag {
	private String nameTag;
	//private Map<String,String> attrsTag;
	SingleTag(String inpTagName, Map<String,String> inpAttrsTag) { // Hash
		super(inpTagName, inpAttrsTag);
		nameTag = inpTagName;
		//attrsTag = new HashMap<>();
		//inpAttrsTag.forEach(attrsTag::putIfAbsent);
	}
	@Override
	public String toString() {
		//int sizeAttrTag = attrsTag.size();
		ArrayList<String> listKeys = new ArrayList<String>();
		ArrayList<String> listValues = new ArrayList<String>();
		//Set<String> keys = attrsTag.keySet();
		//ArrayList<String> values = new ArrayList<>(attrsTag.values());
		//var entries = attrsTag.entrySet();
		//for (var entry : entries) {
		//	listKeys.add(entry.getKey());
		//	listValues.add(entry.getValue());
		//}
		ArrayList< ArrayList<String> > unionArraysKeyAndValue = buildListKeysAndValues();
		if (unionArraysKeyAndValue.get(0).size() > 1 && unionArraysKeyAndValue.get(1).size() > 1) {
			listKeys = unionArraysKeyAndValue.get(0);
			listValues = unionArraysKeyAndValue.get(1);
			String firstListKey = listKeys.get(0);
			String secondListKey = listKeys.get(1);
			String firstListValue = listValues.get(0);
			String secondListValue = listValues.get(1);
			return "<" + nameTag + " " + secondListKey + "=\""
				+ secondListValue +"\" " + firstListKey + "=\"" + firstListValue + "\">";
			//return stringifyAttributes();
				// Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
		} else if (unionArraysKeyAndValue.get(0).size() == 1 && unionArraysKeyAndValue.get(1).size() == 1) {
			listKeys = unionArraysKeyAndValue.get(0);
			listValues = unionArraysKeyAndValue.get(1);
			String firstListKey = listKeys.get(0);
			String firstListValue = listValues.get(0);
			return "<" + nameTag + " " + firstListKey + "=\"" + firstListValue + "\">";
		} else {
			return "<" + nameTag + ">";
		}
		
	}
}
// END
