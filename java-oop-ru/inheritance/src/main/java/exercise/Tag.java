package exercise;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

// BEGIN
public class Tag {
	private String nameTag;
	private Map<String,String> attrsTag; // Hash
	Tag(String inpTagName, Map<String,String> inpAttrsTag) { // Hash
		nameTag = inpTagName;
		attrsTag = new HashMap<>();
		inpAttrsTag.forEach(attrsTag::putIfAbsent);
	}
	public String stringifyAttributes() {
        return attrsTag.keySet().stream() // attributes
            .map(key -> {
                String value = attrsTag.get(key); // attributes
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
	public String toString() {return stringifyAttributes();};
}
// END
