<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html >

	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>网站后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/static/admin/css/admin.css" />
	</head>

	<body>
		<div class="wrap-container clearfix">
				<div class="column-content-detail">
					<div class="layui-form" action="">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtnXS" data-title="添加用户" data-url="${basePath}/pageInterfaceController/toAddUserIndex.do"><i class="layui-icon">&#xe654;</i></button>
							</div>
							<div class="layui-inline">
								<input type="text" id="user_name" placeholder="请输入标题" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline">
								<select id="user_state" lay-filter="status">
									<option value="-1">请选择一个状态</option>
									<option value="0">启动</option>
									<option value="1">失效</option>
								</select>
							</div>
							<button class="layui-btn layui-btn-normal" id="search" >搜索</button>
						</div>
					</div>
					<div class="layui-form" id="table-list">
						<table class="layui-table" lay-even lay-skin="nob">
							<colgroup>
								<col width="50">
								<col class="hidden-xs" width="50">
								<col>
								<col class="hidden-xs" width="100">
								<col class="hidden-xs" width="150">
								<col class="hidden-xs" width="150">
								<col width="80">
								<col width="150">
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
									<th class="hidden-xs">ID</th>
									<th>用户名</th>
									<th class="hidden-xs">角色名</th>
									<th class="hidden-xs">创建时间</th>
									<th class="hidden-xs">最后登录时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="tbody-content">
								<!-- <tr>
									<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
									<td class="hidden-xs">1</td>
									<td class="hidden-xs"><input type="text" name="title" autocomplete="off" class="layui-input" value="0" data-id="1"></td>
									<td>玩具</td>
									<td class="hidden-xs">1989-10-14</td>
									<td class="hidden-xs">1989-10-14</td>
									<td><button class="layui-btn layui-btn-mini layui-btn-normal">正常</button></td>
									<td>
										<div class="layui-inline">
											<button class="layui-btn layui-btn-small layui-btn-normal go-btn" data-id="1" data-url="article-detail.html"><i class="layui-icon">&#xe642;</i></button>
											<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="1" data-url="article-detail.html"><i class="layui-icon">&#xe640;</i></button>
										</div>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
									<td class="hidden-xs">1</td>
									<td class="hidden-xs"><input type="text" name="title" autocomplete="off" class="layui-input" value="0" data-id="1"></td>
									<td>玩具</td>
									<td class="hidden-xs">1989-10-14</td>
									<td class="hidden-xs">1989-10-14</td>
									<td><button class="layui-btn layui-btn-mini layui-btn-normal">正常</button></td>
									<td>
										<div class="layui-inline">
											<button class="layui-btn layui-btn-small layui-btn-normal go-btn" data-id="1" data-url="article-detail.html"><i class="layui-icon">&#xe642;</i></button>
											<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="1" data-url="article-detail.html"><i class="layui-icon">&#xe640;</i></button>
										</div>
									</td>
								</tr> -->
							</tbody>
						</table>
						<div class="page-wrap" id="email-page" style="text-align: center;"></div>
					</div>
				</div>
		</div>
		<script src="${basePath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/static/admin/js/common.js?v=1.0" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		var basePath = '${basePath}';
		var $;
		var initQuery;
		var laypage;
		layui.use(['form', 'laypage', 'jquery','layer'], function() {
			var form = layui.form(),
				layer = layui.layer;
				$ = layui.jquery;
				laypage = layui.laypage;
			
			initQuery = getUserList(laypage,1,true);
			
			$("#search").on("click",function(){
				getUserList(laypage,1,true);
			});
			
		});
		
		function getUserListUnLaypage(curr,isFirst){
			getUserList(laypage, curr, isFirst);
		}
		
		
		function getUserList(laypage,curr,_isFirst){
			var user_name = $("#user_name").val();
			var user_state = $("#user_state").val()
			var totalPages = 1;
			$.ajax({
	      	      url:basePath+'/userController/getUserList.do',
	      		  type:'post',
	      		  dataType:'json',
	      		  data:{'user_name':user_name,'user_state':user_state,'currpage':curr},
	      		  async:false,
	      	      success:function (res) {
	      	         console.log(res)
	      	         totalPages = res.totalPages;
	      	        if(res.resCode == 200){
	      	        	initUserList(res.user);
	      	        }else{
	      	        	layer.msg('sdfsdf');
	      	        }
	      	      }
	  	    })
	  	    if(_isFirst){
				//分页
				 //完整功能
				laypage({
				    cont: 'email-page',
				    pages: totalPages,
				    limit: 10,
				    curr: curr,
				    layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip'],
				    skin: '#1E9FFF',
				    jump:function(obj,first){
				    	console.log(obj)
				    	if(!first){
				    		getUserList(laypage,obj.curr,false)   //非首次加载 do something  
				    	}
				    }
				  });
	  	    }
		}
		
		function initUserList(user){
			$("#tbody-content").html("");
			if(user.length>0){
        		$.each(user, function(i, item){
        			var user_state = item.user_state;
        			var html = '<tr>';
        			html += '<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>';
        				html += '		<td class="hidden-xs">1</td>';
     					html += '	<td>'+item.user_name+'</td>';
     					html += '	<td class="hidden-xs">'+item.role_name+'</td>';
     					html += '	<td class="hidden-xs">'+item.create_time+'</td>';
     					html += '<td class="hidden-xs">'+item.last_login_time+'</td>';
     					if(user_state==0){
 	    					html += '	<td><button class="layui-btn layui-btn-mini layui-btn-normal">正常</button></td>';
     					}else{
    	 					html += '	<td><button class="layui-btn layui-btn-mini layui-btn-normal">禁止</button></td>';
     					}
     					html += '	<td>';
     					html += '<div class="layui-inline">';
     					html += '<button class="layui-btn layui-btn-small layui-btn-normal addBtnXS" data-title="修改用户" data-id="'+item.id+'" data-url="'+basePath+'/pageInterfaceController/toModifyUserIndex.do"><i class="layui-icon">&#xe642;</i></button>';
     					html += '<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="'+item.id+'" data-url="'+basePath+'/userController/deleteUserInfoById.do'+'"><i class="layui-icon">&#xe640;</i></button>';
     					html += '</div>';
     					html += '</td>';
     				html += '</tr>';
     				
     				$("#tbody-content").append(html);
        		});
			}
		}
		</script>
	</body>

</html>