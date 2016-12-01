<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="boostrap.jsp" %>
<!-- <script src="eventType.js"></script>  -->
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<title>Create Event</title>
</head>
<body>
	<div class="container">
		<form method="post"
			action="${pageContext.request.contextPath}/eventcreate">
			<div class="form-group">

				<div class="form-group row">
					<label for="example-text-input" class="col-xs-2 col-form-label">Name</label>
					<div class="col-xs-10">
						<input class="form-control" name="name" type="text">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-description-input" class="col-xs-2 col-form-label">description</label>
					<div class="col-xs-10">
						<input class="form-control"  name="description" type="text">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-address-input" class="col-xs-2 col-form-label">Address</label>
					<div class="col-xs-10">
						<input class="form-control" name="address" type="text">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-seats-input" class="col-xs-2 col-form-label">Total Seats</label>
					<div class="col-xs-10">
						<input class="form-control" name="seats" type="number">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-seats-input" class="col-xs-2 col-form-label">Event Type</label>
					<div class="col-xs-10">
						<select name="eventType" id="eventType">
							<option>Choose Event type</option>
							<option value="sport">Sport</option>
							<option value="music">Music</option>
							<option value="technology">Technology</option>
						</select>
					</div>
				</div>
				
				<!-- sport field -->
				<div class="form-group row" id="sportDiv">
					<label for="example-seats-input" class="col-xs-2 col-form-label">Game</label>
					<div class="col-xs-10">
						<input class="form-control" name="game" type="text">
					</div>
				</div>
				
				<!-- music field -->
				<div class="form-group row" id="musicDiv1">
					<label for="example-seats-input" class="col-xs-2 col-form-label">Genre</label>
					<div class="col-xs-10">
						<input class="form-control" name="genre" type="text">
					</div>
				</div>
				<div class="form-group row" id="musicDiv2">
					<label for="example-seats-input" class="col-xs-2 col-form-label">Artist</label>
					<div class="col-xs-10">
						<input class="form-control" name="artist" type="text">
					</div>
				</div>
				
				<!-- technology field -->
				<div class="form-group row" id="technologyDiv">
					<label for="example-seats-input" class="col-xs-2 col-form-label">Category</label>
					<div class="col-xs-10">
						<select name="techType" id="techType">
							<option value="mobile">Mobile</option>
							<option value="robotics">Robotics</option>
							<option value="cloud">Cloud</option>
						</select>
					</div>
				</div>
				
			
				
				
					<button type="submit" class="btn btn-primary">Create
						event</button>
				</div>
				</div>
		</form>
	</div>
</body>
</html>

<script>
$("#sportDiv").hide()
$("#technologyDiv").hide()
$("#musicDiv1").hide()
$("#musicDiv2").hide()
$('#eventType').on('change',function(){
				     var selection = $(this).val();
				     if( $(this).val()==="technology"){
					    $("#technologyDiv").show()
					    $("#sportDiv").hide()
					    $("#musicDiv1").hide()
						$("#musicDiv2").hide()
				     }else if( $(this).val()==="sport"){
					    $("#sportDiv").show()
					    $("#technologyDiv").hide()
					    $("#musicDiv1").hide()
						$("#musicDiv2").hide()
				    }else if( $(this).val()==="music"){
				    	$("#musicDiv1").show()
					    $("#musicDiv2").show()
					    $("#sportDiv").hide()
				    	$("#technologyDiv").hide()
				    }else {
					    $("#sportDiv").hide()
					    $("#technologyDiv").hide()
					    $("#musicDiv1").hide()
						$("#musicDiv2").hide()
				    }
				});

</script>

				