<%@ taglib prefix="S" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-02-25
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>home</title>
  </head>
  <body>
  welcome to home ! ! !
  欢迎${user.username}登录成功
  欢迎<S:property value="user.username"/>登录成功

  </body>
</html>
