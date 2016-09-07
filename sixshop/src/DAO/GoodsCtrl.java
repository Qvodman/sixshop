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
 * 商品操作类
 * @author Administrator
 *
 */
public class GoodsCtrl {
	/**
	 * 添加商品方法
	 * @param goods
	 * @return
	 */
	public int addGoods(GoodsInfo goods){
		int res =0;
		Connection conn =ConnDB.getConn();
		PreparedStatement stmt =null;
		String sql ="insert into goods values(?,?,?,?,?,?,?,?,?)";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, goods.getGoodsID());
				stmt.setString(2, goods.getGoodsName());
				stmt.setString(3, goods.getGoodsType());
				//stmt.setString(4, goods.getGoodsImage());
				stmt.setString(4, "1");
				stmt.setInt(5, goods.getGoodsKucun());
				stmt.setInt(6, goods.getGoodsYishou());
				stmt.setDouble(7, goods.getGoodsPrice());
				stmt.setString(8, goods.getGoodsMiaosu());
				stmt.setInt(9, goods.getGoodsShangjia());
				res =stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnDB.close(null, stmt, conn);
			}
		return res;
	}
	
	/*==商品列表数据分页==*/
	/**
	 * 查询未上架商品
	 * 根据当前页数和每页显示的行数来查询相应的结果
	 * 
	 * @param pageSize
	 *            每页显示的行数
	 * @param pageNow
	 *            当前的页数
	 * @return
	 */
	public ArrayList<GoodsInfo> getShangjiaGoodsForPage(int pageSize, int pageNow) {
		ArrayList<GoodsInfo> agoods = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goods where shangjia = '0' order by ID asc limit "+(pageNow-1)+","+pageSize+"";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(agoods==null){
					agoods=new ArrayList<GoodsInfo>();					
				}
				GoodsInfo goods = new GoodsInfo();
				goods.setGoodsID(rs.getString("ID"));
				goods.setGoodsName(rs.getString("name"));
				goods.setGoodsType(rs.getString("type"));
				goods.setGoodsImage(rs.getString("image"));
				goods.setGoodsKucun(rs.getInt("kucun"));
				goods.setGoodsYishou(rs.getInt("yishou"));
				goods.setGoodsPrice(rs.getDouble("price"));				
				goods.setGoodsMiaosu(rs.getString("miaosu"));
				goods.setGoodsShangjia(rs.getInt("shangjia"));
				agoods.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(rs, stmt, conn);
		}
		return agoods;
	}
	/*==商品列表数据分页==*/
	/**
	 * 查询上架商品
	 * 根据当前页数和每页显示的行数来查询相应的结果
	 * 
	 * @param pageSize
	 *            每页显示的行数
	 * @param pageNow
	 *            当前的页数
	 * @return
	 */
	public ArrayList<GoodsInfo> getXiajiaGoodsForPage(int pageSize, int pageNow) {
		ArrayList<GoodsInfo> agoods = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goods where shangjia = '1' order by ID asc limit "+(pageNow-1)+","+pageSize+"";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				if(agoods==null){
					agoods=new ArrayList<GoodsInfo>();					
				}
				GoodsInfo goods = new GoodsInfo();
				goods.setGoodsID(rs.getString("ID"));
				goods.setGoodsName(rs.getString("name"));
				goods.setGoodsType(rs.getString("type"));
				goods.setGoodsImage(rs.getString("image"));
				goods.setGoodsKucun(rs.getInt("kucun"));
				goods.setGoodsYishou(rs.getInt("yishou"));
				goods.setGoodsPrice(rs.getDouble("price"));				
				goods.setGoodsMiaosu(rs.getString("miaosu"));
				goods.setGoodsShangjia(rs.getInt("shangjia"));
				agoods.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(rs, stmt, conn);
		}
		return agoods;
	}
	/**
	 * 获取总页数
	 * @param pageSize
	 * @return
	 */
	public int getGoodsCount(int pageSize){
		int pageCount = 0;
		int goodsCount = 0;//获取到商品的总数
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as goodsCount from goods";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				goodsCount = rs.getInt("goodsCount");
			}
			//页数计算
			if(goodsCount % pageSize == 0){
				pageCount = goodsCount / pageSize;
			}else{
				pageCount = goodsCount / pageSize + 1; 
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
	 * 根据ID查询商品方法
	 * @param goodsId
	 * @return
	 */
	public GoodsInfo selgoods(int goodsId){
		GoodsInfo goods = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goods where ID=" + goodsId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){				
				goods = new GoodsInfo();
				goods.setGoodsID(rs.getString("ID"));
				goods.setGoodsName(rs.getString("name"));
				goods.setGoodsType(rs.getString("type"));
				goods.setGoodsImage(rs.getString("image"));
				goods.setGoodsKucun(rs.getInt("kucun"));
				goods.setGoodsYishou(rs.getInt("yishou"));
				goods.setGoodsPrice(rs.getDouble("price"));				
				goods.setGoodsMiaosu(rs.getString("miaosu"));
				goods.setGoodsShangjia(rs.getInt("shangjia"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(rs, stmt, conn);
		}		
		return goods;
	}
	
}
