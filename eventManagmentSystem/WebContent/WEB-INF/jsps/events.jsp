<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>
<title>Events</title>
</head>
<body>
<div class="container">
<table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Address</th>
        <th>Seats</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="event" items="${events}">
	    <tr>
	    <td><c:out value="${event.id}"></c:out></td>
        <td><c:out value="${event.name}"></c:out></td>
        <td><c:out value="${event.description}"></c:out></td>
        <td><c:out value="${event.address}"></c:out></td>
        <td><c:out value="${event.seats}"></c:out></td>
        <td>
        <div>
        <form method="post"
			action="${pageContext.request.contextPath}/attendevent">
        	<input type="hidden" name="event_id" value="${event.id}"/>
        	<!-- Check if user has already clicked on attend for this event -->
        	<c:set var="contains" value="0" />
        	<c:set var="currentUserId" value="${sessionScope.userId}" />
        	<c:set var="eventId" value="${eventId}" />
        	<c:set var="currentEventId" value="${event.id}" />
			<c:forEach var="userId" items="${userIds}">
  				<c:if test="${userId eq currentUserId}">
  					<c:if test="${eventId eq currentEventId}">
    					<c:set var="contains" value="1" />
    				</c:if>
  				</c:if>
			</c:forEach>
        	<input type="submit" ${contains eq "1"  ? 'disabled="disabled"' : ''} value = "Attend" class="btn btn-primary"/>
        </form>
        </div>
        </td>
        </tr>
	</c:forEach>
    </tbody>
  </table>
</form>
	</div>
</body>

</html>