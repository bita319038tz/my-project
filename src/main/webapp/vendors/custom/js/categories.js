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
            $("#edit_id").val(result.category_id);
            $("#edit_name").val(result.category_name);
            $('#modal-edit').modal();
        });
    });
    
    $('#change_password').on('click',function(event){
        event.preventDefault();
        $('#modal-password').modal();
    });

});
