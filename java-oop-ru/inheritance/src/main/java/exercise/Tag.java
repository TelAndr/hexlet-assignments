package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
	private String nameTag;
	private HashMap<String,String> attrsTag;
	Tag(String inpTagName, HashMap<String,String> inpAttrsTag) {
		nameTag = inpTagName;
		attrsTag = new HashMap();
		inpAttrsTag.forEach(attrsTag::putIfAbsent);
	}
	public String stringifyAttributes() {
        return attributes.keySet().stream()
            .map(key -> {
                String value = attributes.get(key);
                return String.format(" %s=\"%s\"", key, value);
            })
            .collect(Collectors.joining(""));
    }
	public ArrayList< ArrayList<String> > buildListKeysAndValues() {
		ArrayList<String> listKeys = new ArrayList<String>();
		ArrayList<String> listValues = new ArrayList<String>();
		Set<String> keys = attrsTag.keySet();
		ArrayList<String> values = new ArrayList<>(attrsTag.values());
		var entries = attrsTag.entrySet();
		for (var entry : entries) {
			listKeys.add(entry.getKey());
			listValues.add(entry.getValue());
		}
		ArrayList< ArrayList<String> > unionArraysKeyAndValue
            = new ArrayList<ArrayList<String> >();
		unionArraysKeyAndValue.add(listKeys);
		unionArraysKeyAndValue.add(listValues);
		return unionArraysKeyAndValue;
	}
	public String toString();
}
// END
