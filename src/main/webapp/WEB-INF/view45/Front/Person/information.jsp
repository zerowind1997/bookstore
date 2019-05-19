<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>个人资料</title>

<link
	href="${pageContext.request.contextPath}/static/one/AmazeUI-2.4.2/assets/css/admin.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/static/one/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css">

<link
	href="${pageContext.request.contextPath}/static/one/css/personal.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/static/one/css/infstyle.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/static/one/AmazeUI-2.4.2/assets/js/jquery.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/one/AmazeUI-2.4.2/assets/js/amazeui.js"
	type="text/javascript"></script>

</head>

<body>
	<!--头 -->
	<header>
		<article>
			<div class="mt-logo">
				<!--顶部导航条 -->
				<div class="am-container header">
					<ul class="message-l">
						<div class="topMessage">
							<div class="menu-hd">
								<a href="#" target="_top" class="h">亲，请登录</a> <a href="#"
									target="_top">免费注册</a>
							</div>
						</div>
					</ul>
					<ul class="message-r">
						<div class="topMessage home">
							<div class="menu-hd">
								<a href="#" target="_top" class="h">商城首页</a>
							</div>
						</div>
						<div class="topMessage my-shangcheng">
							<div class="menu-hd MyShangcheng">
								<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
							</div>
						</div>
						<div class="topMessage mini-cart">
							<div class="menu-hd">
								<a id="mc-menu-hd" href="#" target="_top"><i
									class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
									id="J_MiniCartNum" class="h">0</strong></a>
							</div>
						</div>
						<div class="topMessage favorite">
							<div class="menu-hd">
								<a href="#" target="_top"><i
									class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
							</div>
					</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logoBig">
						<li><img
							src="${pageContext.request.contextPath}/static/one/images/logobig.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form>
							<input id="searchInput" name="index_none_header_sysc" type="text"
								placeholder="搜索" autocomplete="off"> <input
								id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
								type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			</div>
		</article>
	</header>
	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
		<div class="nav-cont">
			<ul>
				<li class="index"><a href="#">首页</a></li>
				<li class="qc"><a href="#">闪购</a></li>
				<li class="qc"><a href="#">限时抢</a></li>
				<li class="qc"><a href="#">团购</a></li>
				<li class="qc last"><a href="#">大包装</a></li>
			</ul>
			<div class="nav-extra">
				<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利 <i
					class="am-icon-angle-right" style="padding-left: 10px;"></i>
			</div>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">

				<div class="user-info">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small>
						</div>
					</div>
					<hr />

					

					<!--个人信息 -->
					<div class="info-main">
						<form class="am-form am-form-horizontal" method="post" action="Personal_informationUpdate">
							<input type="hidden" id="user-name2"
										value="${loginCustomer.id }" name="id"
										id="id">
							<div class="am-form-group">
								<label for="user-name2" class="am-form-label">账号</label>
								<div class="am-form-content">
									<input type="text" id="user-name2"
										value="${loginCustomer.userId }" name="userId"
										id="userId">
								</div>
							</div>
							
							<div class="am-form-group">
								<label for="user-name2" class="am-form-label">昵称</label>
								<div class="am-form-content">
									<input type="text" id="user-name2"
										value="${loginCustomer.userNick }" name="userNick"
										id="userNick">
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-name" class="am-form-label">邮箱</label>
								<div class="am-form-content">
									<input type="email" id="user-name2"
										value="${loginCustomer.email }" name="email">

								</div>
							</div>

							<div class="am-form-group">
								<label for="user-name" class="am-form-label">电话</label>
								<div class="am-form-content">
									<input type="tel" id="user-name2"
										value="${loginCustomer.phone }" name="phone" id="phone">
								</div>
							</div>

						
							<div class="am-form-group">
								<label for="user-phone" class="am-form-label">收获地址</label>
								<div class="am-form-content">
									<input id="user-phone" placeholder="telephonenumber" type="text" name="address" id="address" disabled="true" value="${loginCustomer.address }">

								</div>
							</div>
							<div class="am-form-group">
								<label for="user-phone" class="am-form-label">${msg}</label>
							</div>
							<div class="am-form-group address">
								<label for="user-address" class="am-form-label">收货地址</label>
								<div class="am-form-content address">
									<a href="address.html">
										<p class="new-mu_l2cw">
											<span class="province">湖北</span>省 <span class="city">武汉</span>市
											<span class="dist">洪山</span>区 <span class="street">雄楚大道666号(中南财经政法大学)</span>
											<span class="am-icon-angle-right"></span>
										</p>
									</a>

								</div>
							</div>
							<div class="am-form-group safety">
								<label for="user-safety" class="am-form-label">账号安全</label>
								<div class="am-form-content safety">
									<a href="safety.html"> <span class="am-icon-angle-right"></span>

									</a>

								</div>
							</div>
							<div class="info-btn">
								<input type="submit" class="am-btn am-btn-danger" value="保存修改"></input>
							</div>

						</form>
					</div>

				</div>

			</div>
			<!--底部-->
			<div class="footer">
				<div class="footer-hd">
					<p>
						<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
							href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
					</p>
				</div>
				<div class="footer-bd">
					<p>
						<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
							href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有</em>
					</p>
				</div>
			</div>
		</div>

		<aside class="menu">
			<ul>
				<li class="person"><a href="index.html">个人中心</a></li>
				<li class="person"><a href="#">个人资料</a>
					<ul>
						<li class="active"><a href="information.html">个人信息</a></li>
						<li><a href="safety.html">安全设置</a></li>
						<li><a href="address.html">收货地址</a></li>
					</ul></li>
				<li class="person"><a href="#">我的交易</a>
					<ul>
						<li><a href="order.html">订单管理</a></li>
						<li><a href="change.html">退款售后</a></li>
					</ul></li>
				<li class="person"><a href="#">我的资产</a>
					<ul>
						<li><a href="coupon.html">优惠券 </a></li>
						<li><a href="bonus.html">红包</a></li>
						<li><a href="bill.html">账单明细</a></li>
					</ul></li>

				<li class="person"><a href="#">我的小窝</a>
					<ul>
						<li><a href="collection.html">收藏</a></li>
						<li><a href="foot.html">足迹</a></li>
						<li><a href="comment.html">评价</a></li>
						<li><a href="news.html">消息</a></li>
					</ul></li>

			</ul>

		</aside>
	</div>

</body>

</html>