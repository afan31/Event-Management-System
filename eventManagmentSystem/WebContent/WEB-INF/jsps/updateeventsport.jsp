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
	<h2>Update Event</h2>
		<form data-toggle="validator" role="form" 
		method="post"
			action="${pageContext.request.contextPath}/eventupdatesport">
			<div class="form-group">

				<input type="hidden" name="event_id" value="${event.id}"/>
				<div class="form-group row">
					<label for="example-text-input" class="col-xs-2 col-form-label">Name</label>
					<div class="col-xs-10">
						<input class="form-control" name="name" type="text" id="eventName" value="${event.name}" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="example-description-input" class="col-xs-2 col-form-label">description</label>
					<div class="col-xs-10">
						<input class="form-control"  name="description" type="text" id="eventDescription" value="${event.description}" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="example-address-input" class="col-xs-2 col-form-label">Address</label>
					<div class="col-xs-10">
						<input class="form-control" name="address" type="text" id="eventAddress" value="${event.address}" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="example-seats-input" class="col-xs-2 col-form-label">Total Seats</label>
					<div class="col-xs-10">
						<input class="form-control" name="total_seats" type="number" id="eventNumber" value="${event.total_seats}" required>
					</div>
				</div>
				
			    
			    <div class="form-group row">
					<label for="example-date-input" class="col-xs-2 col-form-label">Event Date</label>
 					<div class="col-xs-10"> 
						<input class="form-control" type="text" name="date" value="${event.date}" />
 			        </div>
 			    </div>
			    
			    
			    <div class="form-group row">
					<label for="example-time-input" class="col-xs-2 col-form-label">Event Time</label>
					<div class="col-xs-10">
							<div class="input-group bootstrap-timepicker timepicker">
						            <input id="timepicker1" type="text" name="time" class="form-control value="${event.time}" input-small">
						            <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
						    </div>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="example-seats-input" class="col-xs-2 col-form-label">Event Type</label>
					<div class="col-xs-10">
						<select name="eventType" id="eventType" required>
							<option selected="selected" value="sport">Sport</option>
							<option value="">Choose Event type</option>
							<option value="music">Music</option>
							<option value="technology">Technology</option>
						</select>
					</div>
				</div>
				
				
				
				<!-- sport field -->
				<div class="form-group row" id="sportDiv">
					<label for="example-seats-input" class="col-xs-2 col-form-label">Game</label>
					<div class="col-xs-10">
						<input class="form-control" name="game" value="${event.game}" type="text">
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
						<select name="category" id="category">
						<option value="">Choose Technology type</option>
							<option value="mobile">Mobile</option>
							<option value="robotics">Robotics</option>
							<option value="cloud">Cloud</option>
						</select>
					</div>
				</div>
				
					<button type="submit" class="btn btn-success">Update
						event</button>
				</div>
				</div>
		</form>
		<p><a href="${pageContext.request.contextPath}/">Home</a></p>
	</div>
</body>
</html>

<script>

$('#timepicker1').timepicker();
$(function() {
    $('input[name="date"]').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true
    }, 
    function(start, end, label) {
        var years = moment().diff(start, 'years');
    });
});

//$("#sportDiv").hide()

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

				