package exercise;

// BEGIN
public class LabelTag implements TagInterface {
	private String strTag;
	private TagInterface objTagInterface;
	public LabelTag(String inpStrTag, TagInterface inpObjTagInterface) {
		strTag = inpStrTag;
		objTagInterface = inpObjTagInterface;
	}
	@Override
	public String render() {
		return "<label>" + strTag + objTagInterface.render() + "</label>";
	}
}
// END
