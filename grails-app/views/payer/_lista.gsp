
<g:if test="${payerList?.size() > 0}">
    <table>
    <tr>
        <th>name</th>
        <th>email</th>
        <th>cep</th>
        <th>endereço</th>
        <th>cidade</th>
        <th>estado</th>
    </tr>
    <g:each var="payer" in="${payerList}">
        <tr>
            <td>${payer.name}</td>
            <td>${payer.email}</td>
            <td>${payer.postalCode}</td>
            <td>${payer.address}</td>
            <td>${payer.city}</td>
            <td>${payer.state}</td>
            <td>
                <a href="#">Alterar</a><br>
        </tr>
        </g:each>
    </table>
</g:if>
<g:else>
    Não há pagadores.
</g:else>