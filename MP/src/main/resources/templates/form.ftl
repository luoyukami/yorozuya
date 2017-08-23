<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <h2>${msg}</h2>
    <form id="data" name="data" action="/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file" />
        <#--<input type="text" name="test"/>-->
        <input id="btn" type="submit" value="上传" />
    </form>
</body>
</html>