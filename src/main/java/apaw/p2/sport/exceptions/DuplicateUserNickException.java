package apaw.p2.sport.exceptions;

public class DuplicateUserNickException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "El usuario ya existe en base de datos";

	public DuplicateUserNickException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public DuplicateUserNickException() {
		this("");
	}
}
