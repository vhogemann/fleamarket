<@s.textfield name="entity.name" id="name" label=action.getText("Nome") />
<@s.select 
	name="entity.address.type" 
	list="addressTypes" 
	label=action.getText('Tipo de Endereço') 
	value="${(entity.address.type)!}"
	key="${(entity.address.type.name())!}"
/>
<@s.textfield name="entity.address.streetName" id="deliveryAddress_streetName" label=action.getText("Rua") />
<@s.textfield name="entity.address.number" id="deliveryAddress_number" label=action.getText("Numero") />
<@s.textfield name="entity.address.complement" id="deliveryAddress_complement" label=action.getText("Complemento") />
<@s.textfield name="entity.address.postalCode" id="deliveryAddress_postalCode" label=action.getText("CEP") />
<@s.textfield name="entity.address.country" id="deliveryAddress_country" label=action.getText("País") />
<@s.textfield name="entity.address.state" id="deliveryAddress_state" label=action.getText("Estado") />
<@s.textfield name="entity.address.city" id="deliveryAddress_city" label=action.getText("Cidade") />