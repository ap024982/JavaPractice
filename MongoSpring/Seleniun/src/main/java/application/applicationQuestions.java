package application;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import utilties.reusable;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class applicationQuestions extends baseClass {

    WebDriver driver;
    ExtentTest et1;
    baseClass b1=new baseClass();
    reusable r2;

    By btnNewAccount= By.cssSelector("a[role='button'][data-testid='open-registration-form-button']");
    By txtFirstName=By.name("firstname");
    By txtLastName=By.cssSelector("input[name='lastname']");
    By lstDay=By.cssSelector("select#day");
  //  By optGender=By.cssSelector("input._8esa[name='sex']");
    By lblGenderM=By.xpath("//label[text()='Male']//following-sibling::input[@name='sex']");
    By lblGenderF=By.xpath("//label[text()='Female']//following-sibling::input[@name='sex']");
   // By lblGenderF=By.xpath("label[text()='Female']");
    By lnkForgotPass=By.xpath("//a[contains(text(),'Forgotten password')]");


    public applicationQuestions(String strBrowser) throws IOException {

        this.driver=b1.initialize(strBrowser);
        et1=b1.setupExtentReports("Regression Tests");
        r2=new reusable();
        //System.out.println("URL2="+r2.getURL());
        driver.get(r2.getURL());

    }




    public void clickRegister(){
        System.out.println("Current Handle="+driver.getWindowHandle());
        driver.findElement(btnNewAccount).click();
        et1.log(LogStatus.PASS,"Clicked on Register Link");
    }

    public void newAccountRegister(){

        /*Set<String> s2=driver.getWindowHandles();
        for (String s : s2) {
          System.out.println("New Handle="+s);
        }*/
       // WebDriverWait w1=new WebDriverWait(driver,10);
        //w1.until(ExpectedConditions.presenceOfElementLocated(txtFirstName));
        Wait<WebDriver> w1=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        WebElement e2=w1.until((driver)->{
            return driver.findElement(txtFirstName);
        });
        //driver.findElement(txtFirstName).sendKeys("Atmadeep");
        e2.sendKeys("Atmadeep");
        Select s1=new Select(driver.findElement(lstDay));
        s1.selectByValue("10");
        driver.findElement(txtLastName).sendKeys("Paul");
        driver.findElement(lblGenderF).click();
        et1.log(LogStatus.PASS,"Clicked Details on User Registration Page");
        b1.cleanup();

    }

    public void ForgotPassword(){
        driver.findElement(lnkForgotPass).click();
        System.out.println("Clicked Forgot Password");
        et1.log(LogStatus.PASS,"Clicked on Forgot Password");
        b1.cleanup();
    }

    public void validateTitle(){
        String strHeader=driver.getTitle();
        System.out.println("Page Title="+strHeader);
        et1.log(LogStatus.PASS,"Validating Title");
        b1.cleanup();
    }


}

