<%@ page import="com.rocketcharger.enums.PaymentMethod" %>
<%@ page import="com.rocketcharger.utils.FormatDateUtils" %>
<html>
<head>
    <title>Email de cobrança</title>
</head>
<body>
    <p><b>Comprovante de pagamento</b></p>
    <div>
        <div>
            <label>Forma de pagamento:</label>
            <g:message code="PaymentMethod.${payment.billingType}"/>
        </div>
        <div>
            <label>Valor pago:</label>
            ${payment.value}
        </div>
        <div>
            <label>Data do vencimento:</label>
            <g:formatDate format="dd/MM/yyyy" date="${payment.dueDate}"/>
        </div>
        <div>
            <label>Data do pagamento:</label>
            (ainda falta)
        </div>
        <hr>
        <div>
            <label>Dados do Recebedor</label>
        </div>
        <div>
            <label>Nome:</label>
            ${payment.customer.name}
        </div>
        <div>
            <label>CPF/CNPJ:</label>
            ${payment.customer.cpfCnpj}
        </div>
        <hr>
        <div>
            <label>Dados do Pagador</label>
        </div>
        <div>
            <label>Nome:</label>
            ${payment.payer.name}
        </div>
            <div>
            <label>CPF/CNPJ:</label>
            ${payment.payer.cpfCnpj}
        </div>
    </div>
    <hr>
    <div>
        <div>               
            <p>Este documento e cobrança não possuem valor fiscal e são de responsabilidade única e exclusiva de ${payment.customer.name}</p>
        </div>
        <hr>
        <div>
            <p>Cobrança intermediada por Rocket Charger.</p>
        </div>
    </div>
</body>
</html>