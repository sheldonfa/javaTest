<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/7
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="pictureFile"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
