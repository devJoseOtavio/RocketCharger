const form = document.getElementById("form");
const cName = document.getElementById("cName");
const cpfCnpj = document.getElementById("cpfCnpj");
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
cName.addEventListener("input", (event) => {
  checkName();
});

cpfCnpj.addEventListener("input", (event) => {
  let cpfCnpjValue = cpfCnpj.value;
  if (cpfCnpjValue.length == 11) {
    checkCpf();
  } else {
    checkCnpj();
  }
});

cellphone.addEventListener("input", (event) => {
  checkCellphone();
});

postalCode.addEventListener("input", (event) => {
  checkPostal_code();
  checkAddress();
});

houseNumber.addEventListener("input", (event) => {
  checkHouse_number();
});

email.addEventListener("input", (event) => {
  checkEmail();
});

function checkName() {
  const cNameValue = cName.value;
  if (cNameValue === "") {
    setErrorFor(cName, "O seu nome é obrigatório!");
  } else {
    setSucessFor(cName);
  }
}

function checkCpf() {
  let cpfCnpjValue = cpfCnpj.value;
  if (!cpfCnpjValue) {
    setErrorFor(cpfCnpj, "Preencha seu CPF");
  } else if (
    cpfCnpjValue.length !== 11 ||
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

function checkCnpj() {
  let cpfCnpjValue = cpfCnpj.value;
  if (
    cpfCnpjValue.length !== 14 ||
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
  } else if (cellphoneValue.length !== 11) {
    setErrorFor(cellphone, "Número inválido");
  } else {
    setSucessFor(cellphone);
  }
}

function checkPostal_code() {
  let postalCodeValue = postalCode.value;
  if (!postalCodeValue) {
    setErrorFor(postalCode, "Favor informar o CEP!");
  } else if (postalCodeValue.length !== 8) {
    setErrorFor(postalCode, "O CEP informado está incorreto");
  } else {
    setSucessFor(postalCode);
  }
}
function checkHouse_number() {
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
  checkCpf();
  if (cpfCnpjValue.length == 11) {
    checkCpf();
  } else {
    checkCnpj();
  }
  checkCellphone();
  checkPostal_code();
  checkHouse_number();
  checkEmail();

  let formControls = form.querySelectorAll(".form-control");
  let formIsValid = [...formControls].every((formControl) => {
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

  small.innerText = message;
  formControl.className = "form-control error";
}

function setSucessFor(input) {
  let formControl = input.parentElement;
  formControl.className = "form-control success";
}

function returnInfos() {
  return {
    name: cName.value,
    cpf_cnpj: cpfCnpj.value,
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
