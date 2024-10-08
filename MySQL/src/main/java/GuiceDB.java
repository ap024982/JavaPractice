import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class GuiceDB extends AbstractModule {
	
	
	String strFile="C:\\Users\\atpaul\\Documents\\Java Programs\\MySQL\\src\\main\\resources\\DBConfig.properties";

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(String.class).annotatedWith(Names.named("FILENAME")).toInstance(strFile);
		
	}
	
	@Provides
	public MySQLClient setConnectionDetails(@Named("CONFIG") Properties prop) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		MySQLClient t1=new MySQLClient();
		
		String strConnection=prop.get("Connection").toString();
		String strUser=prop.get("UserName").toString();
		String strPass=prop.get("Password").toString();
		t1.setConnection(strConnection,strUser,strPass);
		return(t1);
	}
	
	@Named("CONFIG")
	@Provides
	public Properties getProperties(@Named("FILENAME") String strFileName) throws FileNotFoundException, IOException {
		Properties prop=new Properties();
		prop.load(new InputStreamReader(new FileInputStream(strFileName)));
		return prop;
	}

}
