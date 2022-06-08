<html>
<head>
    <asset:javascript src="applications/applicationRegisterLoginAndLogout.js"/>
    <title>Register</title>
</head>
<body>
  <form class="form-signin" action="register" method="POST" id="loginForm" autocomplete="off">
    <div>
      <label for="username">Email</label>
      <input type="text" class="form-control" name="username" id="username" autocapitalize="none"/>
    </div>
    <div>
      <label for="password">Senha</label>
      <input type="password" class="form-control" name="password" id="password"/>
    </div>
    <div>
      <label for="password">Confirmar sua senha</label>
      <input type="password" class="form-control" name="repassword" id="repassword"/>
    </div>
    <div>
        <input type="checkbox"/> Li e concordo com os <a href="https://ajuda.asaas.com/pt-BR/articles/102021-termos-e-condicoes-de-uso" target="_blank">Termos de uso do RocketCharger</a>
    </div>
    <button id="submit" type="submit">Criar conta</button>
    <hr class="my-4">
    <p>Já tem uma conta? <g:link controller="login" action="auth">Entre aqui</g:link></p>
  </form>
</body>
</html>