<html>
<head>
    <title>Register</title>
    <asset:javascript src="applications/applicationRegisterLoginAndLogout.js"/>
</head>
<body>
  <h5>Registrar aqui</h5>
    <g:if test='${flash.message}'>
        <div class="alert alert-danger" role="alert">${flash.message}</div>
    </g:if>
    <form class="form-signin" action="register" method="POST" id="loginForm" autocomplete="off">

      <div>
        <label for="username">email</label>
        <input type="email" class="form-control" name="username" id="username" autocapitalize="none"/>
      </div>

      <div>
        <label for="password">Senha</label>
        <input type="password" class="form-control" name="password" id="password"/>
      </div>

      <div>
        <label for="password">Confirmar senha</label>
        <input type="password" class="form-control" name="repassword" id="repassword"/>
      </div>
      <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Criar conta</button>
      <hr class="my-4">
      <p>Já tem uma conta? <g:link controller="login" action="auth">Login</g:link></p>
  </form>
</body>
</html>