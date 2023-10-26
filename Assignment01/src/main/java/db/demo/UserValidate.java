package db.demo;

public class UserValidate {
	public boolean isValidUser(String user,String password)
	{
		if(user.equals("tester")&&password.equals("tester"))
			return true;
		else
			return false;
		
	}

}
