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
<c:choose>
				<c:when test="${sessionScope.isAdmin != 0}">
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
			  </c:when>
			  
			  <c:otherwise>
			<p>
				<a href="${pageContext.request.contextPath}/">You don't have the access to view all the Participants, 
				please go back to the home page</a>
			</p>
		</c:otherwise>
			</c:choose>

	<p><a href="${pageContext.request.contextPath}/">Home</a>
</body>

</html>
