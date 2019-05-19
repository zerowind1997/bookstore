<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>书本类别管理</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		用户中心 <span class="c-gray en">&gt;</span> 管理员管理 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<form action="Customer_listDeal" method="get">
			<input
				type="hidden" name="${pagerItem.paramPageNum}"
				value="${pagerItem.pageNum}"> <input type="hidden"
				name="${pagerItem.paramPageSize}" value="${pagerItem.pageSize}">

			<div class="text-c">
				名称： <input type="text" class="input-text" style="width: 250px"
					placeholder="输入用户昵称" id="userNick" name="userNick"
					value="${userNick}">
				<button type="submit" class="btn btn-success radius" id="" name="">
					<i class="Hui-iconfont">&#xe665;</i> 搜用户昵称
				</button>
				<button type="button" class="btn btn-success radius"
					id="clearSearch" name="">
					<i class="Hui-iconfont">&#xe665;</i> 清空
				</button>
			</div>
		</form>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-bg " id="datalist">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="80">用户ID</th>
						<th width="80">用户登入账号</th>
						<th width="80">用户昵称</th>
						<th width="80">用户邮箱</th>
						<th width="80">用户电话</th>
						<th width="80">用户地址</th>
						<th width="80">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${DataList}" var="item">
				<tr class="text-c" id="${item.id}">
					<td><input type="checkbox" value="${item.id}" name=""></td>
					<td>${item.id}</td>
					<td>${item.userId}</td>
					<td>${item.userNick}</td>
					<td>${item.email}</td>
					<td>${item.phone}</td>
					<td>${item.address}</td>
					<td class="td-manage">
					<a title="重置密码"
						href="javascript:;"
						onclick="item_detail('Json_updateUserPassword','${item.id}')"
						class="ml-5" style="text-decoration: none"><i
							class="Hui-iconfont">&#xe6df;</i></a> 
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
		$(function() {
			
			$('.table-sort').dataTable({
				"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
				"bStateSave" : true,//状态保存
				"aoColumnDefs" : [
				//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				{
					"orderable" : false,
					"aTargets" : [ 0, 8, 9 ]
				} // 制定列不参与排序
				]
			});
			$("#clearSearch").click(function(){
				location.href = "Customer_list"
			});

		});
		/*用户-添加*/
		function item_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-查看*/
		function BookCategory_show(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		function item_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户更新*/
		function item_detail(url, id,status) {
			//alert(url+id);
			$.ajax({
				type: 'POST',
				url: url,
				data:{
					id:id
				},
				success: function(data){
					layer.msg('已重置!',{icon:1,time:1000});
					setTimeout(function () {
	                    window.location.reload();
	                }, 1000);
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
			
		}
		
		/*用户-停用*/
		function BookCategory_stop(obj, id) {
			layer
					.confirm(
							'确认要停用吗？',
							function(index) {
								$
										.ajax({
											type : 'POST',
											url : '',
											dataType : 'json',
											success : function(data) {
												$(obj)
														.parents("tr")
														.find(".td-manage")
														.prepend(
																'<a style="text-decoration:none" onClick="BookCategory_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
												$(obj)
														.parents("tr")
														.find(".td-status")
														.html(
																'<span class="label label-defaunt radius">已停用</span>');
												$(obj).remove();
												layer.msg('已停用!', {
													icon : 5,
													time : 1000
												});
											},
											error : function(data) {
												console.log(data.msg);
											},
										});
							});
		}

		/*用户-启用*/
		function BookCategory_start(obj, id) {
			layer
					.confirm(
							'确认要启用吗？',
							function(index) {
								$
										.ajax({
											type : 'POST',
											url : '',
											dataType : 'json',
											success : function(data) {
												$(obj)
														.parents("tr")
														.find(".td-manage")
														.prepend(
																'<a style="text-decoration:none" onClick="BookCategory_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
												$(obj)
														.parents("tr")
														.find(".td-status")
														.html(
																'<span class="label label-success radius">已启用</span>');
												$(obj).remove();
												layer.msg('已启用!', {
													icon : 6,
													time : 1000
												});
											},
											error : function(data) {
												console.log(data.msg);
											},
										});
							});
		}
		/*用户-编辑*/
		function BookCategory_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*密码-修改*/
		function change_password(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*删除用户-删除*/
	function item_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: 'Manager_deleteDeal',
				data:{
					id:id
				},
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
						url: 'Manager_deleteDeal',
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
	</script>
</body>
</html>