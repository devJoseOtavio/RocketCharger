function getPostalCode() {
  var postalCode = document.querySelector("#postalCode").value;
  var correctPostalCodeLength = 8;
  if (postalCode.length == correctPostalCodeLength) {
    fetch(`https://viacep.com.br/ws/${postalCode}/json`)
      .then((result) => result.json())
      .then((data) => {
        if (!("erro" in data)) {
          setSucessFor(postalCode);
          setSucessFor(address);
          setSucessFor(district);
          setSucessFor(state);
          setSucessFor(city);
          setSucessFor(complement);
          document.querySelector("#address").value = data.logradouro;
          document.querySelector("#district").value = data.bairro;
          document.querySelector("#city").value = data.localidade;
          document.querySelector("#state").value = data.uf;
        } else {
          setErrorFor(postalCode, "Não foi possível localizar o endereço");
          address.value = "";
          district.value = "";
          state.value = "";
          city.value = "";
          alert("CEP não encontrado");
          document.querySelector("#address").value = "";
          document.querySelector("#district").value = "";
          document.querySelector("#city").value = "";
          document.querySelector("#state").value = "";
        }
      });
  }
}
