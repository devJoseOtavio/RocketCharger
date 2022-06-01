<%@ page import="com.rocketcharger.enums.PaymentMethod" %>
<html>
  <head>
    <title>Adicionar pagamento</title>
    <asset:javascript src="applications/applicationPayment.js" />
  </head>
  <body>
    <form
      data-redirect-url="${ g.createLink(controller: "payment", action: "list", params: [id: customerId]) }"
      action="${ g.createLink(controller: "payment", action: "save") }">
      <div>
        <label>Valor do pagamento:</label>
        <input
          type="text"
          name="value"
          id="value"
          placeholder="Valor do pagamento"/>
      </div>
      <div>
        <label>Data de Vencimento:</label>
        <input
          type="date"
          name="dueDate"
          id="dueDate"
          placeholder="Data de vencimento"/>
      </div>
      <div>
        <label> Método de pagamento:</label>
        <g:select
          id="method"
          name="billingType"
          from="${PaymentMethod?.values()}"
          value="${method}"
          noSelection="['':'Tipo de pagamento']"
          valueMessagePrefix="PaymentMethod"/>
      </div>
      <div>
        <label> Selecione o pagador:</label>
        <select id="payerId" name="payerId" required>
          <option>Selecione o pagador</option>
          <g:each var="payer" in="${payerList}">
            <option value="${payer.id}">${payer.name}</option>
          </g:each>
        </select>
      </div>
      <input
        type="hidden"
        value="${customerId}"
        name="customerId"
        id="customerId"/>
      <div>
        <button type="submit">Salvar</button>
      </div>
    </form>
  </body>
</html>
