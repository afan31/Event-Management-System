<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>
<title>Events</title>
</head>
<body>
<table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Address</th>
        <th>Seats</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="event" items="${events}">
	    <tr>
        <td><c:out value="${event.name}"></c:out></td>
        <td><c:out value="${event.description}"></c:out></td>
        <td><c:out value="${event.address}"></c:out></td>
        <td><c:out value="${event.seats}"></c:out></td>
        </tr>
	</c:forEach>
    </tbody>
  </table>

	
</body>

</html>