import org.h2.Driver;
import org.h2.server.*;
import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	static final String jdbcDriver = "org.h2.Driver";
	static final String databaseURL = "jdbc:h2:tcp://localhost/~/test";
	
	static final String user = "test";
	static final String password = "pass";
	
	//Driver h2Driver = new Driver();
	
	public static void main(String args[]) throws ClassNotFoundException {
		System.out.println("start");
		Connection connect = null;
		Statement statement = null;
		try {
			Class.forName(jdbcDriver);

			Server h2Server = Server.createTcpServer().start();
			System.out.println("server started");
			System.out.println(h2Server.getURL());
			connect = DriverManager.getConnection(databaseURL,user,password);
			
			
			connect.close();
			System.out.println("connection closed");
			h2Server.stop();
			System.out.println("server stoped");
			
		}catch(SQLException sqlError) {
			sqlError.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connect != null) {
					connect.close();
				}
			}catch(SQLException sqlError) {
					sqlError.printStackTrace();
			}
		}
		System.out.println("end");
	}
	
	
}
