function FormValidationsController() {
  this.init = function () {
    var form = document.querySelector("form");
    var customerName = document.getElementById("name");
    var cpfCnpj = document.getElementById("cpfCnpj");
    var cellphone = document.getElementById("cellphone");
    var postalCode = document.getElementById("postalCode");
    var email = document.getElementById("email");
    var address = document.getElementById("address");
    var houseNumber = document.getElementById("houseNumber");
    var complement = document.getElementById("complement");
    var district = document.getElementById("district");
    var city = document.getElementById("city");
    var state = document.getElementById("state");
    var correctCpfLength = 11;
    var correctCnpjLength = 14;
    var correctCellphoneLength = 11;

    form.addEventListener("submit", (event) => {
      checkInput();
    });

    customerName.addEventListener("focusout", (event) => {
      checkName();
    });

    cpfCnpj.addEventListener("focusout", (event) => {
      let cpfCnpjValue = cpfCnpj.value;
      let sizeCpfCnpjValue = cpfCnpjValue.length;
      if (sizeCpfCnpjValue == correctCpfLength) {
        checkCpf();
      } else {
        checkCnpj();
      }
    });

    cellphone.addEventListener("focusout", (event) => {
      checkCellphone();
    });

    postalCode.addEventListener("focusout", (event) => {
      checkPostalCode();
      validatePostalCode();
    });

    houseNumber.addEventListener("focusout", (event) => {
      checkHouseNumber();
    });

    email.addEventListener("focusout", (event) => {
      checkEmail();
    });

    function checkName() {
      let customerNameValue = customerName.value;
      if (!customerNameValue) {
        setErrorFor(customerName, "O seu nome é obrigatório!");
      } else {
        setSucessFor(customerName);
      }
    }

    function checkCpf() {
      let cpfCnpjValue = cpfCnpj.value;
      let sizeCpfCnpjValue = cpfCnpjValue.length;
      if (sizeCpfCnpjValue == correctCpfLength) {
        if (!cpfCnpjValue) {
          setErrorFor(cpfCnpj, "Preencha seu CPF");
        } else if (
          cpfCnpjValue.length !== correctCpfLength ||
          cpfCnpjValue == "00000000000" ||
          cpfCnpjValue == "11111111111" ||
          cpfCnpjValue == "22222222222" ||
          cpfCnpjValue == "33333333333" ||
          cpfCnpjValue == "44444444444" ||
          cpfCnpjValue == "55555555555" ||
          cpfCnpjValue == "66666666666" ||
          cpfCnpjValue == "77777777777" ||
          cpfCnpjValue == "88888888888" ||
          cpfCnpjValue == "99999999999"
        ) {
          setErrorFor(cpfCnpj, "O cpf informado é inválido");
        } else {
          setSucessFor(cpfCnpj);
        }
      }
    }

    function checkCnpj() {
      let cpfCnpjValue = cpfCnpj.value;
      if (
        cpfCnpjValue.length !== correctCnpjLength ||
        cpfCnpjValue == "00000000000000" ||
        cpfCnpjValue == "11111111111111" ||
        cpfCnpjValue == "22222222222222" ||
        cpfCnpjValue == "33333333333333" ||
        cpfCnpjValue == "44444444444444" ||
        cpfCnpjValue == "55555555555555" ||
        cpfCnpjValue == "66666666666666" ||
        cpfCnpjValue == "77777777777777" ||
        cpfCnpjValue == "88888888888888" ||
        cpfCnpjValue == "99999999999999"
      ) {
        setErrorFor(cpfCnpj, "O CNPJ informado é inválido");
      } else {
        setSucessFor(cpfCnpj);
      }
    }

    function checkEmail() {
      let emailValue = email.value;
      if (!emailValue) {
        setErrorFor(email, "O email é obrigatório");
      } else {
        setSucessFor(email);
      }
    }

    function checkCellphone() {
      let cellphoneValue = cellphone.value;
      if (!cellphoneValue) {
        setErrorFor(cellphone, "Digite seu número de telefone");
      } else if (cellphoneValue.length !== correctCellphoneLength) {
        setErrorFor(cellphone, "Número inválido");
      } else {
        setSucessFor(cellphone);
      }
    }

    function checkPostalCode() {
      let postalCodeValue = postalCode.value;
      if (!postalCodeValue) {
        setErrorFor(postalCode, "Favor informar o CEP!");
      } else {
        setSucessFor(postalCode);
      }
    }
    function checkHouseNumber() {
      let houseNumberValue = houseNumber.value;
      if (!houseNumberValue) {
        setErrorFor(houseNumber, "Favor informar número da residência");
      } else {
        setSucessFor(houseNumber);
      }
    }

    function checkInput() {
      let cpfCnpjValue = cpfCnpj.value;
      checkName();
      if (cpfCnpjValue.length == correctCpfLength) {
        checkCpf();
      } else {
        checkCnpj();
      }
      checkCellphone();
      checkPostalCode();
      checkHouseNumber();
      checkEmail();

      let formControls = form.querySelectorAll(".form-control");
      let formIsValid = [...formControls].every((formControl) => {
        return formControl.className === "form-control success";
      });

      if (formIsValid) {
        let infosCustomer = {};
        let data = new FormData(form);
        data.forEach(function (value, key) {
          infosCustomer[key] = value;
        });
        customerName.focus();
      }
    }

    document
      .getElementById("postalCode")
      .addEventListener("input", function () {
        if (validatePostalCode(this.value)) {
          getPostalCode(this.value, fillAddress);
        }
      });

    function fillAddress(data) {
      if (data.erro) {
        setErrorFor(postalCode, "Não foi possível localizar o endereço");
        address.value = "";
        district.value = "";
        state.value = "";
        city.value = "";
        document.querySelector("#address").value = "";
        document.querySelector("#district").value = "";
        document.querySelector("#city").value = "";
        document.querySelector("#state").value = "";
        return;
      }
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
    }

    function setSucessFor(input) {
      let formControl = input.parentElement;

      $(formControl).addClass("form-control success").removeClass("error");
    }

    function setErrorFor(input, message) {
      let formControl = input.parentElement;
      let smallDisplayError = formControl.querySelector(".js-msg");

      smallDisplayError.innerText = message;
      $(formControl).addClass("form-control error").removeClass("success");
    }
  };
}
var formValidationsController;

$(document).ready(function () {
  formValidationsController = new FormValidationsController();
  formValidationsController.init();
});
