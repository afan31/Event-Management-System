<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>
<title>Event Management System</title>
</head>
<body>

<p> Hey user with ID <c:out value="${sessionScope.userId}"/>, Welcome! </p>

<!-- Ideally, only the admin should have the privilege to view all participants -->
<p><a href="${pageContext.request.contextPath}/participants">Show current participants</a></p>

<p><a href="${pageContext.request.contextPath}/events">Show all events</a></p>

<p><a href="${pageContext.request.contextPath}/createEvent">Add a new event</a></p>

<p><a href="${pageContext.request.contextPath}/eventsAttending">Events I am attending</a>

<p><a href="${pageContext.request.contextPath}/eventsOrganizing">Events I am organizing</a>

<p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>
	
</body>
</html>