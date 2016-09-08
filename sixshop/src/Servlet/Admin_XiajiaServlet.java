package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminCtrl;
import DAO.GoodsCtrl;
import Entity.GoodsInfo;

public class Admin_XiajiaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8268297261584578758L;

	/**
	 * Constructor of the object.
	 */
	public Admin_XiajiaServlet() {
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
		AdminCtrl ac = new AdminCtrl();
		
		String goodsId =request.getParameter("id");


		
		int res =ac.XiajiaGoods(goodsId);
		if(res>0){
			out.print("下架成功！");
			//out.print("<script>alert('上架成功！');window.location.href='../admin/shangjia.jsp';</script>");
		}else{
			//out.print("<script>alert('上架失败！');window.history.back();</script>");
			out.print("下架失败！");
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


