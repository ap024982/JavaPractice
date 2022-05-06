package application;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilties.reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class baseClass {
    static ThreadLocal<WebDriver> th=new ThreadLocal<WebDriver>();
    ExtentReports tst1;
    reusable r1=new reusable();
    File f1;
    FileInputStream fo;
    String strUrl;
    String strDriverPath;
    String strReportPath;

    public WebDriver initialize(String strBrowser) throws IOException {

        if (strBrowser.equalsIgnoreCase("CHROME")) {
            strDriverPath = r1.getDriverPath("Chrome");
            System.setProperty("webdriver.chrome.driver", strDriverPath);
            th.set(new ChromeDriver());
            th.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (strBrowser.equalsIgnoreCase("FIREFOX")) {
            strDriverPath = r1.getDriverPath("Firefox");
            System.setProperty("webdriver.gecko.driver", strDriverPath);
            th.set(new FirefoxDriver());
            th.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //return (th.get());
        } else if (strBrowser.equalsIgnoreCase("IE")) {
            strDriverPath = r1.getDriverPath("IE");
            System.setProperty("webdriver.IE.driver", strDriverPath);
            th.set(new FirefoxDriver());
            th.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           // return (th.get());
        }
        return (th.get());
    }
        /*driver.get(strUrl);
        strReportPath=strPath+"//src//reports";*/



    public ExtentTest setupExtentReports(String strTestName) {
       String strReportLocation=r1.getReportLocation();
       tst1 =new ExtentReports(strReportLocation+"//"+System.currentTimeMillis()+"//TestReport.html");
       ExtentTest et1=tst1.startTest(strTestName);
        return et1;
    }

    public void cleanup() {
        th.get().quit();
        th.remove();
        tst1.flush();
    }

    public void close() {
        tst1.close();
    }

  /*  @AfterClass
    public void cleanup() throws IOException {
      //  driver.quit();
        fo.close();

    }*/
}
