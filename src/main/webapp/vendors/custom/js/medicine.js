$('document').ready(function (){
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
            $("#edit_id").val(result.medicine_id);
            $("#editname").val(result.medicine_name);
            $("#editcategory_id").val(result.category_id);
            $("#editprice").val(result.selling_price);
            $("#editunit_id").val(result.unit_id);
            $("#editstrength").val(result.strength);
            $("#editdetail").val(result.medicine_detail);
            $('#modal-edit').modal();
        });
    });
    
    $('#change_password').on('click',function(event){
        event.preventDefault();
        $('#modal-password').modal();
    });
    
    $('#example').DataTable({
         info: false,"pageLength": 10, "bLengthChange": false,
    });
    
    $('table #availability').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDelete').attr('href',href);

        $('#deleteModal').modal();
    });
});
