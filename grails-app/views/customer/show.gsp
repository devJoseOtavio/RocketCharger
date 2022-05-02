<html>
    <head>
        <title>Create customer</title>
        <asset:javascript src="application.js"/>
    </head>
    <body>
   <form data-redirect-url="${ g.createLink(controller: 'customer', action: 'index') }"
         action="${ g.createLink(controller: 'customer', action: 'update') }" > 
        <input type="hidden" class="js-customer-id" name="id" value='${customer?.id}'>
        <input type="text" name="name" id="name" placeholder="Ex: João Da Silva" value="${ customer?.name}" readonly><br>
        <input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" value="${ customer?.cpfCnpj}" readonly><br>
        <input type="email" name="email" placeholder="Ex: email@meuprovedor.com" value="${ customer?.email}" readonly><br>
        <input type="text" name="postalCode" id="postalCode" placeholder="CEP"value="${ customer?.postalCode}" readonly><br>
        <input type="text" name="address" id="address" placeholder="Endereço"value="${ customer?.address}" readonly><br>
        <input type="text" name="province" id="province" placeholder="Bairro"value="${ customer?.province}" readonly><br>
        <input type="text" name="city" id="city" placeholder="Cidade"value="${ customer?.city}" readonly><br>
        <input type="text" name="state" id="state" placeholder="Estado"value="${ customer?.state}" readonly><br>
        <button class="js-editCustomer">Editar</button>
        <button type="submit" class="js-send-button hiddenBtn">Salvar</button>
        <%-- <a href=" ${ g.createLink(controller: 'payer', action:'create', params: [id: customer.id]]) }">teste</a> --%>
        <a href=" ${ g.createLink(controller: 'payer', action:'index', params: [id: customer?.id]]) }">teste</a>
        
    </form> 
    <asset:stylesheet src="customer/show.css" />
    <asset:javascript src="customer/customerEdit.js" />
    <asset:javascript src="customer/customerCreateSave.js" />
    </body>
</html>


