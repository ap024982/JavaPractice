package org.alert.create;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
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

public class TestMetricGroupsParameterized {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		File f1= new File("C:\\Users\\atpaul\\Documents\\Metrics.xlsx");
		FileInputStream fstr=new FileInputStream(f1);
		XSSFWorkbook wkb=new XSSFWorkbook(fstr);
		XSSFSheet wkSheet=wkb.getSheet("Sheet1");
		int iRowCount=wkSheet.getLastRowNum()-wkSheet.getFirstRowNum();
		
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
		//ele1.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele1);
		
		
		for(int i=1;i<=wkSheet.getLastRowNum();i++) {
			
			XSSFRow wkRow=wkSheet.getRow(i);
			String strMetricName=wkRow.getCell(0).getStringCellValue();
			String strMetricType=wkRow.getCell(1).getStringCellValue();
			String strMetricDescription=wkRow.getCell(2).getStringCellValue();
			String strAgentSpecifier=wkRow.getCell(3).getStringCellValue();
			String strMetricSpecifier=wkRow.getCell(4).getStringCellValue();
			
			WebElement webSettings=driver.findElement(By.xpath("//a[contains(@ng-click,'goToSettingsUrl')]"));
			Actions act=new Actions(driver);
			act.moveToElement(webSettings).build().perform();
			driver.findElement(By.xpath("//span[contains(text(),'Settings')]")).click();
			WebElement ele2=driver.findElement(By.xpath("//div[contains(text(),'Metric Groupings')]"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", ele2);
			Thread.sleep(3000);
			WebElement ele5=driver.findElement(By.xpath("//button[contains(text(),'Create Metric Grouping')]"));
			executor1.executeScript("arguments[0].click();", ele5);
			driver.findElement(By.id("metricGroupingName")).sendKeys(strMetricName);
			WebElement ele3=driver.findElement(By.xpath("//div[contains(text(),'Search Management Modules')]"));
			act.moveToElement(ele3).click().build().perform();
			act.sendKeys(strMetricType).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(strMetricDescription);
			driver.findElement(By.name("agentExpression")).sendKeys(strAgentSpecifier);
			driver.findElement(By.name("metricExpression")).sendKeys(strMetricSpecifier);
			WebElement ele4=driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
			executor1.executeScript("arguments[0].click();", ele4);
			Thread.sleep(2000);
			act.sendKeys(Keys.ENTER).build().perform();
		}
		
		
	}

}
