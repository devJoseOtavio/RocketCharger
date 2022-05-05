<html>
    <head>
        <title>Create customer</title>
        <asset:stylesheet src="customer/show.css" />
        <asset:javascript src="application.js"/>
    </head>
    <body>
   <form data-redirect-url="${ g.createLink(controller: 'customer', action: 'index') }"
         action="${ g.createLink(controller: 'customer', action: 'update') }" > 
        <div><input type="hidden" class="js-customer-id" name="id" value='${customer?.id}'></div>
        <div><input type="text" name="name" id="name" placeholder="Ex: João Da Silva" value="${customer?.name}" readonly></div>
        <div><input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" value="${customer?.cpfCnpj}" readonly></div>
        <div><input type="email" name="email" placeholder="Ex: email@meuprovedor.com" value="${customer?.email}" readonly></div>
        <div><input type="text" name="postalCode" id="postalCode" placeholder="CEP"value="${customer?.postalCode}" readonly></div>
        <div><input type="text" name="address" id="address" placeholder="Endereço"value="${customer?.address}" readonly></div>
        <div><input type="text" name="district" id="district" placeholder="Bairro"value="${customer?.district}" readonly></div>
        <div><input type="text" name="city" id="city" placeholder="Cidade"value="${customer?.city}" readonly></div>
        <div><input type="text" name="state" id="state" placeholder="Estado"value="${customer?.state}" readonly></div>
        <button class="js-editCustomer">Editar</button>
        <button type="submit" class="js-send-button hiddenBtn">Salvar</button>
        <button type="reset" class="js-cancel-button">Cancelar</button>
    </form> 
    </body>
</html>
