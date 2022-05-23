<%@ page import="com.rocketcharger.enums.PaymentMethod" %>
<%@ page import="com.rocketcharger.enums.PaymentStatus" %>
<%@ page import="com.rocketcharger.utils.FormatDateUtils" %>
<html lang="pt-br">
  <head>
  </head>
    <body>
      <g:if test="${paymentList}">
        <table>
          <tr>
            <th>ID</th>
            <th>Valor do pagamento</th>
            <th>Tipo de Pagamento</th>
            <th>Status</th>
            <th>Data de Vencimento</th>
            <th>Pagador</th>
          </tr>
          <g:each var="payment" in="${paymentList}">
              <td>${payment.id}</td>
              <td>${payment.value}</td>
              <td><g:message code="PaymentMethod.${payment.billingType}"/></td>
              <td><g:message code="PaymentStatus.${payment.status}"/></td>
              <td><g:formatDate format="dd/MM/yyyy" date="${payment.dueDate}"/></td>
              <td>${payment.payer.name}</td>
              <td>
                <g:link controller="payment" action="show" update="divForm" id="${payment.id}">Ver cobrança</g:link>
                <g:link controller="payment" action="confirm" update="divForm" id="${payment.id}">Confirmar recebimento</g:link>
              </td>
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