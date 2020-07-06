import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Rectangle implements Shape {

	@Inject
	@Named("db.length")
	public int length;
	
	@Inject
	@Named("db.breadth")
	public String breadth;
	
	@Inject
	@Named("db.height")
	public int height;
	
	/*Rectangle(int x,String y){
		length=x;
		breadth=y;
		//height=z;
	}*/
	
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("In Rectangle");
		System.out.println(length+breadth+height);
	}

}
