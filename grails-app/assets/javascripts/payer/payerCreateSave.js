$(document).ready(function () {
  $("form").on("submit", function (e) {
    e.preventDefault();

    var data = new FormData(document.querySelector("form"));
    var payer = {};

    data.forEach(function (value, key) {
      payer[key] = value;
    });

    var url = $("form").prop("action");

    $.post(url, payer, function (response) {
      if (response.success) {
        window.location.href = $("form").data("redirect-url");
      }
    });
  });
  var postalCode = document.getElementById("postalCode");
  if (postalCode) {
    postalCode.addEventListener("input", function () {
      if (validatePostalCode(this.value)) {
        getPostalCode(this.value, fillAddress);
      }
    });
  }

  function fillAddress(data) {
    if (!data.erro) {
      document.querySelector("#address").value = data.logradouro;
      document.querySelector("#district").value = data.bairro;
      document.querySelector("#city").value = data.localidade;
      document.querySelector("#state").value = data.uf;
    }
  }
});
