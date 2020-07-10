<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form name="myform" action="<%= request.getContextPath()%>/SiteController" method="post">
user:<input type="text" name="username"><br/>
password:<input type="password" name="userpassword"><br/>
<input type="hidden" name="action" value="loginsubmit">
<input type="submit" value="login">
</form>
</body>
</html>