<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>网站后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/static/admin/css/admin.css"/>
	</head>
	<body>
	<form id="addUserForm" class="layui-form column-content-detail">
					<div class="layui-tab">
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
								<div class="layui-form-item">
									<label class="layui-form-label">登录名：</label>
									<div class="layui-input-block">
										<input type="text" id="add_user_name" name="user_name" required lay-verify="required" placeholder="请输入文章标题" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">角色列表</label>
									<div class="layui-input-block">
										<select id="add_roleId" name="roleId" lay-verify="required">
											<option value="0">启动</option>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">密码：</label>
									<div class="layui-input-block">
										<input type="password" id="add_user_password" name="user_password" required lay-verify="required" placeholder="请输入文章标题" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">确认 密码：</label>
									<div class="layui-input-block">
										<input type="password" id="add_user_password1" name="user_password1" required lay-verify="required" placeholder="请输入文章标题" autocomplete="off" class="layui-input">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-form-item" style="padding-left: 10px;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-normal" type="button" onclick="submitUserInfo()">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
	<script src="${basePath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	<script>
	var basePath = '${basePath}';
	var $;
	layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog', 'tool', 'element', 'upload', 'layedit'], function() {
			var form = layui.form(),
				layer = layui.layer,
				laypage = layui.laypage,
				laydate = layui.laydate,
				layedit = layui.layedit,
				upload = layui.upload,
				tool = layui.tool,
				element = layui.element(),
				dialog = layui.dialog;
			$ = layui.jquery;

			//获取当前iframe的name值
			var iframeObj = $(window.frameElement).attr('name');
			
			setRoleSelect("#add_roleId",null);
			form.render('select');
		});
		
	function submitUserInfo(){
		if(!validatePassword()){
			layer.msg(密码输入不一致请重新输入);
		}
		var user_name = $("#add_user_name").val();
		var user_password = $("#add_user_password").val();
		var roleId = $("#add_roleId").val();
		$.ajax({
    	      url:basePath+'/userController/insertUserInfo.do',
    		  type:'post',
    		  dataType:'json',
    		  data:{'user_name':user_name,'user_password':user_password,"roleId":roleId},
    		  async:false,
    	      success:function (res) {
    	         console.log(res)
    	         totalPages = res.totalPages;
    	        if(res.resCode == 200){
    	        	layer.msg(res.resMsg,{
                        icon: 6,
                        time: 800 //2秒关闭（如果不配置，默认是3秒）
                      }, function(){
                          setTimeout(function(){ 
                          			window.parent.refresh();},150);
                      });
    	        }else{
    	        	layer.msg(res.resMsg);
    	        }
    	      }
	    })
	}
	
	function validatePassword(){
		var add_user_password = $("#add_user_password").val();
		var add_user_password1 = $("#add_user_password1").val()
		if(add_user_password==add_user_password1){
			return true;
		}else{
			return false;
		}
	}
	
	function setRoleSelect(selectId,roleId){
		$.ajax({
  	      url:basePath+'/rbacController/getRoleSelectList.do',
  		  type:'post',
  		  dataType:'json',
  		  async:false,
  	      success:function (res) {
  	    	$(selectId).html('');
  	        if(res.resCode == 200){
  	        	var html = '';
  	        	$.each(res.role, function(i, item){
  	        		if(item.id==roleId){
  	        			html +=' <option value="'+item.id+'" selected="selected">'+item.role_name+'</option>'
  	        		}else{
  	        			html +=' <option value="'+item.id+'" >'+item.role_name+'</option>'
  	        		}
  	        	})
  	        	$(selectId).html(html);
  	        }else{
  	        	layer.msg(res.resMsg);
  	        }
  	      }
	    })
	}
	
	
	</script>
	</body>
</html>