package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entity.*;
import DB.*;

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
}
