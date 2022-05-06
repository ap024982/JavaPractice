import application.applicationQuestions;
import application.baseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(ListenerTest.class)

public class TestApplication  {

    applicationQuestions aq;
    applicationQuestionsTest aqt;
    baseClass b2=new baseClass();


    /*@BeforeClass
    public void setupReport(){

        ert=new ExtentReports(strReportPath+ System.currentTimeMillis()+"//TestReport.html");
        etest=ert.startTest("Starting Application Validation");
    }*/

   /* @BeforeMethod
    public void navigateURL(){
        System.setProperty("webdriver.chrome.driver",strDriverPath);
        th.set(new ChromeDriver());

    }*/
   /* @Test (priority=0)
    public void testCreateRegisterButton(){

    }*/

    @Test
    public void registerNewAccount(){

       /*System.out.println("In here");
        //driver=th.get();
        th.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver=new ChromeDriver();
        //
        th.get().get(strUrl);
        aq=new applicationQuestions(th.get());
        aq.clickRegister();
        aq.newAccountRegister(etest);*/
        aqt=new applicationQuestionsTest();
        aqt.start();
    }

    @Test
    public void testForgotPassword() throws IOException {
       /*driver=th.get();
        th.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver=new ChromeDriver();
        //
        th.get().get(strUrl);*/
        aq=new applicationQuestions("Chrome");
        aq.ForgotPassword();
    }

    @Test
    public void testHomePage() throws IOException {
       /*driver=th.get();
        th.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver=new ChromeDriver();
        //
        th.get().get(strUrl);*/
        aq=new applicationQuestions("Firefox");
        aq.validateTitle();
    }
/*@AfterMethod
    public void cleanup(){
        th.get().quit();
        th.remove();
        ert.flush();
    aq.cleanup();

}*/

    @AfterClass
    public void cleanReport(){

        b2.close();
    }
}
