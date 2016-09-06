package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用于连接数据库的类
 * @author Administrator
 *
 */

public class ConnDB {
	private String dbUrl = "jdbc:mysql://localhost:3306/eshop?useUnicode=true&characterEncoding=utf-8";
	private String dbUser = "root";
	private String dbPwd = "123456";
	
	//加载驱动类
	public ConnDB () throws Exception{
	     Class.forName("com.mysql.jdbc.Driver");
	}
	
	//建立数据库连接，登陆数据库
	public Connection getConnection()throws Exception{
		return DriverManager.getConnection(dbUrl,dbUser,dbPwd);
	}
	
	//关闭数据库连接
	public void closeConnection(Connection con){
	    try{
	        if(con!=null) con.close();
	      }catch(Exception e){
	        e.printStackTrace();
	      }
	}
	
	
	public void closePrepStmt(PreparedStatement prepStmt){
	    try{
	        if(prepStmt!=null) prepStmt.close();
	      }catch(Exception e){
	        e.printStackTrace();
	      }
	  }

	public void closeResultSet(ResultSet rs){
	    try{
	        if(rs!=null) {
	        	rs.close();
	        	}
	      }catch(Exception e){
	        e.printStackTrace();
	      }
	  }

}
