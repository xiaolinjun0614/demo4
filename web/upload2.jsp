<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	${msg}
    <form action="upload4" method="post"  enctype="multipart/form-data">
    	名字：<input type="text" name="user"/> <br/>
    	照片：<input type="file" name="attach"  accept="image/*"> <br/>
    	<input type="submit" value="上传"> 
    </form>
  </body>
</html>
