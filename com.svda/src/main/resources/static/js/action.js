function editAction(idAction){
	$.ajax({
        url: '/api/actions/'+idAction,
        type: 'GET',
        cache: false,
        success: function(data){
        	$(".body").html(`
    				</br>  
    				<form class="col-md-4 form-addAction" style=" display: none;">
    				  <div class="form-group">
    				    <input type="text" class="form-control" id="idNameAction" value="${data.nameAction}">
    				  </div>
    				  <div class="form-group">
    				    <input type="text" class="form-control" id="idDescribes" value="${data.describes}">
    				  </div>
    				  <div class="form-group">
    				    <input type="number" class="form-control" id="idNumberMin" value="${data.numberMin}">
    				  </div>
    				  <div class="form-group">
    				    <input type="number" class="form-control" id="idNumberMax" value="${data.numberMax}">
    				  </div>
    				  <div class="form-group">
    				    <input type="text" class="form-control" id="idDateStart" value="${data.dateStart}">
    				  </div>
    				  <div class="form-group">
    				    <input type="text" class="form-control" id="idDatefinish" value="${data.datefinish}">
    				  </div>
    				  <div class="form-group">
    				    <input type="text" class="form-control" id="idTimeDeadline" value="${data.timeDeadline}">
    				  </div>
    				  <div class="form-group">
    				    <input type="text" class="form-control" id="idStatus" value="${data.status}">
    				  </div>
    				 
    				  <button type="button" class="btn btn-primary" id="updateAction">Sữa hoạt động</button>
    				</form>
    			`)
    		$(".form-addAction").show();
        	$("#updateAction").click(function(){
        		$(".form-addAction").hide();
    			var nameAction = $("#idNameAction").val();
    			var describes = $("#idDescribes").val();
    			var numberMin = $("#idNumberMin").val();
    			var numberMax = $("#idNumberMax").val();
    			var dateStart= $("#idDateStart").val();
    			var datefinish = $("#idDatefinish").val();
    			var timeDeadline =$("#idTimeDeadline").val();
    			var status =$("#idStatus").val();
    			var newAcction = {
    					nameAction:nameAction,
    					describes:describes,
    					numberMin:numberMin,
    					numberMax:numberMax,
    					dateStart:dateStart,
    					datefinish:datefinish,
    					timeDeadline:timeDeadline,
    					status:status,
    					idAction:idAction
    			}
    			if(newAcction.idMember ==""){
    				alert('Id ko duoc de trong');
    				return;
    			}
    			var jsonAction = JSON.stringify(newAcction);
    			console.log(jsonAction);
    			$.ajax({
    			  method: "PATCH",
    			  url: "/api/actions",
    			  data: jsonAction,
    			  contentType: "application/json; charset=utf-8",
    			})
    			.done(function( data ) {
    				alert('Update thanh cong');
    			});
        	});
        }
    });	
}

function deleteAction(idAction){
	$.ajax({
        url: '/api/actions?id='+idAction,
        type: 'Delete',
        cache: false,
        success: function(data){
        	$.ajax({
  			  method: "get",
  		 	  url: "/api/actions",
  			  contentType: "application/json; charset=utf-8",
  			})
  			.done(function( data ) {
  				
  			});
        }
    });

}

function joinAction(id){
	console.log(id);
}