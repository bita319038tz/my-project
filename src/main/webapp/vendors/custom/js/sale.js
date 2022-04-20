$('document').ready(function (){
    var base_url = window.location.origin;
    //alert(base_url);
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
            $("#edit_id").val(result.sale_id);
            $("#product").val(result.medicine_id);
           // $("#price").val(result.price);
            $("#quantity").val(result.quantity);
            $('#modal-edit').modal();
        });
    });
    
    $('#change_password').on('click',function(event){
        event.preventDefault();
        $('#modal-password').modal();
    });
    
    $('#item').on('change',function(event){
        var product_id = $(this).val();
        var href = base_url+"/medicine/price/"+product_id+"/json";
        $.get(href, function(result,status){
            $("#amount").val(result.selling_price);
        });
        //alert(product_id);
    });
    
    $('table #delete-button').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDelete').attr('href',href);

        $('#deleteModal').modal();
    });

});
