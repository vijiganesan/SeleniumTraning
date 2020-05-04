package week1.day1;

public class MobilePhone {
	
	String mobileBrand = "OnePlus";
	double mobilePrice = 7.5;
	int noContact = 40000;
	long imeNum = 7542249870L;
	
		
	public void sendMessage() {
		
		System.out.println("This is to Send Message");
	}
	
	public void takePicture() {
		System.out.println("This is to Take Picture");

	}
	
	private void makeCall() {
		System.out.println("This is to call a number");
		

	}
	
	public static void main(String[] args) {
		
		//ClassName objectName = new ClassName();
		MobilePhone myPhone = new MobilePhone();
				
		myPhone.sendMessage();
		myPhone.takePicture();
		myPhone.makeCall();
		
		String brand = myPhone.mobileBrand;
		double price = myPhone.mobilePrice;
		int contact = myPhone.noContact;
		long imenumber = myPhone.imeNum;
		
		System.out.println(brand);
		System.out.println(price);
		System.out.println(contact);
		System.out.println(imenumber);
			
				
	}


}
