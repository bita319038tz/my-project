$('document').ready(function (){
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		
		//get the json url link
		var href = $(this).attr('href');
		
		//read data from json response
		$.get(href, function(district,status){
			$('#editid').val(district.districtid);
			$('#editdistrictname').val(district.districtname);
			$('#editregionid').val(district.regionid);
		});
		//$('#editModal').modal();
	});
	
	
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		 var href = $(this).attr('href');
		 $('#confirmDelete').attr('href',href);
		
		$('#deleteModal').modal();
	});
});