<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-02-25
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>


<form action="/login" method="post">
    用户名:<input type="text" name = "user.username"/>
    密码:<input type="password" name="user.password"/>
    <input type="submit" value="login"/>
</form>
</body>
</html>
