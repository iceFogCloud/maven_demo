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
								<button class="layui-btn layui-btn-small layui-btn-normal addBtnXS" data-w="500px" data-h="450px" data-title="添加资源" data-url="${basePath}/pageInterfaceController/toAddSourceIndex.do"><i class="layui-icon">&#xe654;</i></button>
							</div>
							<div class="layui-inline">
								<input type="text" id="source_name" placeholder="请输入标题" autocomplete="off" class="layui-input">
							</div>
							<button class="layui-btn layui-btn-normal" id="search" >搜索</button>
						</div>
					</div>
					<div class="layui-form" id="table-list">
						<table class="layui-table" lay-even lay-skin="nob">
							<colgroup>
								<col class="hidden-xs" width="50">
								<col class="hidden-xs" width="50">
								<col  >
								<col class="hidden-xs" width="150">
								<col  >
								<col  >
							</colgroup>
							<thead>
								<tr>
									<th class="hidden-xs"><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
									<th class="hidden-xs">ID</th>
									<th >名称</th>
									<th class="hidden-xs">上级PId</th>
									<th >上级资源</th>
									<th >操作</th>
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
		layui.use(['form', 'laypage', 'jquery','layer'], function() {
			var form = layui.form(),
				layer = layui.layer,
				laypage = layui.laypage;
				$ = layui.jquery;
			
			initQuery = getUserList(laypage,1,true);
			
			$("#search").on("click",function(){
				getUserList(laypage,1,true);
			});
			
		});
		
		
		
		function getUserList(laypage,curr,_isFirst){
			var source_name = $("#source_name").val();
			var totalPages = 1;
			$.ajax({
	      	      url:basePath+'/sourceController/getSourceList.do',
	      		  type:'post',
	      		  dataType:'json',
	      		  data:{'source_name':source_name,'currpage':curr},
	      		  async:false,
	      	      success:function (res) {
	      	         console.log(res)
	      	         totalPages = res.totalPages;
	      	        if(res.resCode == 200){
	      	        	initSourceList(res.source);
	      	        }else{
	      	        	layer.msg('sdfsdf');
	      	        }
	      	      }
	  	    })
	  	    if(_isFirst){
				//分页
				laypage({
				    cont: 'email-page',
				    pages: totalPages,
				    limit: 10,
				    curr: curr,
				    layout: ['prev', 'page', 'next','limit','refresh','skip'],
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
		
		function initSourceList(source){
			$("#tbody-content").html("");
			if(source.length>0){
        		$.each(source, function(i, item){
					var sourcePid = item.sourcePid==undefined?"-":item.sourcePid;
					var source_nameP = item.source_nameP==undefined?"-":item.source_nameP;
        			var html = '<tr>';
        			html += '<td class="hidden-xs"><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>';
        				html += '		<td class="hidden-xs">'+item.id+'</td>';
     					html += '	<td >'+item.source_name+'</td>';
     					html += '	<td class="hidden-xs">'+sourcePid+'</td>';
    					html +=	'	<td >'+source_nameP+'</td>';
     					html += '	<td>';
     					html += '<div class="layui-inline">';
     					html += '<button class="layui-btn layui-btn-small layui-btn-normal addBtnXS" data-id="'+item.id+'" data-w="500px" data-h="450px" data-url="${basePath}/pageInterfaceController/toModifySourceIndex.do"><i class="layui-icon">&#xe642;</i></button>';
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