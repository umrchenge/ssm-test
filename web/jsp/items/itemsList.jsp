<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
	<script type="text/javascript">
		function deleteItems() {
			document.itemsForm.action = "<c:url value='/items/deleteItems.action'/>";
            //提交表单
            document.itemsForm.submit();
        }

        function queryItems() {
            document.itemsForm.action = "<c:url value='/items/queryItems.action'/>";
            //提交表单
            document.itemsForm.submit();

        }
	</script>
</head>
<body>
当前用户:${username}<a href="/logout.action">退出</a>
<form name="itemsForm" action="<c:url value="/items/queryItems.action"/>" method="post">
查询条件：
<table width="100%" border=1>
	<tr>
		<td>商品名称：<input name="itemsCustom.name" type="text"/></td>
		<td>
			<input type="button" value="查询" onclick="queryItems()"/>
			<input type="button" onclick="deleteItems()" value="批量删除"/>
		</td>
	</tr>
</table>
商品列表：
<table width="100%" border=1 style="text-align: center">
<tr>
	<td>请选择</td>
	<td>商品名称</td>
	<td>商品类型</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemsList }" var="item">
<tr>
	<td><input type="checkbox" name="items_id" value="${item.id}"/></td>
	<td>${item.name }</td>
	<td>
		<select name="itemtype">
			<c:forEach items="${itemtypes }" var="itemtype">
				<option value="${itemtype.key }">${itemtype.value }</option>
			</c:forEach>
		</select>
	</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
	
	<td><a href="<c:url value="/items/editItems.action?id=${item.id}"/>">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>