jQuery().ready(function () {
    var tabAccounts = [];
    $.getJSON('localhost:8016/money-transactions/banktransaction/accounts', function(data) {
        $.each(data, function (index, val) {
            tabAccounts[index] = val;
        });
        console.log(tabAccounts);
    });
});