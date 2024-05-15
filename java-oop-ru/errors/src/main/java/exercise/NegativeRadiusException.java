package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private static final String EXCEPTION_DESCRIPTION_FORMAT = "[%s]: %s";
    private String errorCode;

	public NegativeRadiusException(String message) {
        super(message);
	}
    
	public NegativeRadiusException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return String.format(EXCEPTION_DESCRIPTION_FORMAT, this.errorCode, this.getMessage());
    }
}
// END
