package utilities;

import com.github.javafaker.Faker;

public class DataUtil {
	
	private Faker fake;

	public static DataUtil getData() {
		return new DataUtil();
	}
	
	public DataUtil() {
		fake= new Faker();
		
	}
	
	public String getFirstName() {
		return fake.name().firstName();
		
	}
	
	public String getLastName() {
		return fake.name().lastName();
	}
	
	public String getEmailAddress() {
		return fake.internet().emailAddress();
	}
	
	public String getUserName() {
		return fake.name().username();
	}
	
	public String getPassword() {
		return fake.internet().password();
	}
	
	public String getFirstNameEdit() {
		return fake.name().firstName();
		
	}
	
	public String getLastNameEdit() {
		return fake.name().lastName();
	
	}
	
	public String getPasswordEdit() {
		return fake.internet().password();
	}
	
	public String cardNumber() {
		return fake.finance().creditCard();
	}
	

}
