<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>后台登录</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/static/admin/css/login.css" />
	</head>
	
	<script>
	    //页面加载时，生成随机验证码
	    window.onload=function(){
	     createCode(4);    
	    }
	
	    //生成验证码的方法
	    function createCode(length) {
	        var code = "";
	        var codeLength = parseInt(length); //验证码的长度
	        var checkCode = document.getElementById("checkCode");
	        ////所有候选组成验证码的字符，当然也可以用中文的
	        var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
	        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
	        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); 
	        //循环组成验证码的字符串
	        for (var i = 0; i < codeLength; i++)
	        {
	            //获取随机验证码下标
	            var charNum = Math.floor(Math.random() * 62);
	            //组合成指定字符验证码
	            code += codeChars[charNum];
	        }
	        if (checkCode)
	        {
	            //为验证码区域添加样式名
	            checkCode.className = "code";
	            //将生成验证码赋值到显示区
	            checkCode.innerHTML = code;
	        }
	    }
	    
	    //检查验证码是否正确
	    function validateCode()
	    {
	        //获取显示区生成的验证码
	        var checkCode = document.getElementById("checkCode").innerHTML;
	        //获取输入的验证码
	        var inputCode = document.getElementById("inputCode").value;
	        console.log(checkCode);
	        console.log(inputCode);
	        if (inputCode.length <= 0)
	        {
	            alert("请输入验证码！");
	        }
	        else if (inputCode.toUpperCase() != checkCode.toUpperCase())
	        {
	            alert("验证码输入有误！");
	            createCode(4);
	        }
	        else
	        {
	            alert("验证码正确！");
	        }       
	    }    
	</script>
	<body>
		<div class="m-login-bg">
			<div class="m-login">
				<h3>后台系统登录</h3>
				<div class="m-login-warp">
					<form class="layui-form">
						<div class="layui-form-item">
							<input type="text" id="user_name" name="title" required lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-item">
							<input type="password" id="user_password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-item">
							<div class="layui-inline">
								<input type="text" id="inputCode" name="verity" required lay-verify="required"  placeholder="验证码" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline">
								<div id="checkCode" class="verifyImg" style="font-family: Arial;font-style: italic;color: blue;font-size: 30px;border: 0;padding: 2px 3px;letter-spacing: 3px;font-weight: bolder;cursor: pointer;width: 120px;height: 50px;line-height: 50px;text-align: center;vertical-align: middle;background-color: #D8B7E3;"  onclick="createCode(4)" ></div>
								<!-- <img id="checkCode" class="verifyImg" onclick="createCode(4)" src="static/admin/images/login/yzm.jpg" /> -->
							</div>
						</div>
						<div class="layui-form-item m-login-btn">
							<div class="layui-inline">
								<button class="layui-btn layui-btn-normal" type="button" onclick = "login()">登录</button>
							</div>
							<div class="layui-inline">
								<button type="reset" class="layui-btn layui-btn-primary">取消</button>
							</div>
						</div>
					</form>
				</div>
				<p class="copyright">Copyright 2015-2016 by XIAODU</p>
			</div>
		</div>
		<script src="${basePath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script>
			var basePath = '${basePath}';
			layui.use(['form', 'layedit', 'laydate'], function() {
				var form = layui.form(),
					layer = layui.layer;


				//自定义验证规则
				form.verify({
					title: function(value) {
						if(value.length < 5) {
							return '标题至少得5个字符啊';
						}
					},
					password: [/(.+){6,12}$/, '密码必须6到12位'],
					verity: [/(.+){6}$/, '验证码必须是6位'],
					
				});

			});
			
			function login(){
				var user_name = $("#user_name").val();
	        	var user_password = $("#user_password").val();
	        	$.ajax({
	        	      url:basePath+'/loginController/login.do',
	        		  type:'post',
	        		  dataType:'json',
	        		  data:{'user_name':user_name,'user_password':user_password},
	        		  async:false,
	        	      success:function (res) {
	        	         console.log(res)
	        	        if(res.resCode == 200){
	        	        	var url = basePath + res.redirectUrl;
	        	        	window.location.href = url;
	        	        }else{
							layer.alert('用户名或者密码错误', {
								title: '提示信息'
							})
	        	        }
	        	      }
	        	    })
			}
		</script>
	</body>

</html>