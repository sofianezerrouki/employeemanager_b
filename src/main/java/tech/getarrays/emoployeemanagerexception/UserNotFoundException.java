package tech.getarrays.emoployeemanagerexception;

public class UserNotFoundException extends RuntimeException  {

	public UserNotFoundException(String msg) {
		super(msg);
	}
}
