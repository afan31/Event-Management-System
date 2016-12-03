<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>
<link type="text/css" href="css/bootstrap-timepicker.min.css" />
<!-- <script src="eventType.js"></script>  -->
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
  <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
  <!-- Include Date Range Picker -->
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-timepicker/0.5.2/js/bootstrap-timepicker.min.js"></script>
<title>Create Event</title>
</head>
<body>
	<div class="container">
		<form data-toggle="validator" role="form" 
		method="post"
			action="${pageContext.request.contextPath}/organizercreate">
			<div class="form-group">

				<div class="form-group row">
					<label for="type" class="col-xs-2 col-form-label">Who are you?</label>
					<div class="col-xs-10">
						<select name="type" id="organizerType" required>
							<option value="">Choose one</option>
							<option value="Individual">Individual</option>
							<option value="Company">Company</option>
						</select>
					</div>
				</div>
				<div class="form-group row" id="companyDiv">
					<label for="example-text-input" class="col-xs-2 col-form-label">Company</label>
					<div class="col-xs-10">
						<input class="form-control" name="company" type="text" id="company" placeholder="Company">
					</div>
				</div>
				
					<button type="submit" class="btn btn-primary">
						Proceed to Event Creation
					</button>
				</div>
				</div>
		</form>
		<p><a href="${pageContext.request.contextPath}/">Home</a></p>
	</div>
</body>
</html>

<script>

$("#companyDiv").hide()
$('#organizerType')
	.on('change',function(){
			var selection = $(this).val();
			if( $(this).val()==="Company"){
				$("#companyDiv").show()
			} else if($(this).val()==="Individual") {
				$("#companyDiv").hide()
			}
		});

</script>

				