<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>

<title>Create Participant</title>

<script type="text/javascript">
            function validate()
            {
                var name = document.getElementById("name");
                var password = document.getElementById("password");
                var email = document.getElementById("email");
                var phone = document.getElementById("phone");
                var zipcode = document.getElementById("zipcode");
                var valid = true;
                if(name.value.length<=0 || password.value.length<=0|| email.value.length<=0 || phone.value.length<=0 || zipcode.value.length<=0)
                    {
                        alert("Don't leave any fields blank!");
                        valid = false;
                    }
                return valid;
            };

        </script>

</head>
<body>
	<div class="container">
		<form method="post"
		onsubmit="return validate();"
			action="${pageContext.request.contextPath}/docreate">
			<div class="form-group">
				
				<div class="form-group row">
					<label for="example-text-input" class="col-xs-2 col-form-label">Name</label>
					<div class="col-xs-10">
						<input class="form-control" name="name" id="name" type="text">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-password-input" class="col-xs-2 col-form-label">Password</label>
					<div class="col-xs-10">
						<input class="form-control" name="password" id="password" type="password">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-email-input" class="col-xs-2 col-form-label">Email</label>
					<div class="col-xs-10">
						<input class="form-control"  name="email" id="email" type="email">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-tel-input" class="col-xs-2 col-form-label">Phone</label>
					<div class="col-xs-10">
						<input class="form-control" name="phone" id="phone" type="tel"
							placeholder="1-(555)-555-5555">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-number-input" class="col-xs-2 col-form-label">Zipcode</label>
					<div class="col-xs-10">
						<input class="form-control" name="zipcode" id="zipcode" sstype="number">
					</div>
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Create
						participant</button>
					</td>
				</div>
				</div>
		</form>
	</div>
</body>
</html>