     <form id="formEdit" action="${ g.createLink(controller: 'customer', action: 'save') }">
            <input type="hidden" class="js-customer-id" name="id" value="1">
            <input class="txtBloqueado" type="text" name="name" id="name" placeholder="Ex: João Da Silva" value="${ customer.name}" readonly="true"><br>
            <input class="txtBloqueado" type="text" name="cpfCnpj" placeholder="Informe o CPF/CNPJ" value="${ customer.cpfCnpj}" readonly="true"><br>
            <input class="txtBloqueado" type="email" name="email" placeholder="Ex: email@meuprovedor.com" value="${ customer.email}" readonly="true"><br>
            <input class="txtBloqueado" type="text" name="postalCode" id="postalCode" placeholder="CEP"value="${ customer.postalCode}" readonly="true"><br>
            <input class="txtBloqueado" type="text" name="address" id="address" placeholder="Endereço"value="${ customer.address}" readonly="true"><br>
            <input class="txtBloqueado" type="text" name="province" id="province" placeholder="Bairro"value="${ customer.province}" readonly="true"><br>
            <input class="txtBloqueado" type="text" name="city" id="city" placeholder="Cidade"value="${ customer.city}" readonly="true"><br>
            <input class="txtBloqueado" type="text" name="state" id="state" placeholder="Estado"value="${ customer.state}" readonly="true"><br>
            <button class="js-editCustomer">Editar</button>
            <button type="submit" id="editSave" class="js-send-button hiddenBtn">Salvar</button>
        </form>