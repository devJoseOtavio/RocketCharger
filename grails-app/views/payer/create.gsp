<html>
<head>
    <title>Adicionar pagador</title>
    <asset:javascript src="application.js"/>
    <asset:javascript src="payerCreateSave/payerCreateSave.js" />
    <asset:javascript src="index/postalCode-api.js" />
</head>
    <body>
        <form action="${ g.createLink(controller: 'payer', action: 'save') }"> 
            <input type="text" name="name" placeholder="Ex: João Da Silva"><br>
            <input type="text" name="email" placeholder="Ex: email@meuprovedor.com"><br>
            <input type="text" name="postalCode" id="postalCode" placeholder="CEP"><br>
            <input type="text" name="address" id="address" placeholder="Endereço"><br>
            <input type="text" name="city" id="city" placeholder="Cidade"><br>
            <input type="text" name="state" id="state" placeholder="Estado"><br>
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>
