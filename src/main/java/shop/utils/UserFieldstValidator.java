package shop.utils;


public class UserFieldstValidator {
	private static final String LOGIN_REGEXP="[\\p{Alpha}]+[\\p{Alpha}\\d\\p{Punct}]{3,}";
	private static final String PASSWORD_LEN_REGEXP="[\\p{Alpha}\\d\\p{Punct}]{4,}";
	private static final String PASSWORD_LETT_REGEXP=".*\\p{Alpha}.*";
	private static final String PASSWORD_NUM_REGEXP=".*\\d.*";

	private static final String FIRST_NAME_REGEXP="\\p{Alpha}+";
	private static final String LAST_NAME_REGEXP="\\p{Alpha}+";
	private static final String DOB_REGEXP="\\d{1,2}/\\d{1,2}/((19|20)?\\d{2})";
	
	public UserFieldstValidator() {
	}
	
	public boolean isValidLogin(String login) {
		if(login==null){
			return false;
		}
		return login.matches(LOGIN_REGEXP);
	}
	public boolean isValidPassword(String password) {
		if(password==null){
			return false;
		}
		return password.matches(PASSWORD_LEN_REGEXP)&&password.matches(PASSWORD_NUM_REGEXP)&&password.matches(PASSWORD_LETT_REGEXP);
	}
	public boolean isValidFirstName(String firstName) {
		if(firstName==null){
			return false;
		}
		return firstName.matches(FIRST_NAME_REGEXP);
	}
	public boolean isValidLastName(String lastName) {
		if(lastName==null){
			return false;
		}
		return lastName.matches(LAST_NAME_REGEXP);
	}
	public boolean isValidDob(String dob) {
		if(dob==null){
			return false;
		}
		return dob.matches(DOB_REGEXP);
	}
	
}
