
<html>
<head>
    <title>Gerenciamento de pagamentos</title>
</head>
    <asset:javascript src="application.js"/>
<body>
<<<<<<< HEAD
    <form action="${ g.createLink(controller: 'payer', action: 'save') }" > 
        <input type="hidden" class="js-payer-id" name="id" value="1">
=======
    <form data-redirect-url="${ g.createLink(controller: 'payer', action: 'index') }" 
          action="${ g.createLink(controller: 'payer', action: 'update') }" >
        <input type="hidden" class="js-payer-id" name="id" value="${payer.id}">
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc
        <input type="text" name="name" id="name" placeholder="Ex: João Da Silva" value="${ payer.name}" readonly><br>
        <input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" value="${ payer.cpfCnpj}" readonly><br>
        <input type="email" name="email" placeholder="Ex: email@meuprovedor.com" value="${ payer.email}" readonly><br>
        <input type="text" name="postalCode" id="postalCode" placeholder="CEP"value="${ payer.postalCode}" readonly><br>
        <input type="text" name="address" id="address" placeholder="Endereço"value="${ payer.address}" readonly><br>
<<<<<<< HEAD
        <input type="text" name="province" id="province" placeholder="Bairro"value="${ payer.province}" readonly><br>
=======
        <input type="text" name="district" id="district" placeholder="Bairro"value="${ payer.district}" readonly><br>
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc
        <input type="text" name="city" id="city" placeholder="Cidade"value="${ payer.city}" readonly><br>
        <input type="text" name="state" id="state" placeholder="Estado"value="${ payer.state}" readonly><br>
        <button class="js-editPayer">Editar</button>
        <button type="submit" class="js-send-button hiddenBtn">Salvar</button>
    </form> 
    
    <asset:stylesheet src="payer/edit.css" />
    <asset:javascript src="payer/payerEdit.js" />
    <asset:javascript src="payer/payerCreateSave.js" /> 
<<<<<<< HEAD
    <asset:javascript src="newPostalCode-api.js" />
=======
    <asset:javascript src="newPostalCodeAzzzzpi.js" />
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc
</body>
</html>