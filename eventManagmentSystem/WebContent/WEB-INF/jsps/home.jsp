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

	<c:choose>
		<c:when test="${sessionScope.userId != null}">
			<p>
				Hey <c:out value="${sessionScope.userName}" />, Welcome!
			</p>

			<c:choose>
				<c:when test="${sessionScope.isAdmin != 0}">
					<p>
						<a href="${pageContext.request.contextPath}/participants">Show
							current participants</a>
					</p>
				</c:when>
			</c:choose>

			<p>
				<a href="${pageContext.request.contextPath}/events">Show ALL
					events</a>
			</p>
			
			<p><a href="${pageContext.request.contextPath}/eventsForAttendee">Events I am attending</a>

			<p><a href="${pageContext.request.contextPath}/eventsOrganizing">Events I am organizing</a>

			<p>
				<a href="${pageContext.request.contextPath}/createEvent">Add a
					new event</a>
			</p>
			
			<c:choose>
				<c:when test="${sessionScope.isAdmin != 0}">
					<p>
						<a href="${pageContext.request.contextPath}/adminDeleteEvents">Delete Events</a>
					</p>
				</c:when>
			</c:choose>
			
			<c:choose>
				<c:when test="${sessionScope.isAdmin != 0}">
					<p>
						<a href="${pageContext.request.contextPath}/adminDeleteParticipants">Delete Participants</a>
					</p>
				</c:when>
			</c:choose>

			<p>
				<a href="${pageContext.request.contextPath}/logout">Logout</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				<a href="${pageContext.request.contextPath}/login">Invalid
					Credentials, Try Again</a>
			</p>
		</c:otherwise>
	</c:choose>



</body>
</html>