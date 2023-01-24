package example.bean;

public class UserValidation {
	
	public static boolean isValid(User ongoingUser) {
		
		boolean valid=false;
		
		String uName=ongoingUser.getUsername();
		String pd=ongoingUser.getPassword();
		
		if(uName.equals("deva")&&pd.equals("yani"))
		valid=true;
		
		return valid ;
	}

}
