<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>

<title>Create Participant</title>
</head>
<body>
	<div class="container">
		<form data-toggle="validator" role="form"
		method="post"
			action="${pageContext.request.contextPath}/docreate">
			<div class="form-group">
				
				<div class="form-group row">
					<label for="example-text-input" class="col-xs-2 col-form-label">Name</label>
					<div class="col-xs-10">
						<input class="form-control" name="name" type="text" id="participantName" placeholder="Afan" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="example-email-input" class="col-xs-2 col-form-label">Email</label>
					<div class="col-xs-10">
						<input class="form-control"  name="email" type="email" id="participantEmail" placeholder="afan@gmail.com" data-error="That email address is invalid" required>
    						<div class="help-block with-errors"></div>
					</div>
				</div>
				<div class="form-group row">
					<label for="example-tel-input" class="col-xs-2 col-form-label">Phone</label>
					<div class="col-xs-10">
						<input class="form-control" name="phone" type="number"
							placeholder="1-(555)-555-5555">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-number-input" class="col-xs-2 col-form-label">Zipcode</label>
					<div class="col-xs-10">
						<input class="form-control" name="zipcode" type="text" id="participantZipcode" placeholder="02120" required>
					</div>
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Create
						participant</button>
					</td>
				</div>
				</div>
		</form>
		<p><a href="${pageContext.request.contextPath}/">Home</a></p>
	</div>
</body>
</html>