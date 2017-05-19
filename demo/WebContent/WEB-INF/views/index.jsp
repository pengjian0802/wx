<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应链日记</title>
<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="static/layui/css/modules/laydate/laydate.css" />
<link rel="stylesheet" type="text/css" href="static/layer/skin/default/layer.css" />
<script type="text/javascript" src="static/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="static/layui/layui.js"></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<script type="text/javascript" src="static/layui/lay/modules/laydate.js"></script>
<style type="text/css">
	.content{
		width: 80%;
		margin: 0 auto;
	}
</style>
<script type="text/javascript">
	function layerIframe() {
		var itemId = $("#id").val();
		layer.open({
		    type: 2,
		    title: '上传文件',
		    fixed: false, //不固定
		    maxmin: true,
		    area: ['800px', '500px'],
		    content: '/upLoadPage?itemId='+itemId,
		  });
	}
</script>
</head>
<body>
	<div class="content">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
		  <legend>供应链日记</legend>
		</fieldset>
		<form action="/save" method="post">
			<div class="layui-form-item">
	  			<label class="layui-form-label">编号</label>
			    <div class="layui-input-block">
			      <input id="id" name="id" placeholder="请输入编号" class="layui-input" type="text">
			    </div>
	  		</div>
	  		<div class="layui-form-item">
	  			<label class="layui-form-label">日记标题</label>
			    <div class="layui-input-block">
			      <input name="title" placeholder="请输入标题" class="layui-input" type="text">
			    </div>
	  		</div>
	  		<div class="layui-form-item">
	  			<label class="layui-form-label">上传</label>
	  			<input type="button" value="上传文件" onclick="layerIframe()">
	  		</div>
	  		<div class="layui-form-item">
			    <label class="layui-form-label">时间范围</label>
			    <div class="layui-input-inline">
			      <input name="startTime" class="layui-input" placeholder="开始时间" onclick="layui.laydate({elem: this, min: '1900-01-01 00:00:00', max: '2099-12-31 23:59:59',isclear: true,format: 'YYYY-MM-DD hh:mm:ss'})">
			    </div>
			    <div class="layui-form-mid">-</div>
			    <div class="layui-input-inline">
			      <input name="endTime" class="layui-input" placeholder="截止时间" onclick="layui.laydate({elem: this, min: '1900-01-01 00:00:00', max: '2099-12-31 23:59:59',isclear: true,format: 'YYYY-MM-DD hh:mm:ss'})">
			    </div>
			</div>
	  		<div class="layui-form-item">
	  			<label class="layui-form-label">地点</label>
			    <div class="layui-input-block">
			      <input name="site" style="width:600px;" placeholder="请输入地点" class="layui-input" type="text">
			    </div>
	  		</div>
	  		<div class="layui-form-item">
	  			<label class="layui-form-label">参与人员</label>
			    <div class="layui-input-block">
			      <input name="participants" style="width:600px;" placeholder="请输入参与人员" class="layui-input" type="text">
			    </div>
	  		</div>
	  		<div class="layui-form-item">
	  			<label class="layui-form-label">备注</label>
			    <div class="layui-input-block">
			      <textarea name="remarks" style="height:200px;" placeholder="请输入内容" class="layui-textarea"></textarea>
			    </div>
	  		</div>
	  		<div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" type="submit">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			 </div>
	  	</form>
	</div>
</body>
</html>