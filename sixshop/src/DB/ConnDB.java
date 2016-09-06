package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * �����������ݿ����
 * @author Administrator
 *
 */

public class ConnDB {
	private String dbUrl = "jdbc:mysql://localhost:3306/eshop?useUnicode=true&characterEncoding=utf-8";
	private String dbUser = "root";
	private String dbPwd = "123456";
	
	//����������
	public ConnDB () throws Exception{
	     Class.forName("com.mysql.jdbc.Driver");
	}
	
	//�������ݿ����ӣ���½���ݿ�
	public Connection getConnection()throws Exception{
		return DriverManager.getConnection(dbUrl,dbUser,dbPwd);
	}
	
	//�ر����ݿ�����
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
