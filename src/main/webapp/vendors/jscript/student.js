$('document').ready(function (){
	
	$('table #editButton').on('click',function(event){
		//event.preventDefault();
		//get the json url link
		var href = $(this).attr('href');
		
		//read data from json response
		$.get(href, function(student,status){
			$('#editId').val(student.id);
			$('#editfirstname').val(student.firstname);
			$('#editlastname').val(student.lastname);
			$('#editdob').val(student.dob);
			$('#editaddress').val(student.address);
			$('#editemail').val(student.email);
			$('#editphoneNumber').val(student.phonenumber);
			$('#editclassid').val(student.classid);
		});
		$('#editModal').modal();
	});
	
	
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		 var href = $(this).attr('href');
		 $('#confirmDelete').attr('href',href);
		
		$('#deleteModal').modal();
	});
});