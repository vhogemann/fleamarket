<@s.textfield name="entity.name" id="name" label=action.getText("Nome") />
<@s.select 
	name="entity.deliveryAddress.type" 
	list="addressTypes" 
	label=action.getText('Tipo de Endereço') 
	value="${(entity.deliveryAddress.type)!}"
	key="${(entity.deliveryAddress.type.name())!}"
/>
<@s.textfield name="entity.deliveryAddress.streetName" id="deliveryAddress_streetName" label=action.getText("Rua") />
<@s.textfield name="entity.deliveryAddress.number" id="deliveryAddress_number" label=action.getText("Numero") />
<@s.textfield name="entity.deliveryAddress.complement" id="deliveryAddress_complement" label=action.getText("Complemento") />
<@s.textfield name="entity.deliveryAddress.postalCode" id="deliveryAddress_postalCode" label=action.getText("CEP") />
<@s.textfield name="entity.deliveryAddress.country" id="deliveryAddress_country" label=action.getText("País") />
<@s.textfield name="entity.deliveryAddress.state" id="deliveryAddress_state" label=action.getText("Estado") />
<@s.textfield name="entity.deliveryAddress.city" id="deliveryAddress_city" label=action.getText("Cidade") />