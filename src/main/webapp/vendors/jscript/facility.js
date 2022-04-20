$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		//get the json url link
		var href = $(this).attr('href');
		
		//read data from json response
		$.get(href, function(facility,status){
			$('#editid').val(facility.facilityid);
			$('#editname').val(facility.facilityname);
			$('#editdepartmentid').val(facility.departmentid);
			$('#editdistrictid').val(facility.districtid);
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