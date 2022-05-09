<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Gerenciamento da conta</title>
</head>
<body>
    
    <div>
        <g:link controller="customer" action="create" update="divForm">Criando conta</g:link>
    </div>

    <div id="divLista">
        <g:render template="list" model="[customerList: customerList]"></g:render>
    </div>
    <div id="divForm"></div>
    <a href="/payer">Meus Clientes</a>

</body>
</html>