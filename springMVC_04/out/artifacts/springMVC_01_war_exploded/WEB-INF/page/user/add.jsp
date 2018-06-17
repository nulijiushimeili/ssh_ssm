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
<jsp:include page="/inc/top.jsp" />
<form action="/user/userAdd" method="post" enctype="multipart/form-data">
    编号:<input type="text" name="id"/><br>
    用户:<input type="text" name="username"/><br>
    昵称:<input type="text" name="nickname"/><br>
    密码:<input type="password" name="password"/><br>
    相册:<input type="file" name="photos" /><br>
    相册:<input type="file" name="photos" /><br>
    相册:<input type="file" name="photos" /><br>
    相册:<input type="file" name="photos" /><br>
    <input type="submit" value="保 存" /><br>

    <%--1.多文件上传要导入两个jar包:--%>
        <%--commons-fileupload-xxx.jar--%>
        <%--commons-io-xxx.jar--%>
    <%--2.在form表单中添加属性 enctype="multipart/form-data"--%>
      <%--添加文件域  相册:<input type="file" name="photos" />--%>
    <%----%>

</form>
</body>
</html>
