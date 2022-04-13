
<g:if test="${payerList?.size() > 0}">
    <table>
    <tr>
        <th>name</th>
        <th>email</th>
        <th>nascimento</th>
        <th>cep</th>
        <th>endereco</th>
        <th>cidade</th>
        <th>estado</th>
    </tr>
    <g:each var="payer" in="${payerList}">
        <tr>
            <td>${payer.customerName}</td>
            <td>${payer.email}</td>
            <td>${payer.postalCode}</td>
            <td>${payer.address}</td>
            <td>${payer.city}</td>
            <td>${payer.state}</td>
            <td>
                <a href="#">Alterar</a><br>
                <a href="#">Excluir</a>
        </tr>
        </g:each>
    </table>
</g:if>
<g:else>
    Não há pagadores.
</g:else>