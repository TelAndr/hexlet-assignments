package exercise;

// BEGIN
public class InputTag implements TagInterface {
	private String type;
	private String input;
	InputTag(String type, String value) {
		this.type = type;
		this.input = value;
	}
	@Override
	public String render() {
		return "<input type=\"" + type + "\" value=\"" + input + "\">";
	}
}
// END
