<html lang="pt-br">
  <body>
    <g:if test="${paymentList?.size() > 0}">
      <table>
        <tr>
          <th>Tipo de Pagamento</th>
          <th>Status</th>
          <th>Data de Vencimento</th>
          <%-- <th>Cliente</th>
          <th>Pagador</th> --%>
        </tr>
        <g:each var="payment" in="${paymentList}">
          <tr>
            <td>${payment.billingType}</td>
            <td>${payment.status}</td>
            <td>${payment.dueDate}</td>
            <%-- <td>${payment.customer}</td>
            <td>${payment.payer}</td> --%>
        <g:link controller="payment" action="show" update="divForm" id='${payment.id}'>editar cobrança</g:link>
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
