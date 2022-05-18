<html lang="pt-br">
  <head>
        <%@ page import="com.rocketcharger.enums.PaymentMethod" %>
        <%@ page import="com.rocketcharger.enums.PaymentStatus" %>
        <%@ page import="com.rocketcharger.utils.FormatDateUtils" %>
  </head>
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
            <tr data-url="${ g.createLink([controller:'payment', action:'show', params:[paymentId: payment.id]])}">
              <td>${payment.id}</td>
              <td>${payment.value}</td>
              <td>${payment.billingType}</td>
              <td><g:message code="PaymentStatus.${payment.status}"></td>
              <td>${FormatDateUtils.formatDate(payment.dueDate)}</td>
              <td>${payment.payer.name}</td>
              <td>
                <g:link controller="payment" action="show" update="divForm" id='${payment.id}'>Ver cobrança</g:link>
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