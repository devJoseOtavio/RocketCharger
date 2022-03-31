function checkAddress() {
  let postalCode = document.querySelector("#postalCode").value;
  let url = `https://viacep.com.br/ws/${postalCode}/json/`;

  fetch(url).then(function (response) {
    response.json().then(showAddress);
  });
}

function showAddress(data) {
  const address = document.querySelector("#address");
  const province = document.querySelector("#province");
  const state = document.querySelector("#state");
  const city = document.querySelector("#city");
  const complement = document.getElementById("complement");

  if (data.erro) {
    setErrorFor(postalCode, "Não foi possível localizar o endereço"),
      (address.value = ""),
      (province.value = ""),
      (state.value = ""),
      (city.value = "");
  } else {
    setSucessFor(postalCode),
      setSucessFor(address),
      setSucessFor(province),
      setSucessFor(state),
      setSucessFor(city),
      setSucessFor(complement);
    address.value = `${data.logradouro}`;
    province.value = `${data.bairro}`;
    state.value = `${data.uf}`;
    city.value = `${data.localidade}`;
  }
}
