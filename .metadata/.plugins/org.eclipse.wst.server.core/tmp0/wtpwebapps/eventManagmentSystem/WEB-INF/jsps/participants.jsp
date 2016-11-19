<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>
<title>Participants</title>
</head>
<body>
<table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Zipcode</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="participant" items="${participants}">
	    <tr>
        <td><c:out value="${participant.name}"></c:out></td>
        <td><c:out value="${participant.email}"></c:out></td>
        <td><c:out value="${participant.phone}"></c:out></td>
        <td><c:out value="${participant.zipcode}"></c:out></td>
        </tr>
	</c:forEach>
    </tbody>
  </table>

	
</body>

</html>