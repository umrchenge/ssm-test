<%--
  Created by IntelliJ IDEA.
  User: UMR丶晨哥
  Date: 2018/12/11
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<center>
    错误信息：${message}<br/>
    状态码：${pageContext.response.status}<br/>
    用户ip:${pageContext.request.remoteHost}<br/>
    端口：${pageContext.request.remotePort}<br/>
    不知名的东西：${pageContext.request.remoteAddr}<br/>
</center>

</body>
</html>
