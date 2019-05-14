<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/lib/html5shiv.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/H-ui.admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/H-ui.admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/H-ui.admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/H-ui.admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/H-ui.admin/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>书籍类别 ${catId}</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form action="Book_updateDeal" method="post" class="form form-horizontal" id="form-bean-edit" enctype="multipart/form-data">
	<!-- <input type="hidden" name="oper" value="updateDeal" /> -->
	<input type="hidden" name="id" value="${bean.bookId}" />
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>书籍名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${bean.bookName}" placeholder="" id="bookName" name="bookName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>书籍ISBN：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${bean.ISBN}" placeholder="" id="ISBN" name="ISBN">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>书籍价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${bean.bookPrice}" placeholder="" id="bookPrice" name="bookPrice">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>书籍折扣率：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${bean.discountRate}" placeholder="" id="discountRate" name="discountRate">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">所属类别：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="selectedCategoryName" id="selectedCategoryName">
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>书籍作者：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${bean.bookAuthor}" placeholder="" id="bookAuthor" name="bookAuthor">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>书籍库存数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" name="bookNum" id="bookNum" value="${bean.bookNum}">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>书籍图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
			<img alt="" src="${pageContext.request.contextPath }${bean.bookPicPath}"></img>
			<span class="btn-upload form-group">
				<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 修改书籍图片</a>
				<input type="file" name="headImg" class="input-file" id="input-file">
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">出版社：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="bookCbs" id="bookCbs" >
					<option value="" selected>请选择出版社</option>
					<option value="出版社1">出版社1</option>
					<option value="出版社2">出版社2</option>
					<option value="出版社3">出版社3</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">书籍简介：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="bookNote" value="" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)">${bean.bookNote}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"></label>
		<div class="formControls col-xs-8 col-sm-9">
			<span style="color: red; font-weight: bold;">${msg }</span>
		</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/lib/jquery.validation/1.14.0/additional-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/static/H-ui.admin/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	getSelected();
	getSelectedBookCbs();
	function getSelectedBookCbs()
	{
		var bookCbsSelected='';
		$("#bookCbs").html("");
		var currentBookCbs="${bean.bookCbs}"
		bookCbsSelected+='<option value="'+currentBookCbs+'">'+currentBookCbs+'</option>'
		var cbs = new Array();
		cbs[0] = "出版社1"
		cbs[1] = "出版社2"
		cbs[2] = "出版社3"
		for (i=0;i<cbs.length;i++)
		{
			if(cbs[i]!=currentBookCbs)
			bookCbsSelected+='<option value="'+cbs[i]+'">'+cbs[i]+'</option>'
		}
		$("#bookCbs").html(bookCbsSelected);
		
	}
	function getSelected()
	{
		var selectCategoryName='';
		var categoryName="${bean.bookCategory.categoryName}";
		$.ajax({
 			url:"Json_getCategoryNameList",
 			type: "POST",//发送的类型
 			dataType:"json",//返回的是json
 			success: function (data) {
 			 	var categoryNameList = data.data;
 			 	if(categoryName!=null)
 			 	{
 			 	for(var p in categoryNameList)
 			 	{
 			 		if(categoryNameList[p].categoryName==categoryName)
 			 		selectCategoryName+='<option value="'+categoryNameList[p].categoryId+'">'+categoryNameList[p].categoryName+'</option>';
 			 	}
 			 	}
 			 	selectCategoryName+='<option value="0">无</option>';
 			 	for(var p in categoryNameList)
 			 	{
 			 		if(categoryNameList[p].categoryName!=categoryName)
 			 		selectCategoryName+='<option value="'+categoryNameList[p].categoryId+'">'+categoryNameList[p].categoryName+'</option>';
 			 	}
 			 	$("#selectedCategoryName").html(selectCategoryName);
 			 	
 			 }
 		})
	}
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-bean-edit").validate({
		rules:{
			userName:{
				required: true
			}
			, nickName:{
				required: true
			}
		},
		messages:{
			userName:{
				required: "用户名不能为空"
			}
			, nickName:{
				required: "用户昵称不能为空"
			}
		},
		onkeyup: false,
		focusCleanup: true,
		success: "valid",
		submitHandler: function(form){
			form.submit();
		}
	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>