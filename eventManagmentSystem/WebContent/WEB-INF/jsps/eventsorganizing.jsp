<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>
<title>Events Organizing</title>
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
        <td><c:out value="${event.total_seats}"></c:out></td>
        <td>
        <div>
         <form method="post">
        	<input type="hidden" name="event_id" value="${event.id}"/>
        	<input type="submit" value = "Update" class="btn btn-primary" onclick="form.action='${pageContext.request.contextPath}/updateevent';"/>
        	<input type="submit" value = "Delete" class="btn btn-primary" onclick="form.action='${pageContext.request.contextPath}/deleteevent';"/>
        </form> 
        </div>
        </td>
        </tr>
	</c:forEach>
    </tbody>
  </table>
</form>
<p><a href="${pageContext.request.contextPath}/">Home</a></p>
	</div>
</body>

</html>