<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp"%>
<title>Event Management System</title>
</head>
<body>
<div class="container">
<div class="list-group">

	<c:choose>
		<c:when test="${sessionScope.userId != null}">
			<div>
				<h1>Hey <c:out value="${sessionScope.userName}" />,Welcome!</h1>
			</div>

			<c:choose>
				<c:when test="${sessionScope.isAdmin != 0}">
					<div>
						<a href="${pageContext.request.contextPath}/participants" class="list-group-item">Show
							current participants</a>
					<div>
				</c:when>
			</c:choose>
			
			<c:choose>
				<c:when test="${sessionScope.isAdmin != 0}">
					<div>
						<a href="${pageContext.request.contextPath}/adminDeleteParticipants" class="list-group-item">Delete Participants</a>
					</div>
				</c:when>
			</c:choose>

			<div>
				<a href="${pageContext.request.contextPath}/events" class="list-group-item">Show all
					events</a>
			</div>
			
			<c:choose>
				<c:when test="${sessionScope.isAdmin != 0}">
					<div>
						<a href="${pageContext.request.contextPath}/adminDeleteEvents" class="list-group-item">Delete Events</a>
					</div>
				</c:when>
			</c:choose>
			
			<div><a href="${pageContext.request.contextPath}/eventsForAttendee" class="list-group-item">Events I am attending</a></div>

			<div><a href="${pageContext.request.contextPath}/eventsOrganizing" class="list-group-item">Events I am organizing</a></div>

			<div>
				<a href="${pageContext.request.contextPath}/createEvent" class="list-group-item">Add a
					new event</a>
			</div>
			
			
			
			
			</div>
	<br>
	<br>
			<p>
				<a href="${pageContext.request.contextPath}/logout" class="btn btn-warning">Logout</a>
			</p>
			<br>
	<br>
		</c:when>
		<c:otherwise>
			<p>
				<h2><a href="${pageContext.request.contextPath}/login">Invalid
					Credentials, Try Again</a></h2>
			</p>
		</c:otherwise>
	</c:choose>
</div>





</body>
</html>