$('document').ready(function (){
    $('#add-new').on('click',function(event){
        event.preventDefault();
        $('#modal-add').modal();
    });
    
    $('#change_password').on('click',function(event){
        event.preventDefault();
        $('#modal-password').modal();
    });
    
    var table = $('#example').DataTable( {
        lengthChange: false,
        buttons: [ 'pdf', 'excel', 'csv', 'colvis' ]
    } );
 
    table.buttons().container().appendTo( '#example_wrapper .col-sm-6:eq(0)' );

});
