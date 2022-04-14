<!DOCTYPE html>
<html lang="en">
<head>
    <title>Gerenciamento de pagamentos</title>
</head>
<body>
    
    <div>
        <g:link controller="payer" action="adicionar" update="divForm">Adicionar pagador</g:link>
    </div>

    <div id="divLista">
        <g:render template="lista" model="[payerList: payerList]"></g:render>
    </div>

    <div id="divForm"></div>

</body>
</html>