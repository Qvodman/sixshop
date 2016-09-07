<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="DB.*"%>
<%@ page import="DAO.*"%>
<%@ page import="Entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
		<div class="col-xs-8 col-md-9 col-lg-12">
		  			<div> 
							<div class="row">
								<div class="col-md-12" >
									<div class="panel panel-default">
									  <!-- Default panel contents -->
									  <div class="panel-heading">添加商品</div>
									  <div class="panel-body">
									    <p>
									    	Some default panel content here. Nulla vitae elit libero, a pharetra augue.
									    	Aenean lacinia bibendum nulla sed consectetur. 
									    	Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. 
									    	Nullam id dolor id nibh ultricies vehicula ut id elit.
									    </p>
									  </div>
									
									  <!-- Table -->
									  <form action="Admin_AddGoodsServlet" method="post">
									  <table class="table" style="text-align: center;" >
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
									    		<th>图片</th>
									    		
									    	</tr>
									    </thead>
									    <tbody id="table">
									    	<tr>
												<td><input type="text" class="form-control" id="id" name="id" placeholder="请输入编号"></td>
												<td><input type="text" class="form-control" id="name" name="name" placeholder="请输入名称"></td>
												<!-- <td><input type="text" class="form-control" id="type" name="type" placeholder="请输入类型"></td> -->
												<td><select class="form-control" id="type" name="type" >
										<%
										Connection conn = ConnDB.getConn();
										Statement stmt = null;
										ResultSet rs = null;
										String sql = "select * from goodssort";
										stmt = conn.createStatement();
										rs = stmt.executeQuery(sql);
										out.print("<option value='0'>请输入类型</option>");
										while(rs.next()){
											out.print("<option value ='"+rs.getString("ID")+"'>"+rs.getString("name")+"</option>");
										}
										%></select></td>
										<td><input type="text" class="form-control" id="kucun" name="kucun" placeholder="请输入库存"></td>
												<td><input type="text" class="form-control" id="yishou" name="yishou" placeholder="0" value="0" disabled></td>
   												<td><input type="text" class="form-control" id="price" name="price" placeholder="请输入价格"></td>
												<td><input type="text" class="form-control" id="miaoshu" name="miaosu" placeholder="请输入描述"></td>
												<!-- <td><input type="checkbox" style="width:35px" value="0" name="shangjia"></td> -->
												<td><select class="form-control"  name="shangjia" >
													<%
													out.print("<option value='1'>上架</option>");
													out.print("<option value='0'>不上架</option>"); %>
													</select>
													
												</td>
												<td><input type="file" name="file" size="15" input enctype="multipart/form-data" maxlength="100" name="image"></td>
												<td><input type="button" value="+" onclick="addColumn()"></td>
												<td><input type="button" value="X" onclick="deletefile(this)"></td>
											</tr>
									    <tfoot>
									    	<tr>
									    		<th colspan="10" style="text-align: center;">
									    			<input type="submit" value="确定">
									    			<input type="button" value="取消">
									    		</th>
									    		
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
		</script>
	</body>
</html>
