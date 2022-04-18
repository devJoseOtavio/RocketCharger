<html>
<g:if test="${payerList?.size() > 0}">
    <table>
    <tr>
        <th>Nome</th>
        <th>E-mail</th>
        <th>CEP</th>
        <th>Endereço</th>
        <th>Cidade</th>
        <th>Estado</th>
    </tr>
    <g:each var="payer" in="${payerList}">
        <tr>
            <td>${payer.name}</td>
            <td>${payer.email}</td>
            <td>${payer.postalCode}</td>
            <td>${payer.address}</td>
            <td>${payer.city}</td>
            <td>${payer.state}</td>
        </tr>
        </g:each>
    </table>
    <a href="#">Alterar</a><br>
</g:if>
<g:else>
    <div>Não há pagadores.</div>
</g:else>
</html>