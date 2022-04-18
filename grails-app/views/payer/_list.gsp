<html lang="pt-br">
<body>
<g:if test="${payerList?.size() > 0}">
    <table>
    <tr>
        <th>Nome</th>
        <th>E-mail</th>
        <th>CPF/CNPJ</th>
        <th>CEP</th>
        <th>Endereço</th>
        <th>Bairro</th>
        <th>Cidade</th>
        <th>Estado</th>
    </tr>
    <g:each var="payer" in="${payerList}">
        <tr>
            <td>${payer.name}</td>
            <td>${payer.email}</td>
            <td>${payer.cpfCnpj}</td>
            <td>${payer.postalCode}</td>
            <td>${payer.address}</td>
            <td>${payer.province}</td>
            <td>${payer.city}</td>
            <td>${payer.state}</td>
        </tr>
        </g:each>
    </table>
</g:if>
<g:else>
    <div><strong>Não há pagadores.</strong></div>
</g:else>
</body>
</html>