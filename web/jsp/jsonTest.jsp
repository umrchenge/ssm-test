<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: UMR丶晨哥
  Date: 2018/12/11
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json数据交互测试</title>
    <script src="<c:url value="/js/jquery-3.3.1.js"/>"></script>
    <script type="text/javascript">
        // 请求Json输出Json
       function requestJson(){
            $.ajax({
               type:'post',
                url:'<c:url value="/jsonTest/requestJson.action"/>',
                contentType:'application/json;charset=utf-8',
                data:'{"name":"手机","price":999}',
                success:function (data) {
                    alert(data.name);
                }
            });
       }
       //请求Key/value输出Json
       function responseJson() {
           $.ajax({
               type:'post',
               url:'<c:url value="/jsonTest/responseJson.action"/>',
               // contentType:'application/json;charset=utf-8',
               data:'name=手机&price=999',
               success:function (data) {
                   alert(data.name);
               }
           });
       }

    </script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求Json输出Json"/>
<input type="button" onclick="responseJson()" value="请求Key/value输出Json"/>

</body>
</html>
