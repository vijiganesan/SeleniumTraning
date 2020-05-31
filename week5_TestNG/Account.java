package testcase;

import org.testng.annotations.Test;

public class Account {
  @Test(priority=2)
  public void create() {
	  System.out.println("Create an Account");
  }
  
  @Test
  public void edit() {
	System.out.println("Edit an Account");
  }
  
  @Test(priority=1)
  public void deleteAccount() {
	  System.out.println("Deleting an Account");
  }
  


}
