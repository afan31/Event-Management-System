/**
 * 
 */
alert("Hello");
$('#eventType').on('change',function(){
				     var selection = $(this).val();
				     alert(selection);
				    switch(selection){
				    case "sport":
				    $("#technologyDiv").show()
				   break;
				    default:
				    $("#technologyDiv").hide()
				    }
				});