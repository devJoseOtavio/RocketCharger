function CustomerCreateController() {
  this.init = function () {
    $(document).ready(function () {
      $("form").on("submit", function (e) {
        e.preventDefault();

        var data = new FormData(document.querySelector("form"));
        var customer = {};

        data.forEach(function (value, key) {
          customer[key] = value;
        });

        var url = $("form").prop("action");

        $.post(url, customer, function (response) {
          if (!response.success) {
            alert("Erro ao realizar requisição, contate o administrador.");
            return;
          }
          window.location.href = $("form").data("redirect-url");
        });
      });
    });
  };
}
var customerCreateController;

$(document).ready(function () {
  customerCreateController = new CustomerCreateController();
  customerCreateController.init();
});
