package apaw.p2.sport.exceptions;

public class DuplicateSportNameException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "El deporte ya existe en base de datos";

	public DuplicateSportNameException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public DuplicateSportNameException() {
		this("");
	}
}
