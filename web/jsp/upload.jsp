<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: UMR丶晨哥
  Date: 2018/12/15
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="align-content: center">
    <form action="<c:url value="/upload.action"/>" method="post"  enctype="multipart/form-data">
        上传文件：<input name="fileUpload" type="file"/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
