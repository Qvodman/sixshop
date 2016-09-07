package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Entity.*;
import DB.*;

/**
 * 后台功能类
 * @author Administrator
 *
 */

public class AdminCtrl {
	
	/**
	 * 后台管理员登录方法
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public AdminInfo login(String userName,String userPwd){
			AdminInfo user =null;
			Connection conn =ConnDB.getConn();
			ResultSet rs =null;
			Statement stmt =null;
			String sql ="select * from admin where name='"+userName+"' and pw='"+userPwd+"'";
				try {
					stmt=conn.createStatement();
					rs=stmt.executeQuery(sql);
					if(rs.next()){
						user = new AdminInfo();						
						user.setAdminName(rs.getString("name"));						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					ConnDB.close(rs, stmt, conn);
				}
				
			return user;
		
	}
	
	/*==用户列表数据分页==*/
	/**
	 * 根据当前页数和每页显示的行数来查询相应的结果
	 * 
	 * @param pageSize
	 *            每页显示的行数
	 * @param pageNow
	 *            当前的页数
	 * @return
	 */
	public ArrayList<UserInfo> getUserForPage(int pageSize, int pageNow) {
		ArrayList<UserInfo> al = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select Top " + pageSize
				+ " * from user where Id not in(select Top (" + pageSize
				+ " * (" + pageNow + "- 1)) Id from user)";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(al==null){
					al=new ArrayList<UserInfo>();					
				}
				UserInfo userinfo = new UserInfo();
				userinfo.setUserID(rs.getString("Id"));
				userinfo.setUserName(rs.getString("name"));				
				userinfo.setUserPassWord(rs.getString("pw"));
				userinfo.setUserPower(rs.getInt("power"));
				userinfo.setUserEmail(rs.getString("email"));
				userinfo.setUserPhone(rs.getString("phone"));
				userinfo.setUserPeople(rs.getString("people"));
				userinfo.setUserAdd(rs.getString("add"));	
				userinfo.setUserCartID(rs.getString("CartID"));
				al.add(userinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(rs, stmt, conn);
		}
		return al;
	}
	/**
	 * 获取总页数
	 * @param pageSize
	 * @return
	 */
	public int getPageCount(int pageSize){
		int pageCount = 0;
		int userCount = 0;//获取到用户的总数
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as userCount from user";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				userCount = rs.getInt("userCount");
			}
			//页数计算
			if(userCount % pageSize == 0){
				pageCount = userCount / pageSize;
			}else{
				pageCount = userCount / pageSize + 1; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(rs, stmt, conn);
		}
		return pageCount;
	}
	
	/**
	 * 修改用户资料方法
	 */
	public int updateUser(UserInfo user){
		int res = 0;
		Connection conn =ConnDB.getConn();
		PreparedStatement stmt = null;
		String sql = "update user set name=?,pwuserPwd=?,power=?,email=?,phone=?,people=?,add=?,userPhone=?,CartID=?" +" where ID=?";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, user.getUserName());
				stmt.setString(2, user.getUserPassWord());
				stmt.setInt(3, user.getUserPower());
				stmt.setString(4, user.getUserEmail());
				stmt.setString(5, user.getUserPhone());
				stmt.setString(6, user.getUserPeople());
				stmt.setString(7, user.getUserAdd());
				stmt.setString(8, user.getUserCartID());
				stmt.setString(9, user.getUserID());
				res =stmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnDB.close(null, stmt, conn);
			}
		return res;
	}
	
	/**
	 * 根据ID删除用户信息
	 * @param userId
	 * @return
	 */
	public int deleteUser(int UserID){
		int res = 0;
		String sql = "delete UserInfo where ID=?";
		Connection conn = ConnDB.getConn();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,  UserID);
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(null, stmt, conn);
		}
		return res;
	}

	
	
	
	
	
	
	
	/**
	 * 添加商品分类方法
	 * @param sort
	 * @return
	 */
	public int addGoodsSort(GoodsSort sort){
		int res =0;
		Connection conn =ConnDB.getConn();
		PreparedStatement stmt =null;
		String sql ="insert into GoodsSort values(?)";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, sort.getSortname());				
				res =stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnDB.close(null, stmt, conn);
			}
		return res;
	}
	
	/**
	 * 查询所有商品类别
	 * @return
	 */
	public ArrayList<GoodsSort> selsort(){
		ArrayList<GoodsSort> asort = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goodssort";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(asort == null)
					asort = new ArrayList<GoodsSort>();
					GoodsSort sort = new GoodsSort();
					sort.setSortId(rs.getString("ID"));
					sort.setSortname(rs.getString("name"));											
					asort.add(sort);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(rs, stmt, conn);
		}
		
		return asort;
	}
	
	/**
	 * 根据ID查询商品类别方法
	 * @param sortId
	 * @return
	 */
	public GoodsSort selGoodsSort(int sortId){
		GoodsSort sort = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goodssort where ID=" + sortId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){				
				sort = new GoodsSort();				
				sort.setSortId(rs.getString("ID"));
				sort.setSortname(rs.getString("name"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(rs, stmt, conn);
		}		
		return sort;
	}
	
	/**
	 * 上架商品
	 * @param sortId
	 * @return
	 */
	public int ShangjiaGoods(String ID){
		int res = 0;
		GoodsInfo goods=null;
		Connection conn =ConnDB.getConn();
		PreparedStatement stmt = null;
		String sql = "update goods set shangjia=? where ID=?";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, 1);
				stmt.setString(2, ID);
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

