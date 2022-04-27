$(document).ready(function () {
  $("form").on("submit", function (e) {
    e.preventDefault();

    var data = new FormData(document.querySelector("form"));
    var payer = {};

    data.forEach(function (value, key) {
      payer[key] = value;
    });

    var url = $("form").prop("action");

<<<<<<< HEAD:grails-app/assets/javascripts/customer/customerCreateUpdate.js
    $.post(url, customer, function (response) {
      console.log(response);
      if (response.success) {
        window.location.href = "/customer";
=======
    $.post(url, payer, function (response) {
      if (response.success) {
        window.location.href = $("form").data("redirect-url");
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc:grails-app/assets/javascripts/payer/payerCreateSave.js
        return;
      }
    });
  });
});