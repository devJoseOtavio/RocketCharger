<html>
    <head>
    <title>Adicionar pagador</title>
    <asset:javascript src="applications/applicationForm.js"/>
    </head>
    <body>
        <form data-redirect="${ g.createLink([controller: "payer", action: "index", params: [id: customerId]]) }"
              data-url="${ g.createLink([controller: "payer", action: "save"]) }">
            <input type="text" name="name" id="name" placeholder="Ex: João Da Silva" required><br>
            <input type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" required><br>
            <input type="email" name="email" placeholder="Ex: email@meuprovedor.com" required><br>
            <input type="text" name="postalCode" id="postalCode" placeholder="CEP" required><br>
            <input type="text" name="address" id="address" placeholder="Endereço" required><br>
            <input type="text" name="district" id="district" placeholder="Bairro" required><br>
            <input type="text" name="city" id="city" placeholder="Cidade" required><br>
            <input type="text" name="state" id="state" placeholder="Estado" required><br>
            <input hidden value="${customerId}" name="customer" id="customer">
            <button type="submit" class="btnSave">Salvar</button>
        </form>
    </body>
</html>
