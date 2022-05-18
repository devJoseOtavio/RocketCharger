<html>
    <head>
    <%@ page import="com.rocketcharger.enums.PaymentMethod" %>
    <title>Adicionar pagamento</title>
    <asset:javascript src="applications/applicationPayment.js"/>
    </head>
    <body>
        <form data-redirect-url="${ g.createLink(controller: 'payment', action: 'index', params: [id: customerId]) }"
              action="${ g.createLink(controller: 'payment', action: 'save') }">
            <div><input type="text" name="value" placeholder="valor do pagamento"></div>
            <div><input type="date" name="dueDate" placeholder="Data de vencimento"></div>
            <div>
            <g:select id="method"
                name="billingType"
                from="${PaymentMethod?.values()}" 
                value="${method}"
                noSelection="['':'Tipo de pagamento']"
                valueMessagePrefix="PaymentMethod"/>
            <div>
            <select id="payerId" name="payerId" required>
                <option>Selecione um pagador</option>
                    <g:each var="payer" in="${payerList}">
                        <option value="${payer.id}">${payer.name}</option>
                    </g:each>
            </select>
            <input type="hidden" value="${customerId}" name="customerId" id="customerId">    
            <div><button type="submit">Salvar</button></div>       
        </form>
    </body>
</html>
