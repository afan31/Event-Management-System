<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp"%>
<title>Event Management System</title>
</head>
<body>
<div class="container">
<div style="text-align:center;"><h1> Event Management System </h1></div>
<p><a href="${pageContext.request.contextPath}/login" class="btn btn-primary">Login</a></p>
<p><a href="${pageContext.request.contextPath}/createParticipant" class="btn btn-success">Register</a></p>
</div>
</body>
</html>