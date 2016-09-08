package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GoodsCtrl;
import Entity.GoodsInfo;

public class Admin_XiugaiGoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8268297261584578758L;

	/**
	 * Constructor of the object.
	 */
	public Admin_XiugaiGoodsServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		GoodsInfo goods = new GoodsInfo();
		GoodsCtrl gc = new GoodsCtrl();
		
		String goodsId =request.getParameter("id");
		String goodsName =request.getParameter("name");
		String goodsSort =request.getParameter("type");
		//String goodsImg =request.getParameter("image");
		String goodsImg="1";
		int goodsKucun =Integer.parseInt(request.getParameter("kucun"));
		double goodsPrice =Double.parseDouble(request.getParameter("price"));
		String goodsMiaosu =request.getParameter("miaosu");
		int goodsShangjia =Integer.parseInt(request.getParameter("shangjia"));

		goods.setGoodsID(goodsId);
		goods.setGoodsName(goodsName);
		goods.setGoodsType(goodsSort);
		goods.setGoodsImage("1");
		goods.setGoodsKucun(goodsKucun);
		goods.setGoodsYishou(0);
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsMiaosu(goodsMiaosu);
		goods.setGoodsShangjia(goodsShangjia);
		
		int res =gc.xiugaiGoods(goods);
		if(res>0){
			out.print("修改成功！");
			//out.print("<script>alert('修改成功！');window.location.href='../admin/addgoods.jsp';</script>");
		}else{
			out.print("修改失败！");
			//out.print("<script>alert('修改失败！');window.history.back();</script>");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}


