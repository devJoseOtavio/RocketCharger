<html>
   <head>
      <title>Adicionar pagamento</title>
      <asset:javascript src="applications/applicationPayment.js"/>
   </head>
   <body>
      <form data-redirect-url="${ g.createLink(controller: "payment", action: "list", params: [id: customerId]) }"
      action="${ g.createLink(controller: "payment", action: "save") }">
      <div><input type="text" name="value" placeholder="Valor do pagamento"></div>
      <div><input type="text" name="billingType" placeholder="Método de pagamento"></div>
      <div><input type="text" name="status" placeholder="Status"></div>
      <div><input type="text" name="dueDate" placeholder="Data de vencimento"></div>
      <select id="payerId" name="payerId" required>
         <option>Selecione um pagador</option>
         <g:each var="payer" in="${payerList}">
            <option value="${payer.id}">${payer.name}</option>
         </g:each>
      </select>
      <input hidden value="${customerId}" name="customerId" id="customerId">    
      <div><button type="submit">Salvar</button></div>
      </form>
   </body>
</html>