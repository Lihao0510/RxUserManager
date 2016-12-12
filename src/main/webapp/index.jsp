<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>CRM START</title>
</head>
<body>
<h2>Welcome to CRM system!</h2>
<p>
    <% String name = "欢迎使用员工信息系统!";%>
    <h3><%= name%></h3>
</p>
<div>请输入要查询的员工号码:</div>
<form id="query" method="post" action="/start/queryservlet">
    <input type="text" name="id">
    <input type="submit" value="查询">
    <a href="/start/queryallservlet">查询全部</a>
</form>
<div>添加新员工</div>
<form id="create" method="post" action="/start/createservlet">
    工号<input type="text" name="id">
    姓名<input type="text" name="username">
    年龄<input type="text" name="age">
    性别<input type="text" name="sex">
    <input type="submit" value="添加">
</form>
<div>修改员工信息</div>
<form id="update" method="post" action="/start/updateservlet">
    工号<input type="text" name="id">
    姓名<input type="text" name="username">
    年龄<input type="text" name="age">
    性别<input type="text" name="sex">
    <input type="submit" value="修改">
</form>
<div>请输入要删除的员工号码:</div>
<form id="delete" method="post" action="/start/deleteservlet">
    <input type="text" name="id">
    <input type="submit" value="删除">
</form>
<script type="text/javascript">
    function queryall() {
        window.navigator("/start/queryallservlet")
    }
</script>
</body>
</html>
