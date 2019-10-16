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
	<script type="text/javascript">
		//动态添加一行
		function addRow() {
			var td1 = document.createElement("td");
			td1.innerHTML = "请选择要上传的文件：";
			var td2 = document.createElement("td");
			td2.innerHTML = "<input type=\"file\" name=\"attach\">";
			//创建tr
			var tr = document.createElement("tr");
			//添加成子元素
			tr.appendChild(td1);
			tr.appendChild(td2);
			//得到tbody对象
			var tbody = document.getElementsByTagName("tbody")[0];
			tbody.appendChild(tr);
		}
		
		//删除一行
		function delRow() {
			//得到tbody对象
			var tbody = document.getElementsByTagName("tbody")[0];
			//删除最后一个子元素
			tbody.removeChild(tbody.lastChild);
		}
	</script>
  </head>
  
  <body>
  ${msg}
    <form action="upload4" method="post"  enctype="multipart/form-data">
    <table border="1">
    	<caption>上传文件列表</caption>
    	<tbody>
    		<tr>
    			<td>请选择要上传的文件：</td>
    			<td><input type="file" name="attach"> </td>
    		</tr>
    	</tbody>
    	<tfoot>
    		<tr>
    			<td colspan="2">
    			<input type="button" value="增加" onclick="addRow()">
    			<input type="button" value="删除" onclick="delRow()">
    			<input type="submit" value="上传"> </td>
    		</tr>
    	</tfoot>
    </table>
    </form>
  </body>
</html>
