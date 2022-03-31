<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <asset:stylesheet src="style.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;900&display=swap"
      rel="stylesheet"
    />
    <link
      rel="shortcut icon"
      href="https://www.asaas.com/assets/favicon-14e590c1a04095a343f34c60b0456560.ico"
      type="image/x-icon"
    />
    <title>Cadastro RocketCharger</title>
  </head>

  <body>
    <div class="container">
      <div class="header">
        <h2>Crie sua conta, é grátis!</h2>
        <img
          id="image"
          src="https://www.asaas.com/assets/favicon-14e590c1a04095a343f34c60b0456560.ico"
          alt="Imagem com a letra A e duas asas ao seus lados representando a logo em fundo azul e letra na cor branca"
        />
      </div>

      <form id="form" class="form">
        <div class="form-control">
          <label for="fullName">Nome Completo: *</label>
          <input
            type="text"
            id="fullName"
            placeholder="Ex: João da Silva"
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="idRegister">CPF *</label>
          <input
            type="text"
            id="idRegister"
            placeholder="Preencha seu CPF..."
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="cellphone">Seu Telefone com DDD *</label>
          <input type="text" id="cellphone" placeholder="Ex: 11 98765-4321" autocomplete="off" />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="email">Email *</label>
          <input type="email" id="email" 
          placeholder="Ex: meuemail@provedor.com" 
          autocomplete="off"/>
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="postalCode">CEP *</label>
          <input
            type="number"
            id="postalCode"
            placeholder="Digite o seu CEP..."
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="address">Endereço</label>
          <input
            type="text"
            id="address"
            placeholder="Digite o seu endereço residêncial..."
            disabled
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="houseNumber">Número *</label>
          <input
            type="text"
            id="houseNumber"
            placeholder="Informe o número de sua residência!"
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="complement">Complemento</label>
          <input
            type="text"
            id="complement"
            placeholder="Informe um complemento(opcional)"
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
        </div>

        <div class="form-control">
          <label for="province">Bairro *</label>
          <input
            type="text"
            id="province"
            placeholder="Informe o seu bairro..."
            disabled
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="city">Cidade *</label>
          <input
            type="text"
            id="city"
            placeholder="Informe a sua cidade..."
            disabled
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="state">Estado *</label>
          <input
            type="text"
            id="state"
            placeholder="Informe o seu estado..."
            disabled
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <button type="submit" id="button" onclick="checkAddress()">
          <strong>Enviar formulário</strong>
        </button>
      </form>
    </div>
    <script
      src="https://kit.fontawesome.com/c8d140aaae.js"
      crossorigin="anonymous"
    ></script>
    <asset:javascript src="form.js"/>
    <asset:javascript src="script.js"/>
  </body>
</html>
