let dropdown = $('#accounts-list');

dropdown.empty();

dropdown.append('<option selected="true" disabled>Выберете счёт</option>');
dropdown.prop('selectedIndex', 0);

const url = 'localhost:8016/money-transactions/banktransaction/accounts';

$.getJSON(url, function (data) {
    $.each(data, function (key, entry) {
        dropdown.append($('<option></option>').attr('value', entry.abbreviation).text(entry.name));
    })
});