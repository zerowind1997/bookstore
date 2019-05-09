﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/H-ui.admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/H-ui.admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/H-ui.admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/H-ui.admin/static/h-ui.admin/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/H-ui.admin/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户管理</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<form action="News_listDeal" method="get">
		<!-- <input type="hidden" name="oper" value="listDeal" /> -->
		<input type="hidden" name="${pagerItem.paramPageNum}" value="${pagerItem.pageNum}">
		<input type="hidden" name="${pagerItem.paramPageSize}" value="${pagerItem.pageSize}">
		<div class="text-c">
			名称： <input type="text" class="input-text" style="width: 250px"
				placeholder="输入名称" id="author" name="author" value="${author}">
			<button type="submit" class="btn btn-success radius" id="" name="">
				<i class="Hui-iconfont">&#xe665;</i> 搜用户
			</button>
			<button type="button" class="btn btn-success radius" id="clearSearch" name="">
				<i class="Hui-iconfont">&#xe665;</i> 清空
			</button>
		</div>
		</form>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="datadel()"
				class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
					批量删除</a> <a href="javascript:;"
				onclick="item_add('添加用户','News_insert','800','510')"
				class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
					添加用户</a></span> <span class="r">共有数据：<strong>${pagerItem.rowCount}</strong> 条
			</span>
		</div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg"
				id="datalist">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="80">NewsID</th>
						<th width="100">新闻作者</th>
						<th width="40">新闻标题</th>
						<th width="90">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${DataList}" var="item">
				<tr class="text-c" id="${item.newsId}">
					<td><input type="checkbox" value="${item.newsId}" name=""></td>
					<td>${item.newsId}</td>
					<td>${item.author}</td>
					<td>${item.title}</td>
					<td class="td-manage">
					<a style="text-decoration: none"
						onClick="item_del(this,${item.newsId})" href="javascript:;" title="删除" class="ml-5">
						<i class="Hui-iconfont">&#xe6e2;</i></a> 
					<a title="编辑"
						href="javascript:;"
						onclick="item_edit('编辑[id=${item.newsId}]','News_update?id=${item.newsId}','1','800','500')"
						class="ml-5" style="text-decoration: none"><i
							class="Hui-iconfont">&#xe6df;</i></a> 
						<a title="查看" href="javascript:;" 
						onclick="item_detail('查看[Id=${item.newsId}]','News_detail?id=${item.newsId}','4','800','500')"
						class="ml-5" style="text-decoration: none"><i
							class="Hui-iconfont">&#xe707;</i></a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
			<jsp:include page="../../pubview/__pager.jsp" flush="true"></jsp:include>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/H-ui.admin/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/H-ui.admin/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/H-ui.admin/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/H-ui.admin/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/H-ui.admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/H-ui.admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/H-ui.admin/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#clearSearch").click(function(){
			location.href = "News_list"
		});
	});
	
	function item_detail(title, url, id, w, h) {
		layer_show(title, url, w, h);
	}
	
	function item_edit(title, url, id, w, h) {
		layer_show(title, url, w, h);
	}
	/*删除用户-删除*/
	function item_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: 'News_deleteDeal',
				data:{
					id:id
				},
				//dataType: 'json',
				success: function(data){
					$("#"+id).remove();
					layer.msg('已删除!',{icon:1,time:1000});
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}
	//批量删除
	function datadel(){
	layer.confirm('确认要删除选中数据吗?', function(index){
		var num = 0;
		var total = 0;
		var obj = null;
		var id = 0;
		$("#datalist input[type=checkbox]:checked").each(function(){
			obj = this;
			id = $(this).val();
			
			if(id != null && id != "" && id != "0"){
				total ++;
				
				$.ajax({
					type: 'POST',
					url: 'News_deleteDeal',
					async: false,
					data: {"id": id},
					success: function(data){
						if(data=="ok"){
							$(obj).parents("tr").remove();
							num++;
						}
						else{
							
						}
					},
					error: function(data){
						
					},
				});
			}
		});
		layer.msg("要删除" + total + "行记录,成功删除" + num + "条记录", {
			icon: 1,
			time: 1000
		});
	});
}

	/*管理员-增加*/
	function item_add(title,url,w,h){
		layer_show(title,url,w,h);
	}
	</script>
</body>
</html>