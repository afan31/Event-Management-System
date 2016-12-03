<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>
<title>Attendee Events</title>
</head>
<body>
<div class="container">
<h2>Events I am attending</h2>
<table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Address</th>
        <th>Seats</th>
        <th>Time</th>
        <th>Date</th>
        <th>Is Indoor?</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="event" items="${events}">
	    <tr>
	    <td><c:out value="${event.id}"></c:out></td>
        <td><c:out value="${event.name}"></c:out></td>
        <td><c:out value="${event.description}"></c:out></td>
        <td><c:out value="${event.address}"></c:out></td>
        <td><c:out value="${event.total_seats}"></c:out></td>
        <td><c:out value="${event.time}"></c:out></td>
        <td><c:out value="${event.date}"></c:out></td>
        <td><c:out value="${event.isIndoor}"></c:out></td>
        
        </tr>
	</c:forEach>
    </tbody>
  </table>
</form>
<p><a href="${pageContext.request.contextPath}/">Home</a></p>
	</div>
</body>

</html>