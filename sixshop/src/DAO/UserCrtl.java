package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.*;
import Entity.*;

/**
 * 用户信息操作类
 * @author Qvodman
 *
 */

public class UserCrtl {

	/**
	 * 用户注册方法
	 * @param user
	 * @return
	 */
	public int addUser(UserInfo user){
		int res = 0;
		Connection conn =ConnDB.getConn();
		PreparedStatement stmt = null;
		String sql ="insert into user values(?,?,?,?,?,?,?,?,default)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserID());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getUserPassWord());
			stmt.setInt(4, user.getUserPower());
			stmt.setString(5, user.getUserEmail());
			stmt.setString(6, user.getUserPhone());
			stmt.setString(7, user.getUserPeople());
			stmt.setString(8, user.getUserAdd());
			stmt.setString(9, user.getUserCartID());
			res =stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(null, stmt, conn);
		}
	return res;
	}
}