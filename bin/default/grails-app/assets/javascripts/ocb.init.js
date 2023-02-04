
//This jquery is used to confirm before delete
jQuery(document).ready(function () {

    jQuery('.delete-confirmation').confirm({
        title: 'Delete Confirmation!',
        content: 'Are you sure want to delete?'
    });

});