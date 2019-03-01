/**
 * Created by derteuffel on 14/02/2019.
 */
$(document).ready( function () {

    var user = $('#data').DataTable({
        "sAjaxSource": "/users/users/courses/average",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        language: {
            url: '//cdn.datatables.net/plug-ins/1.10.19/i18n/French.json'
        },
        "aoColumns": [
            { "mData": "userName"}
        ]
    })

});

