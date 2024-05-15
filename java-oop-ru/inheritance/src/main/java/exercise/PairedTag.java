package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
	private String strNameTag;
	private HashMap<String,String> mapAttrsTag;
	private String bodyTag;
	private List<String> childrenTags;
	PairedTag(String inpStrNameTag, HashMap<String,String> inpMapAttrsTag, String inpBodyTag, List<String> inpChildrenTags) {
		strNameTag = inpStrNameTag;
		mapAttrsTag = new HashMap();
		inpMapAttrsTag.forEach(mapAttrsTag::putIfAbsent);
		bodyTag = inpBodyTag;
		childrenTags = inpChildrenTags;
	}
	@Override
	public String toString() {
		int sizeMapAttrTag = mapAttrsTag.size();
		ArrayList<String> listKeys = new ArrayList<String>();
		ArrayList<String> listValues = new ArrayList<String>();
		var entries = mapAttrsTag.entrySet();
		for (var entry : entries) {
			listKeys.add(entry.getKey());
			listValues.add(entry.getValue());
		}
		String strChildTags = childrenTags.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining());
		return "<" + strNameTag + " " + listKeys.get(0) + "=\"" + listValues.get(0) + "\">" + bodyTag + strChildTags + "</" + strTagName + ">"; //+ 
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
