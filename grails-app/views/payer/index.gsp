
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Gerenciamento de pagamentos</title>
</head>
<body>
    
    <div>
        <g:link controller="payer" action="create" update="divForm">Adicionar pagador</g:link>
    </div>

    <div id="divLista">
        <g:render template="list" model="[payerList: payerList]"></g:render>
    </div>
    <div id="divForm"></div>
    <g:paginate total="${totalCount}" controller="payer" action="index" params="${params}" next="Próximo" prev="Anterior" max="2" />

</body>
</html>