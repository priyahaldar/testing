<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member Area</title>
</head>
<body>
Member Area
<%
String username=null,sessionid=null;
Cookie[] cookies = request.getCookies();
if(cookies != null)
{
	for(Cookie cookie:cookies)
	{
		if(cookie.getName().equals("username"))
		{
			username=cookie.getValue();
		}

		if(cookie.getName().equals("JSESSIONID"))
		{
			sessionid=cookie.getValue();
		}
	}
}
if(username == null || sessionid == null)
{
response.sendRedirect(request.getContextPath()+"/SiteController?action=login");
}
%>
<form action="<%= request.getContextPath() %>/MemberController" method="post">
<input type="hidden" name="action" value="logout">
<input type="submit" value="Logout">
</form>
<br/>
usernam: <%= username %><br/>
sessionid: <%=  sessionid%><br/>
</body>
</html>