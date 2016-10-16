package apaw.p2.sport.exceptions;

public class SportNotFoundException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "El deporte no existe";

	public SportNotFoundException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public SportNotFoundException() {
		this("");
	}
}
