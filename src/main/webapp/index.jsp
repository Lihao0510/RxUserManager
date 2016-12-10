<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>MyServlet Test</title>
</head>
<body>
<h2>Hello World!</h2>
<p>
    <% String name = "欢迎来到Servlet测试页!";%>
    <h3><%= name%></h3>
</p>
<div>请输入号码:</div>
<form id="query" method="post" action="/start/myservlet">
    <input type="text" name="username">
    <input type="submit" value="查询">
</form>
</body>
</html>
