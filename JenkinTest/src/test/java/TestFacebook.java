import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestFacebook {
  @Test
  public void f1() {
	  System.out.println("In Test1");
  }
  @Test
  public void f2() {
	  System.out.println("In Test2");
  }
  
  @Test
  public void f3() {
	  System.out.println("In Test3");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Test Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Test Method");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

}
