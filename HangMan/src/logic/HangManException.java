package logic;

public class HangManException extends Exception {

	public HangManException() {
	}

	public HangManException(String message) {
		super(message);
	}

	public HangManException(Throwable cause) {
		super(cause);
	}

	public HangManException(String message, Throwable cause) {
		super(message, cause);
	}

	public HangManException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
