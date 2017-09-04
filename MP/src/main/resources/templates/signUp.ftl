<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <h2>${msg}</h2>
    <form id="user" name="user" action="/signUp" enctype="multipart/form-data" method="post">
        <label>用户名：<input type="text" name="name" /></label>
        <label>密码：<input name="password" type="password"></label>
        <input id="btn" type="submit" value="上传" />
    </form>
</body>
</html>