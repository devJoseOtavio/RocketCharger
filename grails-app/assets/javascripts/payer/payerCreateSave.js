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
      if (!response.success) {
        alert(`Erro ao realizar requisição, contate o administrador.`)
        return;
      }
      window.location.href = $("form").data("redirect-url");
    }); 
  });

  var postalCode = document.getElementById("postalCode");

  postalCode.addEventListener("input", function () {
    if (!postalCode) {
      return;
    }
    validatePostalCode(this.value), getPostalCode(this.value, fillAddress);
  });

  function fillAddress(data) {
      document.querySelector("#address").value = data.logradouro ? data.logradouro :  "";
      document.querySelector("#district").value = data.bairro ? data.bairro : "";
      document.querySelector("#city").value = data.localidade ? data.localidade : "";
      document.querySelector("#state").value = data.uf ? data.uf : "";
        if (data.erro) {
          alert(`O cep ${postalCode.value} não foi localizado.`);
        }
  }
});

