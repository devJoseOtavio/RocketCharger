<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Gerenciamento de pagamentos</title>
</head>
<body>
    
    <div>
        <g:link controller="payment" action="create" update="divForm">Adicionar cobrança</g:link>
    </div>

    <div id="divLista">
        <g:render template="list" model="[paymentList: paymentList]"></g:render>
    </div>
    <div id="divForm"></div>
  <g:paginate total="${totalCount}" controller="payment" action="index" params="${params}" next="Próximo" prev="Anterior" max="2" />

</body>
</html>