<html>
    <head>
    <title>Adicionar pagador</title>
    <asset:javascript src="application.js"/>
    </head>
    <body>
        <form action="${ g.createLink(controller: 'payer', action: 'save') }"> 
            <input type="text" name="name" id="name" placeholder="Ex: João Da Silva" required><br>
            <input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" required><br>
            <input type="email" name="email" placeholder="Ex: email@meuprovedor.com" required><br>
            <input type="text" name="postalCode" id="postalCode" placeholder="CEP" required><br>
            <input type="text" name="address" id="address" placeholder="Endereço" required><br>
            <input type="text" name="province" id="province" placeholder="Bairro" required><br>
            <input type="text" name="city" id="city" placeholder="Cidade" required><br>
            <input type="text" name="state" id="state" placeholder="Estado" required><br>
            <button type="submit">Criar</button>
        </form>
    <asset:javascript src="payer/payerCreateSave.js" />
    <asset:javascript src="newPostalCode-api.js" />
    </body>
</html>
