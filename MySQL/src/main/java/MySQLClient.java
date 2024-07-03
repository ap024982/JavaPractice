import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class MySQLClient {
	
	Connection con;
	
	public void setConnection(String strConn,String strUserName,String strPassword) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(strConn,strUserName,strPassword);
	}

	
	public <T> T runQuery(Class<T> Tclass,String strSQL) throws SQLException {
		T result=null;
		QueryRunner qr=new QueryRunner();
		ResultSetHandler<T> rs=new BeanHandler<T>(Tclass);
		result=qr.query(con, strSQL,rs,20);
		/*Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery(strSQL);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getInt(4));
		}*/
		/*System.out.println(emp.getFirst_name());
		System.out.println(emp.getSalary());*/
		con.close();
		return result;
	}
		
		

}
