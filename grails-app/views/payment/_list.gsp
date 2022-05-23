<html lang="pt-br">
  <body>
    <g:if test="${paymentList?.size() > 0}">
      <table>
        <tr>
          <th>Valor do pagamento</th>
          <th>Tipo de Pagamento</th>
          <th>Status</th>
          <th>Data de Vencimento</th>
          <th>Pagador</th>
        </tr>
        <g:each var="payment" in="${paymentList}">
          <tr>
            <td>${payment.value}</td>
            <td>${payment.billingType}</td>
            <td>${payment.status}</td>
            <td>${payment.dueDate}</td>
            <td>${payment.payer.name}</td>
            <td>
              <g:link
                controller="payment"
                action="show"
                update="divForm"
                id="${payment.id}"
                >Ver cobrança</g:link>
            </td>
          </tr>
        </g:each>
      </table>
    </g:if>
    <g:else>
      <div><strong>Não há cobranças.</strong></div>
    </g:else>
  </body>
</html>
