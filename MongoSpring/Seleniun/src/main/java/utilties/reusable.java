package utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class reusable {
    File f1;
    FileInputStream fo;
    String strUrl;
    String strDriverPath;
    String strReportPath;
    String strDriver;
    Properties prop;

    public void loadPropertyFiles() throws IOException {
        String strPath = System.getProperty("user.dir");
        System.out.println("Current Dir=" + strPath);
        String strPropFile = strPath + "//src//resources//application.properties";
        System.out.println("Property File Loc=" + strPropFile);
        f1 = new File(strPropFile);
        fo = new FileInputStream(f1);
        prop=new Properties();;
        prop.load(fo);
        System.out.println("Property1="+prop.getProperty("chromedriver"));
    }

    public String getDriverPath(String DriverType) throws IOException {

        loadPropertyFiles();
        System.out.println("Property2="+prop.getProperty("chromedriver"));
        if (DriverType.equalsIgnoreCase("chrome")) {
            strDriver = prop.getProperty("chromedriver");
        } else if (DriverType.equalsIgnoreCase("FIREFOX")) {
            strDriver = prop.getProperty("firefoxdriver");
        }else if (DriverType.equalsIgnoreCase("IE")) {
            strDriver = prop.getProperty("iedriver");
        }
         strDriverPath = System.getProperty("user.dir") + strDriver;
        System.out.println("Driver Path=" + strDriverPath);
        return strDriverPath;
    }

    public String getURL() throws IOException {
        loadPropertyFiles();
        System.out.println("URL1="+prop.getProperty("url"));
        return prop.getProperty("url");
    }

    public String getReportLocation(){
        return (System.getProperty("user.dir")+"//src//reports");
    }


        /*System.setProperty("webdriver.chrome.driver",strDriverPath);

        driver=new ChromeDriver();
        driver.get(strUrl);
        strReportPath=strPath+"//src//reports";

    }*/
}
