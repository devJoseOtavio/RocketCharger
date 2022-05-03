<html>
    <head>
    <title>Adicionar pagamento</title>
    <asset:javascript src="application.js"/>
    </head>
    <body>
        <form data-redirect-url="${ g.createLink(controller: 'payment', action: 'index') }"
              action="${ g.createLink(controller: 'payment', action: 'save') }"> 
            <label for="billingType">Método</label>
            <input type="radio" name="" id="">
            <input type="text" name="billingType" placeholder="Método de pagamento"><br>
            <input type="text" name="status" placeholder="Status"><br>
            <input type="date" name="dueDate" placeholder="Data de vencimento"><br>
            <button type="submit">Criar</button>
        </form>
    <asset:javascript src="payer/payerCreateSave.js" />
    </body>
</html>
