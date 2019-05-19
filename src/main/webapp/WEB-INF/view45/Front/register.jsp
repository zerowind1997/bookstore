<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/one/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="${pageContext.request.contextPath}/static/one/css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/static/one/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/one/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>

	<body>

		<div class="login-boxtitle">
			<a href="home/demo.html"><img alt="" src="${pageContext.request.contextPath}/static/one/images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="${pageContext.request.contextPath}/static/one/images/big.jpg" /></div>
				<div class="login-box">

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-active">
									<form method="post" action="FrontLogin_registerDeal">
										
							   <div class="user-email">
										<label for="email"><i class="am-icon-envelope-o"></i></label>
										<input type="text" name="userId" id="userId" placeholder="请输入账号">
                 </div>				
                   <div class="user-email">
										<label for="email"><i class="am-icon-code-fork"></i></label>
										<input type="text" name="userNick" id="userNick" placeholder="请输入昵称">
                 </div>		
                    <div class="user-email">
										<label for="email"><i class="am-icon-envelope-o"></i></label>
										<input type="email" name="email" id="email" placeholder="请输入邮箱账号">
                 </div>	
                 <div class="user-phone">
								    <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
								    <input type="tel" name="phone" id="phone" placeholder="请输入手机号">
                 </div>														
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="userPass" id="userPass" placeholder="设置密码">
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password" name="checkPass" id="checkPass" placeholder="确认密码">
                 </div>	
                   <div class="am-cf">
											<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
					</div>
                 </form>
                 
								 <div class="login-links">
										<label for="reader-me">
											${msg}
										</label>
							  	</div>
										

								</div>

								<script>
									$(function() {
									    
									  })
								</script>

							</div>
						

				</div>
			</div>
			
					<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# ">恒望科技</a>
								<b>|</b>
								<a href="# ">商城首页</a>
								<b>|</b>
								<a href="# ">支付宝</a>
								<b>|</b>
								<a href="# ">物流</a>
							</p>
						</div>
						<div class="footer-bd ">
							<p>
								<a href="# ">关于恒望</a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# ">网站地图</a>
								<em>© 2015-2025 Hengwang.com 版权所有</em>
							</p>
						</div>
					</div>
	</body>

</html>