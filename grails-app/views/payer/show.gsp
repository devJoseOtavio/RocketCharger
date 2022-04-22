
<html>
<head>
    <title>Gerenciamento de pagamentos</title>
    <asset:javascript src="application.js"/>
    <asset:stylesheet src="payer/edit.css" />
    <asset:javascript src="payer/payerEdit.js" />
    <asset:javascript src="payer/payerCreateSave.js" />  
</head>
<body>
    <form action="${ g.createLink(controller: 'payer', action: 'save') }" > 
        <input type="hidden" class="js-payer-id" name="id" value="1">
        <input type="text" name="name" id="name" placeholder="Ex: João Da Silva" value="${ payer.name}" readonly><br>
        <input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" value="${ payer.cpfCnpj}" readonly><br>
        <input type="email" name="email" placeholder="Ex: email@meuprovedor.com" value="${ payer.email}" readonly><br>
        <input type="text" name="postalCode" id="postalCode" placeholder="CEP"value="${ payer.postalCode}" readonly><br>
        <input type="text" name="address" id="address" placeholder="Endereço"value="${ payer.address}" readonly><br>
        <input type="text" name="province" id="province" placeholder="Bairro"value="${ payer.province}" readonly><br>
        <input type="text" name="city" id="city" placeholder="Cidade"value="${ payer.city}" readonly><br>
        <input type="text" name="state" id="state" placeholder="Estado"value="${ payer.state}" readonly><br>
        <button class="js-editPayer">Editar</button>
        <button type="submit" class="js-send-button hiddenBtn">Salvar</button>
    </form> 
</body>
</html>