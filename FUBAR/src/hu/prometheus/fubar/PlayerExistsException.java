package hu.prometheus.fubar;

public class PlayerExistsException extends Exception {
	
	String message;
	
	public PlayerExistsException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	

}
