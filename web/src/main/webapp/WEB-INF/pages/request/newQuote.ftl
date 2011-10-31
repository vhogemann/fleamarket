<html>
    <head>
        <title>Nova Cotação</title>
    </head>
    <body>
    	<#if action.hasActionErrors()>
			<div class="error"><@s.text name="${action.getActionErrors()}" /></div>
		</#if>
		<@s.form id="request_quote" action="request/${entity.id}/quote">
			<h1 class="formTitle">Nova Cotação</h1>
	     	<@s.select 
				name="quote.supplier" 
				list="suppliers" 
				label="Fornecedor" 
				listValue="name"
				listKey="id" />
			
			<#if quote.items?has_content>
			<#list quote.items as item >
				<@s.hidden name="quote.items[${item_index}].product" value="${item.product.id}"/>
				<@s.hidden name="quote.items[${item_index}].quantity" value="${item.quantity}"/>
			</#list>
			<table>
				<tbody>
				<#list quote.items as item >
					<tr>
						<td>${item.product.name}</td>${item.quantity}<td><@s.textfield name="quote.items[${item_index}].price" value="${item.price}"/></td>
					</tr>
				</#list>
				</tbody>
			</table>
			</#if>
	     	<@s.submit />
	    </@s.form>
    </body>
</html>
