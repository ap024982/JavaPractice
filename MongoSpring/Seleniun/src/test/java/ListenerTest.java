import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest  implements ITestListener {
    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("Passed Test="+arg0.getPassedTests());

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
    System.out.println("Start Date="+arg0.getStartDate());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("Failed Test1="+arg0.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub
       System.out.println("Failed Test2="+arg0.getTestName());
       // etest.log(LogStatus.FAIL,"Testing Failed="+arg0.getTestName());

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub
        //etest.log(LogStatus.SKIP,"Testing SKipped="+arg0.getMethod());

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("Test Start Method="+arg0.getMethod());
       // etest.log(LogStatus.INFO,"Testing STarted="+arg0.getMethod());

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
       System.out.println("Success Method="+arg0.getMethod());
       // etest.log(LogStatus.PASS,"Testing Run Successfully="+arg0.getMethod());

    }
}
