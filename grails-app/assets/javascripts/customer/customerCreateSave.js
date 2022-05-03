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
      console.log(response);
      if (response.success) {
        setCookie("customerId", response.id, 365);
        window.location.href = $("form").data("redirect-url");
        return;
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

  function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + exdays * 24 * 60 * 60 * 1000);
    let expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }
});
