$('document').ready(function (){
	setTimeout(function () {
        $("#alert-message").hide();
    }, 10000);
    
    $('#add-new').on('click',function(event){
        event.preventDefault();
        $('#modal-add').modal();
    });

    $('#example').DataTable({
         info: false,"pageLength": 10, "bLengthChange": false,
    });
});
