<html>
<head>
    <title>Gerenciamento de pagamentos</title>
</head>
    <asset:javascript src="application.js"/>
<body>
    <form data-redirect-url="${ g.createLink(controller: 'payer', action: 'index') }" 
          action="${ g.createLink(controller: 'payer', action: 'update') }" >
        <input type="hidden" class="js-payer-id" name="id" value="${payer.id}">
        <input type="text" name="billingType" placeholder="Método de pagamento" required><br>
        <input type="text" name="status" placeholder="Status" required><br>
        <input type="date" name="dueDate" placeholder="Data de vencimento" required><br>
        <button class="js-editPayer">Editar</button>
        <button type="submit" class="js-send-button hiddenBtn">Salvar</button>
    </form> 

    <asset:stylesheet src="payer/edit.css" />
    <asset:javascript src="payer/payerEdit.js" />
    <asset:javascript src="payer/payerCreateSave.js" /> 
    <asset:javascript src="newPostalCodeAzzzzpi.js" />
</body>
</html>