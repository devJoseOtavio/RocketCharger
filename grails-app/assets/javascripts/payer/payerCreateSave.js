$(document).ready(function () {
  $("form").on("submit", function (e) {
    e.preventDefault();

    var data = new FormData(document.querySelector("form"));
    var payer = {};

    data.forEach(function (value, key) {
      payer[key] = value;
    });

    payer.customerId = getCookie("customerId");

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

  function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(";");
    for (let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == " ") {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }
});
