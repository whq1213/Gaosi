<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加</title>
</head>
<body>
<sf:form method="post"  enctype="multipart/form-data" accept-charset="UTF-8">
<table width="700" align="center" border="1">
	<tr>
	 <td>请输入模糊半径:</td><td><input type="text" name="text"/></td>
	</tr>
	<tr>
	 <td>请输入图片:</td><td><input type="file" name="attach"/></td>
	</tr>
	<tr>
	<td colspan="2">
		 <input type="submit" value="提交"/>
	</td>
	</tr>
</table>
<c:if test="${not empty pat}">
	<table width="700" align="center" border="1">
		<tr>
		<td>原图:</td>
		<td><img src="${pat}" alt="Big Boat"></td>		

		<td>效果图:</td>
		<td><img src="\upload\2.jpg" alt="Big Boat"></td>	
		</tr>
	</table>
	
</c:if>
</sf:form>
</body>
</html>

