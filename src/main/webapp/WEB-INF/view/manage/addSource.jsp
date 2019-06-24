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
	<form id="addSourceForm" class="layui-form column-content-detail">
					<div class="layui-tab">
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
								<div class="layui-form-item">
									<label class="layui-form-label">上级目录：</label>
									<div class="layui-input-block">
										<select id="add_source_pId" name="source_pId" lay-filter="pid" lay-verify="required">
											<option value="0">root</option>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">资源名：</label>
									<div class="layui-input-block">
										<input type="text" id="add_source_name" name="source_name" required lay-verify="required" placeholder="请输入资源名" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">资源链接：</label>
									<div class="layui-input-block">
										<input type="text" id="add_source_url" name="source_url" required lay-verify="required" placeholder="请输入资源链接" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">资源图标：</label>
									<div class="layui-input-block">
										<input type="text" id="add_source_icon" name="source_icon" required lay-verify="required" placeholder="请输入资源图标" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">资源排序：</label>
									<div class="layui-input-block">
										<input type="number" id="add_source_order" name="source_order" required lay-verify="required" placeholder="请输入资源排序" autocomplete="off" class="layui-input">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-form-item" style="padding-left: 10px;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-normal" type="button" onclick="submitSourceInfo()">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
	<script src="${basePath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	<script>
	var basePath = '${basePath}';
	var $;
	var data = {
			selectId:''
	}
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
			
			setSourcePId("#add_source_pId",null);
			form.render("select");
			form.on('select(pid)',function(selectData){
				console.log(selectData)
				data.selectId = selectData.value;
				console.log(data.selectId)
			});
			
		});
	
	function setSourcePId(demoId,sourceId){
		$.ajax({
  	      url:basePath+'/sourceController/getSourceSelectList.do',
  		  type:'post',
  		  dataType:'json',
  		  async:false,
  	      success:function (res) {
  	        if(res.resCode == 200){
  	        	var source = res.source;
  	        	initSourceSelect(source,demoId,sourceId);
  	        }else{
  	        	layer.msg(res.resMsg);
  	        }
  	      }
	    })
	}
	
	//初始化资源信息
	function initSourceSelect(source,demoId,sourceId){
		$(demoId).html("");
		if(source.length>0){
			var html = '<option value="0">root</option>';
			$.each(source, function(i, item){
				if(item.sourceId==sourceId){
					html += '<option value="'+item.sourceId+'" selected="selected" >'+item.source_name+'</option>'
				}else{
					html += '<option value="'+item.sourceId+'">'+item.source_name+'</option>'
				}
			});
			$(demoId).html(html);
		}else{
			$(demoId).html('<option value="0">root</option>');
		}
	}
	
	
	function submitSourceInfo(){
		var formData = $("#addSourceForm").serialize();
		$.ajax({
    	      url:basePath+'/sourceController/insertSourceInfo.do',
    		  type:'post',
    		  dataType:'json',
    		  data:formData,
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
	
	</script>
	</body>
</html>