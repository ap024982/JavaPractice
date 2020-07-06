import java.sql.SQLException;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;



public class TestEmployee {
	
	
	@Inject
	MySQLClient s1;
	String strSQL="Select * from employees where id=?";

	public void test() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Employees e1=s1.runQuery(Employees.class, strSQL);
		System.out.println(e1.first_name+e1.last_name+e1.salary);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Injector inj=Guice.createInjector(new GuiceDB());
		TestEmployee t1=inj.getInstance(TestEmployee.class);
		t1.test();
	}

}
