package exercise;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

// BEGIN
public class PairedTag extends Tag {
	private String strNameTag;
	private Map<String,String> mapAttrsTag; // Hash
	private String bodyTag;
	private List<Tag> childrenTags; // List
	PairedTag(String inpStrNameTag, Map<String,String> inpMapAttrsTag, String inpBodyTag, List<Tag> inpChildrenTags) { // Hash // List
		super(inpStrNameTag, inpMapAttrsTag);
		mapAttrsTag = new LinkedHashMap<>();
		inpMapAttrsTag.forEach(mapAttrsTag::putIfAbsent);
		strNameTag = inpStrNameTag;
		bodyTag = inpBodyTag;
		childrenTags = inpChildrenTags;
	}
	@Override
	public String toString() {
		int sizeMapAttrTag = mapAttrsTag.size();
		int countMapTag;
		String outTagString = new String();
		ArrayList<String> listKeys = new ArrayList<String>();
		ArrayList<String> listValues = new ArrayList<String>();
		var entries = mapAttrsTag.entrySet();
		countMapTag = 0;
		for (var entry : entries) {
			listKeys.add(entry.getKey());
			listValues.add(entry.getValue());
			if (countMapTag == sizeMapAttrTag - 1) {
				outTagString += entry.getKey() + "=\"" + entry.getValue() + "\"";
			} else {
				outTagString += entry.getKey() + "=\"" + entry.getValue() + "\" ";
			}
			++countMapTag;
		}
		//if (sizeMapAttrTag == 0) {
		//	outTagString = "";
		//}
		String strChildTags = childrenTags.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining());
		
		//return "<" + strNameTag + " " + listKeys.get(0) + "=\"" + listValues.get(0) + "\">" + bodyTag + strChildTags + "</" + strNameTag + ">"; 
		//if (outTagString.length() == 0) {
		//	return "<" + strNameTag + ">";
		//} else {
			if (sizeMapAttrTag == 0) {
				return "<" + strNameTag + outTagString + ">" + bodyTag + strChildTags + "</" + strNameTag + ">";
			} else {
				return "<" + strNameTag + " " + outTagString + ">" + bodyTag + strChildTags + "</" + strNameTag + ">";
			}
		//}
	}
	//Tag p = new PairedTag(
    //"p",
    //Map.of("id", "abc"),
    //"Text paragraph",
    //new ArrayList<Tag>()
	//);

	//p.toString(); // <p id="abc">Text paragraph</p>
}
// END
