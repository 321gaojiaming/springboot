<%--
  Created by IntelliJ IDEA.
  User: 高嘉铭
  Date: 2018/9/17
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/login" method="post">
        <input id="username" placeholder="username" type="text" name="username"/>
        <input id="password" placeholder="password" type="password" name="password"/>
        <button type="submit">提交</button>
    </form>
</body>
</html>
