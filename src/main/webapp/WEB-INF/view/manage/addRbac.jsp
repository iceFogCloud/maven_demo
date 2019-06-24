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
		<link href="${basePath}/miniui/css/demo.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<form id="addUserForm" class="layui-form column-content-detail">
					<div class="layui-tab">
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
								<div class="layui-form-item">
									<label class="layui-form-label">资源列表：</label>
									<div class="layui-input-block">
										<div id="tree1" class="mini-tree" url="${basePath}/rbacController/getUserRbacInfoTree.do" style="width:300px;padding:5px;" 
						                    showTreeIcon="false" textField="text" idField="id" value="base" expandOnNodeClick="true">        
						                </div>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">角色名：</label>
									<div class="layui-input-block">
										<input type="text" id="add_role_name" name="role_name" required lay-verify="required" placeholder="请输入文章标题" autocomplete="off" class="layui-input">
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
	<script src="${basePath}/miniui/js/boot.js" type="text/javascript"></script>
	<script>
	var basePath = '${basePath}';
	var $;
	layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog', 'tool', 'element', 'upload','tree'], function() {
			var form = layui.form(),
				layer = layui.layer,
				laypage = layui.laypage,
				laydate = layui.laydate,
				upload = layui.upload,
				tree = layui.tree,
				tool = layui.tool,
				element = layui.element(),
				dialog = layui.dialog;
			$ = layui.jquery;
			//获取当前iframe的name值
			var iframeObj = $(window.frameElement).attr('name');
			
			
			inintTree(true)
			
		});
		
	function submitUserInfo(){
		var tree = mini.get("tree1");
		debugger;
        var sourceIds = tree.getCheckedNodesId();
		var role_name = $("#add_role_name").val();
		$.ajax({
    	      url:basePath+'/rbacController/insertRbacInfo.do',
    		  type:'post',
    		  dataType:'json',
    		  data:{'role_name':role_name,'sourceIds':sourceIds},
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
	
	function getSelectedValue(node){
		var selectedIds = '';
		if(node.length>0){
			for(var k=0;k<node.length;k++){
				selectedIds += node[k].id + ',';
				var childrend = node[k].children;
				if(childrend!=undefined&&childrend.length>0){
					for(var p=0;p<childrend.length;p++){
						selectedIds += childrend[p].id+',';
					}
				}
			}
		}
		return selectedIds;
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
	
	function inintTree(checked){
	  	var tree = mini.get("tree1");
        tree.setShowCheckBox(checked);
        tree.setShowExpandButtons(checked);
        tree.setShowTreeIcon(!checked);
	}
	</script>
	</body>
</html>