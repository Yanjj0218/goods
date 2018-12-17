<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>登录</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/sign-up-login.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/inputEffect.css" />
<link rel="stylesheet" href="css/tooltips.css" />
<link rel="stylesheet" href="css/spop.min.css" />

<script src="js/jquery.min.js"></script>
<script src="js/snow.js"></script>
<script src="js/jquery.pure.tooltips.js"></script>
<script src="js/spop.min.js"></script>
</head>
<style type="text/css">
html{width: 100%; height: 100%;}

body{

	background-repeat: no-repeat;

	background-position: center center #2D0F0F;

	background-color: #00BDDC;

	background-image: url(images/snow.jpg);

	background-size: 100% 100%;

}

.snow-container { position: fixed; top: 0; left: 0; width: 100%; height: 100%; pointer-events: none; z-index: 100001; }

</style>
</head>
<body>
<!-- 雪花背景 -->
	<div class="snow-container"></div>
	<div id="login">
		<input id="tab-1" type="radio" name="tab" class="sign-in hidden" checked />
		<input id="tab-2" type="radio" name="tab" class="sign-up hidden" />
		<input id="tab-3" type="radio" name="tab" class="sign-out hidden" />
		
		<div class="wrapper">
<!-- 快捷登录页面 -->
			<div class="login sign-in-htm">
				<form class="container offset1 loginform">
					<!-- 猫头鹰控件 -->
					<div id="owl-login" class="login-owl">
						<div class="hand"></div>
						<div class="hand hand-r"></div>
						<div class="arms">
							<div class="arm"></div>
							<div class="arm arm-r"></div>
						</div>
					</div>
					<div class="pad input-container">
						<section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="Quicklogin-username" 
									autocomplete="off" placeholder="请输入手机号" tabindex="1" maxlength="15" />
								<label class="input__label input__label--hideo" for="Quicklogin-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="Quicklogin-yzpassword" placeholder="请输入验证码" tabindex="2" maxlength="15"/>
								<label class="input__label input__label--hideo" for="login-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<input class="btn btn-primary" type="button" tabindex="3" onClick="getRandom()" value="获取验证码" 
							style="color:white;"/>
						</section>
					</div>
					<div class="form-actions">
						<a tabindex="4" class="btn pull-left btn-link text-muted" onClick="goto_forget()">忘记密码?</a>
						<a tabindex="5" class="btn btn-link text-muted" onClick="goto_register()">注册</a>
						<input class="btn btn-primary" type="button" tabindex="3" onClick="Quicklogin()" value="登录" 
							style="color:white;"/>
					</div>
				</form>
			</div>
			<div style="text-align:center;"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function getRandom(){
		$.ajax({
			url:'<%=request.getContextPath()%>/user/sendRandom.do',
			type:'post',
			data:{
				loginNumber:$("#Quicklogin-username").val(),
				randomNum:$('#Quicklogin-yzpassword').val()
			},
			dataType:'json',
			success:function(result){
				if(result.code != 0){
					alert(result.msg);
				}else{
					alert(result.msg);
				}
			}
		})
	}
	
	
	function Quicklogin(){
		$.ajax({
			url:'../user/Quicklogin.do',
			type:'post',
			data:{
				loginNumber:$("#Quicklogin-username").val(),
				yzRandom:$('#Quicklogin-yzpassword').val()
			},
			dataType:'json',
			success:function(result){
				if(result.code != 0){
					alert(result.msg);
				}else{
					window.location.href="../nav/toMain.do";
				}
			}
		})
	}
</script>


</html>