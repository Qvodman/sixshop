package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 用于连接数据库的类
 * @author Administrator
 *
 */
public class ConnDB {
	private static final String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf-8";
	/**
	 * 获取连接的方法
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,"root","123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭连接的方法
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(rs != null)			
				rs.close();
			if(stmt !=null)
				stmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
