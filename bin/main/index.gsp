  <head>
  <asset:stylesheet src="style.css" />
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
          <label for="nomeCompleto">Nome Completo: *</label>
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
          <label for="cpf">CPF *</label>
          <input
            type="text"
            id="idRegister"
            placeholder="Preencha seu CPF"
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="telefoneCelular">Seu Telefone com DDD *</label>
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
          <label for="cep">CEP *</label>
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
          <label for="endereco">Endereço</label>
          <input
            type="text"
            id="address"
            placeholder="Digite o seu endereço residêncial"
            disabled
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="numeroCasa">Número *</label>
          <input
            type="text"
            id="houseNumber"
            placeholder="Informe o número de sua residência"
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <div class="form-control">
          <label for="complemento">Complemento</label>
          <input
            type="text"
            id="complement"
            placeholder="Informe um complemento (opcional)"
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
            placeholder="Informe o seu bairro"
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
            placeholder="Informe a sua cidade"
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
            placeholder="Informe o seu estado"
            disabled
            autocomplete="off"
          />
          <i class="fas fa-exclamation-circle"></i>
          <i class="fas fa-check-circle"></i>
          <small>Mensagem de erro</small>
        </div>

        <button type="submit" id="button">
          <strong>Enviar formulário</strong>
        </button>
      </form>
    </div>
    <script
      src="https://kit.fontawesome.com/c8d140aaae.js"
      crossorigin="anonymous"
    ></script>
    <asset:javascript src="index/FormController.js"/>
    <asset:javascript src="index/postalCode-api.js"/>
  </body>
</html>
