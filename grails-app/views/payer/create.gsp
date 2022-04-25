<html lang="pt-br">
<head>
    <title>Adicionar pagador</title>
    <asset:javascript src="application.js"/>
</head>
        <form action="${ g.createLink(controller: 'payer', action: 'save') }"> 
            <input type="text" name="name" placeholder="Ex: João Da Silva"><br>
            <input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ"><br>
            <input type="email" name="email" placeholder="Ex: email@meuprovedor.com"><br>
            <input type="text" name="postalCode" id="postalCode" placeholder="CEP" maxlength="8"><br>
            <input type="text" name="address" id="address" placeholder="Endereço"><br>
            <input type="text" name="district" id="district" placeholder="Bairro"><br>
            <input type="text" name="city" id="city" placeholder="Cidade"><br>
            <input type="text" name="state" id="state" placeholder="Estado"><br>
            <button type="submit">Salvar</button>
        </form>
    <asset:javascript src="payerCreateSave/payerCreateSave.js" />
    <asset:javascript src="payerCreateSave/payerPostalCode-api.js" />
    </body>
</html>
