$("#thanhVienID").click(function() {
		$(".body").html(`
				<table class="table table-hover">
				  <thead class="bg-dark text-white">
				    <tr>
				      <th scope="col">Id</th>
				      <th scope="col">Phone</th>
				      <th scope="col">Email</th>
				      <th scope="col">Male</th>
				      <th scope="col">Name</th>
				      <th scope="col">Birtday</th>
				      <th scope="col">Đánh giá</th>
				    </tr>
				  </thead>
				  <tbody id="content">
				   
				  </tbody>
				</table>
		`);
		  $.ajax({
			 method: "GET",
			 url: "/api/members",
			})
		 .done(function(msg) {
			 var members = msg;
			$.each(members, function( key, members ) {
			   $("#content").append(`
					  <tr>
					     <th scope="col">${members.idMember}</th>
					   	 <th scope="col">${members.phone}</th>
					     <th scope="col">${members.email}</th>
					     <th scope="col">${members.male}</th>
					     <th scope="col">${members.name}</th>
					     <th scope="col">${members.birtday}</th>
					   	 <th scope="col"><button class="btn-danger btn" onclick="reviews("${members.idMember}")">Đánh giá</button></th>
					   	
					  </tr>   	   
				`);
			});
		 });
	});
	
	$("#thanhGiaID").click(function() {
		$(".body").html(`
			thanhGiaID
		`);
	});
	
	$("#hoatDongID").click(function() {
		$(".editAction").click(function(){
			alert('dsa');
		});
		$.ajax({
			  method: "get",
		 	  url: "/api/actions",
			  contentType: "application/json; charset=utf-8",
			})
			.done(function( data ) {
				$.each( data, function( key, value ) {
					$(".contentActions").append(`<tr>
					<th scope="col">#</th>
				    <th scope="col">${value.nameAction}</th>
				    <th scope="col">${value.describes}</th>
				    <th scope="col">${value.dateStart}</th>
				    <th scope="col">${value.datefinish}</th>
				    <th scope="col">${value.numberMin}</th>
				    <th scope="col">${value.numberMax}</th>
				    <th scope="col">${value.timeDeadline}</th>
				    <th scope="col">${value.status}</th>
				    <th scope="col">${value.member.idMember}</th>
				    <th scope="col">${value.reasonCancel}</th>
				    <th scope="col"><button class="btn btn-success" onclick="editAction(${value.idAction})"><i class="fas fa-edit "></i> </button></th>
				    <th scope="col"><button class="btn btn-secondary"onclick="deleteAction(${value.idAction})" ><i class="fas fa-trash-alt"></i></button></th>
					<th scope="col"><button class="btn btn-secondary"onclick="joinAction(${value.idAction})" ><i class="fas fa-trash-alt"></i></button></th>		
				</tr>`);
				});
			});
		
		$(".body").html(`
				<button style="margin-bottom: 22px;margin-left: 11px;" class="btn btn-primary themHoatDong">Thêm hoạt động</button>
				</br>  
				<form class="col-md-4 form-addAction" style=" display: none;">
				  <div class="form-group">
				    <input type="text" class="form-control" id="idNameAction" placeholder="Tên hoạt động">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" id="idDescribes" placeholder="Mô tả">
				  </div>
				  <div class="form-group">
				    <input type="number" class="form-control" id="idNumberMin" placeholder="Số lượng tối thiểu">
				  </div>
				  <div class="form-group">
				    <input type="number" class="form-control" id="idNumberMax"placeholder="Số lượng tối đa">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" id="idDateStart" placeholder="Ngày bắt đầu">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" id="idDatefinish" placeholder="Ngày kết thúc">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" id="idTimeDeadline" placeholder="Hạn chót">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" id="idStatus" placeholder="Trang thái">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" id="idMembers" placeholder="Id người thêm">
				  </div>
				  <button type="button" class="btn btn-primary" id="newAction">Thêm hoạt động</button>
				</form>
				<table class="table" style="font-size: 13px;">
					<thead>
						<tr>
							<th scope="col">#</th>
						    <th scope="col">Tên hoạt động</th>
						    <th scope="col">Mô tả</th>
						    <th scope="col">Ngày bắt đầu</th>
						    <th scope="col">Ngày kết thúc</th>
						    <th scope="col">Số lượng tối thiểu</th>
						    <th scope="col">Số lượng tối đa</th>
						    <th scope="col">Thời hạn</th>
						    <th scope="col">Trạng thái</th>
						    <th scope="col">Mã trưởng đoàn</th>
						    <th scope="col">Lý do hủy</th>
						    <th scope="col">Sữa hoạt động</th>
						    <th scope="col">Hủy hoạt động</th>
						    <th scope="col">Tham gia</th>
						</tr>
					</thead>
					<tbody class="contentActions">
					
					</tbody>
				</table>
			`			
		);
		
		$(".themHoatDong").click(function(){
			$(".form-addAction").show();
		});
		
		$("#newAction").click(function(){
			$(".form-addAction").hide();
			var nameAction = $("#idNameAction").val();
			var describes = $("#idDescribes").val();
			var numberMin = $("#idNumberMin").val();
			var numberMax = $("#idNumberMax").val();
			var dateStart= $("#idDateStart").val();
			var datefinish = $("#idDatefinish").val();
			var timeDeadline =$("#idTimeDeadline").val();
			var status =$("#idStatus").val();
			var idMember =$("#idMembers").val();
			var newAcction = {
					nameAction:nameAction,
					describes:describes,
					numberMin:numberMin,
					numberMax:numberMax,
					dateStart:dateStart,
					datefinish:datefinish,
					timeDeadline:timeDeadline,
					status:status,
					idMember:idMember
			}
			if(newAcction.idMember ==""){
				alert('Id ko duoc de trong');
				return;
			}
			var jsonAction = JSON.stringify(newAcction);
			console.log(jsonAction);
			$.ajax({
			  method: "POST",
			  url: "/api/actions",
			  data: jsonAction,
			  contentType: "application/json; charset=utf-8",
			})
			.done(function( data ) {
				alert('them thanh cong');
			});
		});
		
	});
	
	$("#thongKeID").click(function() {
		$(".body").html(`
			thongKeID
		`);
	});
	function reviews(idMember){
		console.log(idMember);
	}