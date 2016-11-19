<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hi there! Session :
	<%=session.getAttribute("name")%>
	<p />

	Request :
	<%=request.getAttribute("name")%>
	<p />

	Request (using Expression Language): ${name}
	<p />

	<c:out value="${name}"></c:out>

	<sql:query var="rs" dataSource="jdbc/spring">
		select id, name, phone, zipcode, email from Participant
	</sql:query>
	
	<c:forEach var="row" items="${rs.rows}">
	    Id: ${row.id}<br/>
	    Name: ${row.name}<br/>
	    Phone: ${row.phone}<br/>
	    Email: ${row.email}<br/>
	    Zipcode: ${row.zipcode}<br/>
	</c:forEach>


</body>
</html>