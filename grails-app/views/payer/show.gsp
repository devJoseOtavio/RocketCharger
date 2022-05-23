<html>
<head>
    <title>Gerenciamento de pagamentos</title>
    <asset:javascript src="applications/applicationForm.js"/>
    <asset:stylesheet src="customer/show.css" />
</head>
<body>
    <form data-redirect="${ g.createLink(controller: "payer", action: "index", params: [id: payer.customer.id]) }" 
          data-url="${ g.createLink(controller: "payer", action: "update") }" >
        <input type="hidden" class="js-payer-id" name="id" value="${payer?.id}">
        <input type="text" name="name" id="name" placeholder="Ex: João Da Silva" value="${payer?.name}" readonly><br>
        <input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" value="${payer?.cpfCnpj}" readonly><br>
        <input type="email" name="email" placeholder="Ex: email@meuprovedor.com" value="${payer?.email}" readonly><br>
        <input type="text" name="postalCode" id="postalCode" placeholder="CEP"value="${payer?.postalCode}" readonly><br>
        <input type="text" name="address" id="address" placeholder="Endereço"value="${payer?.address}" readonly><br>
        <input type="text" name="district" id="district" placeholder="Bairro"value="${payer?.district}" readonly><br>
        <input type="text" name="city" id="city" placeholder="Cidade"value="${payer?.city}" readonly><br>
        <input type="text" name="state" id="state" placeholder="Estado"value="${payer?.state}" readonly><br>
        <button class="js-edit">Editar</button>
        <button type="submit" class="js-send-button hide">Salvar</button>
        <button type="reset">Cancelar</button>
    </form> 
</body>
</html>