function postalCodeApi() {
  var teste = this;

  document
    .getElementById("postalCode")
    .addEventListener("input", PostalCodeApi);

  teste.getPostalCodeInfo = function (postalCode) {
    var postalCode = document.querySelector("#postalCode").value;
    let correctPostalCodeLength = 8;
    if (postalCode.length == correctPostalCodeLength) {
      let url = `https://viacep.com.br/ws/${postalCode}/json/`;

      fetch(url).then(function (response) {
        return response;
      });
    }
  };
}

var PostalCodeApi;

$(document).ready(function () {
  PostalCodeApi = new postalCodeApi();
});

PostalCodeApi.getPostalCodeInfo(postalCode);
// function checkAddress() {
//   var postalCode = document.querySelector("#postalCode").value;
//   let correctPostalCodeLength = 8;
//   if (postalCode.length == correctPostalCodeLength) {
//     let url = `https://viacep.com.br/ws/${postalCode}/json/`;

//     fetch(url).then(function (response) {
//       response.json().then(showAddress);
//     });
//   }
// }

// function showAddress(data) {
//   if (!data.erro) {
//     let address = document.querySelector("#address");
//     let district = document.querySelector("#district");
//     let state = document.querySelector("#state");
//     let city = document.querySelector("#city");
//     address.value = `${data.logradouro}`;
//     district.value = `${data.bairro}`;
//     state.value = `${data.uf}`;
//     city.value = `${data.localidade}`;
//   }
// }
