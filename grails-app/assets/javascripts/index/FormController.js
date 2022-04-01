const form = document.getElementById("form");
const fullName = document.getElementById("fullName");
const idRegister = document.getElementById("idRegister");
const cellphone = document.getElementById("cellphone");
const postalCode = document.getElementById("postalCode");
const email = document.getElementById("email");
const address = document.getElementById("address");
const houseNumber = document.getElementById("houseNumber");
const birthDate = document.getElementById("birthDate");
const complement = document.getElementById("complement");
const province = document.getElementById("province");
const city = document.getElementById("city");
const state = document.getElementById("state");

form.addEventListener("submit", (event) => {
  event.preventDefault();
  checkInput();
});

fullName.addEventListener("input", () => {
  checkName();
});

idRegister.addEventListener("input", () => {
  checkId();
});

cellphone.addEventListener("input", () => {
  checkCellphone();
});

postalCode.addEventListener("input", () => {
  checkPostal_code();
  checkAddress();
});

houseNumber.addEventListener("input", () => {
  checkHouse_number();
});

email.addEventListener("input", () => {
  checkEmail();
});

// VALIDAÇÕES!!!
function checkName() {
  let fullNameValue = fullName.value;
  if (!fullNameValue) {
    setErrorFor(fullName, "O seu nome é obrigatório!");
  } else {
    setSucessFor(fullName);
  }
}

function checkId() {
  let idRegisterValue = idRegister.value;
  if (!idRegisterValue) {
    setErrorFor(idRegister, "Preencha seu CPF!");
  } else if (
    idRegisterValue.length !== 11 ||
    idRegisterValue == "00000000000" ||
    idRegisterValue == "11111111111" ||
    idRegisterValue == "22222222222" ||
    idRegisterValue == "33333333333" ||
    idRegisterValue == "44444444444" ||
    idRegisterValue == "55555555555" ||
    idRegisterValue == "66666666666" ||
    idRegisterValue == "77777777777" ||
    idRegisterValue == "88888888888" ||
    idRegisterValue == "99999999999"
  ) {
    setErrorFor(idRegister, "O cpf informado é inválido!");
  } else {
    setSucessFor(idRegister);
  }
}

function checkEmail() {
  let emailValue = email.value;
  if (!emailValue) {
    setErrorFor(email, "O email é obrigatório!");
  } else {
    setSucessFor(email);
  }
}

function checkCellphone() {
  let cellphoneValue = cellphone.value;
  if (!cellphoneValue) {
    setErrorFor(cellphone, "Digite seu número de telefone!");
  } else if (cellphoneValue.length <= 10) {
    setErrorFor(cellphone, "Número inválido!");
  } else {
    setSucessFor(cellphone);
  }
}

function checkPostal_code() {
  let postalCodeValue = postalCode.value;
  if (!postalCodeValue) {
    setErrorFor(postalCode, "Favor informar o CEP!");
  } else if (postalCodeValue.length !== 8) {
    setErrorFor(postalCode, "O CEP informado está incorreto...");
  } else {
    setSucessFor(postalCode);
  }
}
function checkHouse_number() {
  let houseNumberValue = houseNumber.value;
  if (!houseNumberValue) {
    setErrorFor(houseNumber, "Favor informar número da residência!");
  } else {
    setSucessFor(houseNumber);
  }
}

function checkInput() {
  checkName();
  checkId();
  checkCellphone();
  checkPostal_code();
  checkHouse_number();
  checkEmail();

  let formControls = form.querySelectorAll(".form-control");
  let formIsValid = [...formControls].every((formControl) => {
    //transformando em array
    return formControl.className === "form-control success";
  });

  if (formIsValid) {
    alert("Formulário enviado!");
    console.log("O formulário foi enviado");
    console.log(returnInfos());
  }
}

function setErrorFor(input, message) {
  let formControl = input.parentElement;
  let small = formControl.querySelector("small");

  //msg de erro
  small.innerText = message;

  //add class erro
  formControl.className = "form-control error";
}

function setSucessFor(input) {
  let formControl = input.parentElement;
  //Adicionar a classe de sucesso
  formControl.className = "form-control success";
}

function returnInfos() {
  return {
    name: fullName.value,
    id: idRegister.value,
    contact: cellphone.value,
    postal_Code: postalCode.value,
    email: email.value,
    address: address.value,
    houseNumber: houseNumber.value,
    complement: complement.value,
    province: province.value,
    city: city.value,
    state: state.value,
  };
}
