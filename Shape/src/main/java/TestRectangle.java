import com.google.inject.Inject;

public class TestRectangle {
	
	
	@Inject
	Shape s;
	
	@Inject
	Rectangle r;
	
	/*@Inject
	void setShape(Shape s1){
		s=s1;
	}*/
	
	
	
	public void validate() {
		System.out.println(r.length);
		System.out.println(r.breadth);
		System.out.println(r.height);
		
		s.area();
	}

}
