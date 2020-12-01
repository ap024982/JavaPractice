package org.alert.create;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

public class TestCreateAlert {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		File f1= new File("C:\\Users\\atpaul\\Documents\\Alerts.xlsx");
		FileInputStream fstr=new FileInputStream(f1);
		XSSFWorkbook wkb=new XSSFWorkbook(fstr);
		XSSFSheet wkSheet=wkb.getSheet("Sheet1");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atpaul\\Documents\\chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://axa.dxi-na1.saas.broadcom.com/sppclient/#/login?CN=JETSTREAM");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("atmadeep.paul@broadcom.com");
		driver.findElement(By.name("password")).sendKeys("Avyukt@2014");
		driver.findElement(By.id("sppSignInBtn")).click();
		FluentWait<WebDriver> f= new FluentWait<WebDriver>(driver).withTimeout(60,TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(ElementClickInterceptedException.class);
		WebElement ele1=f.until((driver1)->{WebElement ele=driver1.findElement(By.id("APM_openbtn"));
		return ele;});
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele1);
		
		for(int i=1;i<=wkSheet.getLastRowNum();i++) {
			
			XSSFRow wkRow=wkSheet.getRow(i);
			String strAlertName=wkRow.getCell(0).getStringCellValue();
		    String strAlertDescription=wkRow.getCell(2).getStringCellValue();
			String strSearchManagement=wkRow.getCell(1).getStringCellValue();
			String strMetricGrouping=wkRow.getCell(3).getStringCellValue();
			String strResolution=wkRow.getCell(4).getStringCellValue();
			String strComparison=wkRow.getCell(5).getStringCellValue();
			String strCombination=wkRow.getCell(6).getStringCellValue();
			String strTrigger=wkRow.getCell(7).getStringCellValue();
			
			WebElement webSettings=driver.findElement(By.xpath("//a[contains(@ng-click,'goToSettingsUrl')]"));
			Actions act=new Actions(driver);
			act.moveToElement(webSettings).build().perform();
			driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
			WebElement ele2=driver.findElement(By.xpath("//div[contains(text(),'Alerts')]"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", ele2);
			Thread.sleep(3000);
			WebElement ele3=driver.findElement(By.xpath("//button[contains(text(),'Create Alert')]"));
			executor1.executeScript("arguments[0].click();", ele3);
			driver.findElement(By.id("alertName")).sendKeys(strAlertName);
			WebElement ele4=driver.findElement(By.xpath("//div[contains(text(),'Search Management Modules')]"));
			act.moveToElement(ele4).click().build().perform();
			act.sendKeys(strSearchManagement).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(strAlertDescription);
			WebElement ele5=driver.findElement(By.xpath("//div[contains(text(),'Search Metric Groupings')]"));
			act.moveToElement(ele5).click().build().perform();
			act.sendKeys(strMetricGrouping).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			WebElement ele6= driver.findElement(By.xpath("//div[@id='frequency']//descendant::div[@class='css-1hwfws3']"));
			act.moveToElement(ele6).click().build().perform();
			act.sendKeys(strResolution).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			WebElement ele7=driver.findElement(By.xpath("//div[@id='comparison_operator']//descendant::div[@class='css-1hwfws3']"));
			act.moveToElement(ele7).click().build().perform();
			act.sendKeys(strComparison).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			WebElement ele8=driver.findElement(By.xpath("//div[@id='combine_operator']//descendant::div[@class='css-1hwfws3']"));
			act.moveToElement(ele8).click().build().perform();
			act.sendKeys(strCombination).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			WebElement ele9=driver.findElement(By.xpath("//div[@id='alert_trigger_mode']//descendant::div[@class='css-1hwfws3']"));
			act.moveToElement(ele9).click().build().perform();
			act.sendKeys(strTrigger).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			
			WebElement ele10=driver.findElement(By.xpath("//div[@class='mm-details-head mm-details-head-IndvMetric']//descendant::div[@class='react-switch-bg']"));
			act.moveToElement(ele10).click().build().perform();
			
			executor.executeScript("window.scrollBy(0,250)", "");
			
			WebElement ele11=driver.findElement(By.id("danger_threshold"));
			act.moveToElement(ele11).doubleClick(ele11).sendKeys(Keys.BACK_SPACE).sendKeys("10").build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			WebElement ele12=driver.findElement(By.id("danger_periods"));
			act.moveToElement(ele12).doubleClick(ele12).sendKeys(Keys.BACK_SPACE).sendKeys("10").build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			WebElement ele13=driver.findElement(By.id("danger_observed"));
			act.moveToElement(ele13).doubleClick(ele13).sendKeys(Keys.BACK_SPACE).sendKeys("10").build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			WebElement ele14=driver.findElement(By.id("caution_threshold"));
			act.moveToElement(ele14).doubleClick(ele14).sendKeys(Keys.BACK_SPACE).sendKeys("10").build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			WebElement ele15=driver.findElement(By.id("caution_periods"));
			act.moveToElement(ele15).doubleClick(ele15).sendKeys(Keys.BACK_SPACE).sendKeys("10").build().perform();
			act.sendKeys(Keys.TAB).build().perform();;
			WebElement ele16=driver.findElement(By.id("caution_observed"));
			act.moveToElement(ele16).doubleClick(ele16).sendKeys(Keys.BACK_SPACE).sendKeys("10").build().perform();
			
			
			Thread.sleep(3000);
			WebElement ele17=driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
			executor1.executeScript("arguments[0].click();", ele17);
			Thread.sleep(4000);
			act.sendKeys(Keys.ENTER).build().perform();
		}

	}

}
