<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="Layout" content="main"/>
    <title>Gerenciamento de pagamentos</title>
    <g:javascript library="jquery"/>
</head>
<body>
    
    <g:link controller="payer" action="adicionar" update="divForm">Adicionar pagador</g:link>
    <div id="divLista">
        <g:render template="lista" model="[payerList: payerList]"></g:render>
    </div>

    <div id="divForm"></div>

</body>
</html>