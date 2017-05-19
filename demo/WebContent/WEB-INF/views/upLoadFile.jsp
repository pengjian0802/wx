<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应链日记</title>
<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="static/layui/css/modules/laydate/laydate.css" />
<link rel="stylesheet" type="text/css" href="static/webuploader/css/webuploader.css" />
<script type="text/javascript" src="static/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="static/layui/layui.js"></script>
<script type="text/javascript" src="static/layui/lay/modules/laydate.js"></script>
<script type="text/javascript" src="static/webuploader/js/webuploader.js"></script>
<style type="text/css">
	.content{
		width: 80%;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<form class="layui-form" action="/uploaderFile" method="post" enctype="multipart/form-data">
		<input type="text" name="itemId" hidden="true" value="${itemDetailDto.itemId}">
  		<div class="layui-form-item">
  			<label class="layui-form-label">上传图片</label>
  			 <div class="layui-input-block">
				选择一个文件:
				<input type="file" name="uploadFile" />
		    </div>
  		</div>
  		<div class="layui-form-item">
  			<label class="layui-form-label">上传图片</label>
  			 <div class="layui-input-block">
				选择一个文件:
				<input type="file" name="uploadFile" />
		    </div>
  		</div>
  		<div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit="submit" lay-filter="">上传文件</button>
		      <button type="reset" class="layui-btn layui-btn-primary">取消</button>
		    </div>
		 </div>
  	</form>
</body>
</html>