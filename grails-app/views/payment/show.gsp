<html>
<head>
    <title>Gerenciamento de pagamentos</title>
</head>
<body>
    <form data-redirect-url="${ g.createLink(controller: 'payment', action: 'index') }" 
          action="${ g.createLink(controller: 'payment', action: 'update') }" >
        <input type="hidden" class="js-payment-id" name="id" value="${payment.id}">
        <input type="text" name="value" placeholder="valor do pagamento" value="${payment?.value}" readonly><br>
        <input type="text" name="billingType" placeholder="Método de pagamento" value="${payment?.billingType}" readonly><br>
        <input type="text" name="status" placeholder="Status" value="${payment?.status}" readonly><br>
        <input type="text" name="dueDate" placeholder="Data de vencimento" value="${payment?.dueDate}" readonly><br>
        <input type="text" name="payer" placeholder="Pagador" value="${payment?.payer.name}" readonly><br>
    </form> 
</body>
</html>