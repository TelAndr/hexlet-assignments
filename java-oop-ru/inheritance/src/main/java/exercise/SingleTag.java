package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
	private String nameTag;
	private HashMap<String,String> attrsTag;
	SingleTag(String inpTagName, HashMap<String,String> inpAttrsTag) {
		nameTag = inpTagName;
		attrsTag = new HashMap();
		inpAttrsTag.forEach(attrsTag::putIfAbsent);
	}
	@Override
	public String toString() {
		int sizeAttrTag = attrsTag.size();
		ArrayList<String> listKeys = new ArrayList<String>();
		ArrayList<String> listValues = new ArrayList<String>();
		Set<String> keys = attrsTag.keySet();
		ArrayList<String> values = new ArrayList<>(attrsTag.values());
		var entries = attrsTag.entrySet();
		for (var entry : entries) {
			listKeys.add(entry.getKey());
			listValues.add(entry.getValue());
		}
		return "<" + nameTag + listKeys.get(0) + "=\""
			+ listValues.get(0) +"\" " + listKeys.get(1) + "=\"" + listValues.get(1) + "\">"; 
			// Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
	}
}
// END
