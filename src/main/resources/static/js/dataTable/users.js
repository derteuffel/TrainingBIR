/**
 * Created by derteuffel on 14/02/2019.
 */
$(document).ready( function () {

    var user = $('#user').DataTable({
        "sAjaxSource": "/user",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        language: {
            url: '//cdn.datatables.net/plug-ins/1.10.19/i18n/French.json'
        },
        "aoColumns": [
            { "mData": "userName"},
            { "mData": "userMilitaryCode" },
            { "mData": "userRegion" },
            { "mData": "userEmail" },
            { "mData": "userPersonalTelephonNumber" },
            { "mData": "userId",
                mRender: function (mData,type,row){
                    var str3='';
                    str3 += '<a href="/user/detail/'+mData+'" class="btn btn-success rounded-circle"><i class="fa fa-eye"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;';
                    str3 += '<a href="/user/delete/'+mData+'" class="btn btn-danger rounded-circle"><i class="fa fa-trash"></i></a>';
                    return str3;
                }}

        ]
    })

});

