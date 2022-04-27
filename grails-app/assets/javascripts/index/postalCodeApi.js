function checkAddress() {
  let postalCode = document.querySelector("#postalCode").value;
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
  let district = document.querySelector("#district");
  let state = document.querySelector("#state");
  let city = document.querySelector("#city");
  let complement = document.getElementById("complement");

  if (!data.erro) {
    setSucessFor(postalCode),
      setSucessFor(address),
      setSucessFor(district),
      setSucessFor(state),
      setSucessFor(city),
      setSucessFor(complement);
    address.value = `${data.logradouro}`;
    district.value = `${data.bairro}`;
    state.value = `${data.uf}`;
    city.value = `${data.localidade}`;
  }

  setErrorFor(postalCode, "Não foi possível localizar o endereço")
    (address.value = "");
  district.value = "";
  state.value = "";
  city.value = "";
}
