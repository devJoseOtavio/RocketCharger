<html lang="pt-br">
<head>
    <meta name="layout" content="main">
        <title>Adicionar pagador</title>
</head>
            <form data-redirect-url="${ g.createLink(controller: 'payer', action: 'index') }"
                  action="${ g.createLink(controller: 'payer', action: 'save') }">  
            <div><input type="text" name="name" placeholder="Ex: João Da Silva"></div>
            <div><input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ"></div>
            <div><input type="email" name="email" placeholder="Ex: email@meuprovedor.com"></div>
            <div><input type="text" name="postalCode" id="postalCode" placeholder="CEP" maxlength="8"></div>
            <div><input type="text" name="address" id="address" placeholder="Endereço"></div>
            <div><input type="text" name="district" id="district" placeholder="Bairro"></div>
            <div><input type="text" name="city" id="city" placeholder="Cidade"></div>
            <div><input type="text" name="state" id="state" placeholder="Estado"></div>
            <button type="submit">Salvar</button>
        </form>
    <asset:javascript src="payer/payerCreateSave.js" />
    <asset:javascript src= "utils/postalCodeApi.js" />
    </body>
</html>
