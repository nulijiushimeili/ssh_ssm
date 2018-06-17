<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-03-02
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>

<form action="/user/userAdd" method="post">
    编号:<input type="text" name="id"/><br>
    用户:<input type="text" name="username"/><br>
    昵称:<input type="text" name="nickname"/><br>
    密码:<input type="password" name="password"/><br>
    <input type="submit" value="保 存" /><br>
</form>
</body>
</html>
