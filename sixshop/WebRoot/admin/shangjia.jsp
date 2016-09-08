<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="DB.*"%>
<%@ page import="DAO.*"%>
<%@ page import="Entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	int pageSize = 10;//定义每页显示的条目数
	int pageNow = 1;//默认显示第一页
	int pageCount = 1;//默认只有1页
	GoodsCtrl gc = new GoodsCtrl();
	if(request.getParameter("pageNow") != null)
	pageNow = Integer.parseInt(request.getParameter("pageNow"));
	//获取总页数
	pageCount = gc.getGoodsCount(pageSize);
	
	//如果小于第一页，则显示第一页
	if(pageNow <= 0){
		pageNow = 1;
	}
	//如果超过最后一页，则显示最后一页
	if(pageNow >= pageCount){
		pageNow = pageCount;
	}
	ArrayList<GoodsInfo> agoods = gc.getShangjiaGoodsForPage(pageSize,pageNow);
%>
  <script type="text/javascript">
  	function pageGo(){
  		var pageNow = document.getElementById("pageNow");
  		if(pageNow.value.length==0){
				alert("请输入要跳转的页数！");
				pageNow.value="";
				pageNow.focus();
				return;	
			}
		if(isNaN(pageNow.value)){
				alert("请输入正确的页数！");
				pageNow.value="";
				pageNow.focus();
				return;	
			}
  		window.location.href="shangjia.jsp?pageNow=" + pageNow.value;
  	}
  </script>


<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title></title>
		
		<link href="css/normalize.css" rel="stylesheet">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		
		<style>
			html {
				width: 100%;
				height: 100%;
			}
			body {
				width: 100%;
				height: 100%;
				background-color: #FCF8E3;
				overflow: auto;
			}
		</style>
	</head>
	<body>
		<div class="col-xs-8 col-md-12 col-lg-12">
		  			<div> 
							<div class="row">
								<div class="col-md-12" >
									<div class="panel panel-default">
									  <!-- Default panel contents -->
									  <div class="panel-heading">上架商品</div>
									  <div class="panel-body">
									    <p>
									    	Some default panel content here. Nulla vitae elit libero, a pharetra augue.
									    	Aenean lacinia bibendum nulla sed consectetur. 
									    	Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. 
									    	Nullam id dolor id nibh ultricies vehicula ut id elit.
									    </p>
									  </div>
									
									  <!-- Table -->
									   <form action="Admin_ShangjiaServlet" method="post">
									  <table class="table" >
									    <thead>
									    	<tr>
									    		<th>编号</th>
									    		<th>名称</th>
									    		<th>类型</th>
									    		<th>库存</th>
									    		<th>已售</th>
									    		<th>价格</th>
									    		<th>描述</th>
									    		<th>状态</th>
									    		
									    		
									    	</tr>
									    </thead>
	
									    <tbody id="table" style="text-align: center;">
									     <%
                  	for(GoodsInfo goods : agoods){
                  		int sortid =Integer.parseInt(goods.getGoodsType());
	                  	GoodsSort sort = new GoodsSort();
		        		AdminCtrl ac = new AdminCtrl();
		        		sort =ac.selGoodsSort(sortid);           	
                   %> 
									    	<tr>
									    		<td><%=goods.getGoodsID() %>					
												<td><%=goods.getGoodsName() %></td>
												<td><%=sort.getSortname() %></td>
												<td><%=goods.getGoodsKucun() %></td>
												<td><%=goods.getGoodsYishou() %></td>
												<td><%=goods.getGoodsPrice() %></td>
												<td><%=goods.getGoodsMiaosu() %></td>
												<td> <input type="button" onclick="shangjiaGoods('<%=goods.getGoodsID() %>')" value="上架" ></td>
												<%}%>
												
												
                    							<td>

									    		
									    		
									    		
									    	</tr> 	
									    </tbody>
									    <tfoot>
									    	
                  		<td style="border-left:#CFE0F0 1px solid;" colspan="9" style="text-align: center;">
                  			<a href="shangjia.jsp?pageNow=1">首页</a>
                  			<a href="shangjia.jsp?pageNow=<%=pageNow-1 %>">上一页</a>                  			
                  			<font style="color: red; font-size: 12px;"><%=pageNow %>/<%=pageCount %></font>
                  			<a href="shangjia.jsp?pageNow=<%=pageNow+1 %>">下一页</a>
                  			<a href="shangjia.jsp?pageNow=<%=pageCount %>">尾页</a>
                  			<font style="color: red; font-size: 12px;">到第</font><input type="text" style="width: 20px;height: 20px;" id="pageNow"><font style="color: red; font-size: 12px;">页</font>
                  			<a href="javascript:pageGo()">跳转</a>                  			
                  		</td>
                  </tr>
									    	</tr>
									    </tfoot>
									  </table>
									  </form>
									</div>

								</div>
							</div>	  	
		  			</div>
		  		</div>
		<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script>
			 var index=1;
			 var column = $("#table").html();

			    function addColumn(){
			    	$("#table").append(column);
			    }
			    function deletefile(input){
			    	
			    	var tr = $(input).parents("tr");
			    	tr.remove();
			    }
			    function shangjiaGoods(id){
				    $.ajax({
				    	url:"Admin_ShangjiaServlet",
				    	method:"post",
				    	data:{id:id},
				    	success:function(data){
				    		alert(data);
				    		location.reload();
				    	}
				    });
			    }
			    
		</script>
	</body>
</html>

