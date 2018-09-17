jQuery().ready(function () {
    var tabAccounts = [];
    $.getJSON('localhost:8080/money-transactions/banktransaction/accounts', function(data) {
        $.each(data, function (index, val) {
            tabAccounts[index] = val;
        });
        console.log(tabAccounts);
    });
});