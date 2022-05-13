<html>
    <head>
    <title>Adicionar pagamento</title>
    <asset:javascript src="applications/applicationPayment.js"/>
    </head>
    <body>
        <form data-redirect-url="${ g.createLink(controller: 'payment', action: 'index') }"
              action="${ g.createLink(controller: 'payment', action: 'save') }">
            <div><input type="text" name="billingType" placeholder="Método de pagamento"></div>
            <div><input type="text" name="status" placeholder="Status"></div>
            <div><input type="text" name="dueDate" placeholder="Data de vencimento"></div>
            <div><button type="submit">Salvar</button></div>
        </form>
    </body>
</html>
