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
	<form id="modifyUserForm" class="layui-form column-content-detail">
					<div class="layui-tab">
						<div class="layui-tab-content">
							<input type="hidden" id="modify_userId" name="userId">
							<div class="layui-tab-item layui-show">
								<div class="layui-form-item">
									<label class="layui-form-label">登录名：</label>
									<div class="layui-input-block">
										<input type="text" id="modify_user_name" name="user_name" required lay-verify="required" placeholder="请输入文章标题" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">角色列表</label>
									<div class="layui-input-block">
										<select id="modify_roleId" name="roleId" lay-verify="required">
											<option value="0">启动</option>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">密码：</label>
									<div class="layui-input-block">
										<input type="password" id="modify_user_password" name="user_password" required lay-verify="required" placeholder="请输入文章标题" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">确认 密码：</label>
									<div class="layui-input-block">
										<input type="password" id="modify_user_password1" name="user_password1" required lay-verify="required" placeholder="请输入文章标题" autocomplete="off" class="layui-input">
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
	var id = '${id}';
	var form;
	layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog', 'tool', 'element', 'upload', 'layedit'], function() {
			var layer = layui.layer,
				laypage = layui.laypage,
				laydate = layui.laydate,
				layedit = layui.layedit,
				upload = layui.upload,
				tool = layui.tool,
				element = layui.element(),
				dialog = layui.dialog;
			$ = layui.jquery;
			form = layui.form();
			//获取当前iframe的name值
			var iframeObj = $(window.frameElement).attr('name');
			getUserInfo()
			form.render('select');
		});
		
	function submitUserInfo(){
		if(!validatePassword()){
			layer.msg(密码输入不一致请重新输入);
		}
		var user_name = $("#modify_user_name").val();
		var userId = $("#modify_userId").val();
		var user_password = $("#modify_user_password").val();
		var roleId = $("#modify_roleId").val();
		$.ajax({
    	      url:basePath+'/userController/updateUserInfo.do',
    		  type:'post',
    		  dataType:'json',
    		  data:{'user_name':user_name,'user_password':user_password,"roleId":roleId,"userId":userId},
    		  async:false,
    	      success:function (res) {
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
	//获取用户信息
	function getUserInfo(){
		$.ajax({
  	      url:basePath+'/userController/getUserInfo.do',
  		  type:'post',
  		  dataType:'json',
  		  data:{'id':id},
  		  async:false,
  	      success:function (res) {
  	        if(res.resCode == 200){
  	        	initUserInfo(res.user);
  	        }else{
  	        	layer.msg(res.resMsg);
  	        }
  	      }
	    })
	}
	
	function initUserInfo(user){
		$("#modify_user_name").val(user.user_name);
		$("#modify_user_password").val(user.user_password);
		$("#modify_user_password1").val(user.user_password);
		$("#modify_userId").val(user.id);
		setRoleSelect("#modify_roleId",user.roleId)
		form.render('select');
	}
	
	</script>
	</body>
</html>