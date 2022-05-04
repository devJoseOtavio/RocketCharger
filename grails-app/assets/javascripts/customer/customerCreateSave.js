$(document).ready(function () {
  $("form").on("submit", function (e) {
    e.preventDefault();

    var data = new FormData(document.querySelector("form"));
    var customer = {};

    data.forEach(function (value, key) {
      customer[key] = value;
    });

    var redirect;

    if ($(this).find(".js-customer-id").val()) {
      redirect = "/customer/update";
    } else {
      redirect = "/customer/save";
    }

    $.post(redirect, customer, function (response) {
      if (!response.success) {
          alert('Erro ao realizar requisiao, contate o adiministrador')
      }
        window.location.href = "/customer/index";
        return;
    });
  });
});