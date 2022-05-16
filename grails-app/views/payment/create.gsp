<html>
    <head>
    <title>Adicionar pagamento</title>
    <asset:javascript src="applications/applicationPayment.js"/>
    </head>
    <body>
        <form data-redirect-url="${ g.createLink(controller: 'payment', action: 'index', params: [id: customerId]) }"
              action="${ g.createLink(controller: 'payment', action: 'save') }">
            <div><input type="text" name="value" placeholder="valor do pagamento"></div>
            <div><input type="text" name="billingType" placeholder="Método de pagamento"></div>
            <div><input type="text" name="status" placeholder="Status"></div>
            <div><input type="text" name="dueDate" placeholder="Data de vencimento"></div>
            <div><label for=payerId>Pagador</label>
            <select id="payerId" name="payerId" required>
                    <g:each var="payer" in="${payerList}">
                        <option value="$ {payer.id}">${payer.name}</option>
                    </g:each>
            <input hidden value="${customerId}" name="customer" id="customer">    
            <div><button type="submit">Salvar</button></div>       
        </form>
    </body>
</html>
