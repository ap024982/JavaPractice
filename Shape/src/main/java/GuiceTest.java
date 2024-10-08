import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class GuiceTest extends AbstractModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
	bind(Shape.class).to(Rectangle.class);
		/*bind(Integer.class).annotatedWith(Names.named("Length")).toInstance(3);
		bind(String.class).annotatedWith(Names.named("Breadth")).toInstance("ABC");
		bind(Integer.class).annotatedWith(Names.named("Height")).toInstance(10);*/
		
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream("C:\\Users\\atpaul\\Documents\\Java Programs\\Shape\\src\\main\\resources\\Dev.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Names.bindProperties(binder(), prop);
	}
	
	/*@Provides
	public Shape getShape(@Named("Length") int a,@Named("Breadth") String b) {
		return new Rectangle(a,b);
	}*/
	
	/*@Named("Height")
	@Provides
	public int getVal() {
		return 10;
	}*/
	

}
