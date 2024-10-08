import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atpaul\\Documents\\chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
		//Boolean search= wait.until((driver1)->{System.out.println("hi");driver1.findElement(By.className("q")).isDisplayed();});
		
		/*Boolean bVisisble=wait.until(new Function<WebDriver,Boolean>() {

			@Override
			public Boolean apply(WebDriver driver1) {
				// TODO Auto-generated method stub
				WebElement ele=driver1.findElement(By.className("q"));
				return(ele.isDisplayed());
			}
			
		});*/
		
		WebElement ele1=wait.until((driver1)->{WebElement ele=driver1.findElement(By.name("q"));
		return ele;});
		
		ele1.sendKeys("Testing");
		WebElement btnSearch=driver.findElement(By.xpath("//input[@value='Google Search']"));
		btnSearch.click();
	}

}
