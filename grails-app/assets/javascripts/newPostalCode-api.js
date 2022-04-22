document.getElementById("postalCode").addEventListener("input", checkAddress);

function checkAddress() {
  var postalCode = document.querySelector("#postalCode").value;
  let correctPostalCodeLength = 8;
  if (postalCode.length == correctPostalCodeLength) {
    let url = `https://viacep.com.br/ws/${postalCode}/json/`;

    fetch(url).then(function (response) {
      response.json().then(showAddress);
    });
  }
}

function showAddress(data) {
  let address = document.querySelector("#address");
  let province = document.querySelector("#province");
  let state = document.querySelector("#state");
  let city = document.querySelector("#city");

  if (!data.erro) {
    address.value = `${data.logradouro}`;
    province.value = `${data.bairro}`;
    state.value = `${data.uf}`;
    city.value = `${data.localidade}`;
    return;
  }
}
