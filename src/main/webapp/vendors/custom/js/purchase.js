$('document').ready(function (){
     //$('#modal-edit').modal();
    setTimeout(function () {
        $("#msg").hide();
    }, 5000);
    $('#add-new').on('click',function(event){
        event.preventDefault();
        $('#modal-add').modal();
    });
    
    $('table #edit-button').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(result,status){
            $("#edit_id").val(result.purchase_id);
            $("#product").val(result.medicine_id);
            $("#supplier").val(result.supplier_id);
            $("#date").val(result.purchase_date);
            $("#exp_date").val(result.expire_date);
            $("#quantity").val(result.quantity);
            $('#modal-edit').modal();
        });
    });
    
    $('#change_password').on('click',function(event){
        event.preventDefault();
        $('#modal-password').modal();
    });
    
    $('table #delete-button').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDelete').attr('href',href);

        $('#deleteModal').modal();
    });
    
//    var table = $('#example').DataTable( {
//        lengthChange: false,
//        buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
//    } );
// 
//    table.buttons().container().appendTo( '#example_wrapper .col-sm-6:eq(0)' );

});
