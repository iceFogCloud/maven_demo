<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- Head -->
<head>
    <title>后台管理页面登录</title>
    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="Existing Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">


    <link href="${basePath}/css/login/popuo-box.css" rel="stylesheet" type="text/css" media="all" />

    <!-- Style -->
    <link rel="stylesheet" href="${basePath}/css/login/style.css" type="text/css" media="all">


</head>
<!-- //Head -->
<!-- Body -->
<body >

    <h1>管理登录</h1>


    <div class="w3layoutscontaineragileits">
        <h2>欢迎使用后台管理系统</h2>
        <form >
            <input type="text" id="user_name" name="user_name" placeholder="USERNAME" required>
            <input type="password" id="user_password" name="user_password" placeholder="PASSWORD" required>
            <ul class="agileinfotickwthree">
                <li>
                    <input type="checkbox" id="brand1" value="">
                    <label for="brand1"><span></span>记住</label>
                    <a href="#">忘记密码?</a>
                </li>
            </ul>
            <div class="aitssendbuttonw3ls">
                <input type="button" onclick="login()" value="登录">
                <p> 注册一个新账户 <span>→</span> <a class="w3_play_icon1" href="#small-dialog1"> 点击这里</a></p>
                <div class="clear"></div>
            </div>
        </form>
    </div>

    <!-- for register popup -->
    <div id="small-dialog1" class="mfp-hide">
        <div class="contact-form1">
            <div class="contact-w3-agileits">
                <h3>注册表单</h3>
                <form action="#" method="post">
                    <div class="form-sub-w3ls">
                        <input placeholder="User Name" type="text" required>
                        <div class="icon-agile">
                            <i class="fa fa-user" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="form-sub-w3ls">
                        <input placeholder="Email" class="mail" type="email" required>
                        <div class="icon-agile">
                            <i class="fa fa-envelope-o" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="form-sub-w3ls">
                        <input placeholder="Password" type="password" required>
                        <div class="icon-agile">
                            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="form-sub-w3ls">
                        <input placeholder="Confirm Password" type="password" required>
                        <div class="icon-agile">
                            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="login-check">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked="">I Accept Terms & Conditions</label>
                    </div>
                    <div class="submit-w3l">
                        <input type="submit" value="Register">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- //for register popup -->

    <div class="w3footeragile">
        <p> &copy; 2019 All Rights Reserved | Design by </p>
    </div>



    <script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>

    <!-- pop-up-box-js-file -->
    <script src="${basePath}/js/login/jquery.magnific-popup.js" type="text/javascript"></script>
    <!--//pop-up-box-js-file -->
    <script>
    	var basePath = '${basePath}';
        $(document).ready(function () {
            $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
                type: 'inline',
                fixedContentPos: false,
                fixedBgPos: true,
                overflowY: 'auto',
                closeBtnInside: true,
                preloader: false,
                midClick: true,
                removalDelay: 300,
                mainClass: 'my-mfp-zoom-in'
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
        	        }
        	      }
        	    })
        }
    </script>

</body>
 
</html>
