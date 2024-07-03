import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGoogle {
	
		 @Test
		  public void Gf1() {
			  System.out.println("In Google Test1");
		  }
		  @Test
		  public void Gf2() {
			  System.out.println("In Google Test2");
		  }
		  
		  @Test
		  public void Gf3() {
			  System.out.println("In Google Test3");
		  }
		  
		  @BeforeMethod
		  public void beforeMethod() {
			  System.out.println("Before Test Method");
		  }

		  @AfterMethod
		  public void afterMethod() {
			  System.out.println("After Test Method");
		  }


}
