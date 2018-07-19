package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mavendemo {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
			
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("hi1");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("hello 2");
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");
		employee emp1=null;
		while(rs.next())
		{
			int eid= rs.getInt("EMPID");
			String ename=rs.getString("EMPNAME");
			int esal= rs.getInt("EMPSALARY");
			
			emp1=new employee(eid,ename,esal);
			//System.out.println(rs.getInt("empid")+"  "+rs.getString("empname")+"  "+rs.getInt("empsalary"));

		}
		System.out.println("list of emp is"+emp1);
		
		stmt.close();
		conn.close();
	
		}
}

class employee{
	int eid;
	String ename;
	public employee(int eid, String ename, int esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	int esal;
	@Override
	public String toString() {
		return "employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}
	
	
	
	
	
}
