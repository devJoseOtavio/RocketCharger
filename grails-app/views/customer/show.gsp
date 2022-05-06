<html>
    <head>
        <title>Create customer</title>
        <asset:javascript src="formImports.js"/>
    </head>
    <body>
   <form data-redirect-url="${ g.createLink(controller: 'customer', action: 'customerPage') }"
         action="${ g.createLink(controller: 'customer', action: 'update') }" > 
        <input type="hidden" class="js-customer-id" name="id" value='${customer?.id}'>
        <input type="text" name="name" id="name" placeholder="Ex: João Da Silva" value="${customer?.name}" readonly><br>
        <input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" value="${customer?.cpfCnpj}" readonly><br>
        <input type="email" name="email" placeholder="Ex: email@meuprovedor.com" value="${customer?.email}" readonly><br>
        <input type="text" name="postalCode" id="postalCode" placeholder="CEP"value="${customer?.postalCode}" readonly><br>
        <input type="text" name="address" id="address" placeholder="Endereço"value="${customer?.address}" readonly><br>
        <input type="text" name="district" id="district" placeholder="Bairro"value="${ customer?.district}" readonly><br>
        <input type="text" name="city" id="city" placeholder="Cidade"value="${customer?.city}" readonly><br>
        <input type="text" name="state" id="state" placeholder="Estado"value="${customer?.state}" readonly><br>
        <button class="js-edit">Editar</button>
        <button type="submit" class="js-send-button hiddenBtn">Salvar</button>
        <button type="reset">Cancelar</button>
    </form> 
    <div>
        <g:link controller="payer" action="create" id='${customer.id}'><button>Criar pagador</button></g:link>
    </div>
    </body>
</html>


