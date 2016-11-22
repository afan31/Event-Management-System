<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>

<title>Create Event</title>
</head>
<body>
	<div class="container">
		<form method="post"
			action="${pageContext.request.contextPath}/validateuser">
			<div class="form-group">

				<div class="form-group row">
					<label for="example-text-input" class="col-xs-2 col-form-label">Name</label>
					<div class="col-xs-10">
						<input class="form-control" name="name" type="text">
					</div>
				</div>
				
				<!-- We'll need another field for password -->
				
				<div>
					<button type="submit" class="btn btn-primary">Login</button>
				</div>
		</form>
	</div>
</body>
</html>