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
    <title>修改用户信息</title>
</head>
<body>

<form action="/user/${username}/update" method="post">
    编号:<input type="text" name="id" value="${user.id}"/><br>
    用户:<input type="text" name="username" value="${user.username}" /><br>
    昵称:<input type="text" name="nickname" value="${user.nickname}"/><br>
    密码:<input type="password" name="password" value="${user.password}"/><br>
    <input type="submit" value="修 改" /><br>
</form>
</body>
</html>
