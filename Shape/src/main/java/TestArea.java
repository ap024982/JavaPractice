import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Shape s=new Rectangle(43);
		Injector inj=Guice.createInjector(new GuiceTest());
		TestRectangle tr=inj.getInstance(TestRectangle.class);
		tr.validate();
	}

}
