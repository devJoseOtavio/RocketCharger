<html>
    <head>
    <title>Adicionar pagador</title>
    <asset:javascript src="application.js"/>
    </head>
    <body>
<<<<<<< HEAD
        <form action="${ g.createLink(controller: 'payer', action: 'save') }"> 
=======
        <form data-redirect-url="${ g.createLink(controller: 'payer', action: 'index') }"
              action="${ g.createLink(controller: 'payer', action: 'save') }"> 
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc
            <input type="text" name="name" id="name" placeholder="Ex: João Da Silva" required><br>
            <input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" required><br>
            <input type="email" name="email" placeholder="Ex: email@meuprovedor.com" required><br>
            <input type="text" name="postalCode" id="postalCode" placeholder="CEP" required><br>
            <input type="text" name="address" id="address" placeholder="Endereço" required><br>
<<<<<<< HEAD
            <input type="text" name="province" id="province" placeholder="Bairro" required><br>
=======
            <input type="text" name="district" id="district" placeholder="Bairro" required><br>
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc
            <input type="text" name="city" id="city" placeholder="Cidade" required><br>
            <input type="text" name="state" id="state" placeholder="Estado" required><br>
            <button type="submit">Criar</button>
        </form>
    <asset:javascript src="payer/payerCreateSave.js" />
<<<<<<< HEAD
    <asset:javascript src="newPostalCode-api.js" />
=======
    <asset:javascript src="newPostalCodeApi.js" />
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc
    </body>
</html>
