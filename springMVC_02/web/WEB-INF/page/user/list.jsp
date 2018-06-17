<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-03-02
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<a href="/user/userAdd" >添加用户</a><br>
<c:forEach var="user" items="${users}" >

    ${user.value.id}---
    ${user.value.username}---
    ${user.value.nickname}---
    ${user.value.password}
    <a href="/user/${user.value.username}" >用户详情</a> |
    <a href="/user/${user.value.username}/update">修改</a> |
    <a href="/user/${user.value.username}/delete" onclick="return confirm('确定删除此用户吗?')">删除</a> <br>
    <%--${user.key}--%>
</c:forEach>


</body>
</html>
