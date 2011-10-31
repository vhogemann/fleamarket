<html>
<head></head>
<body>
	<div id="area2">
		<div class="buttons">
			<#if entity.status.state == "DRAFT">
			<a class="button1" href="<@s.url action="product/list/${entity.id}"/>">
				<span><@s.text name="Adicionar Produtos"/></span>
			</a>
			<a class="button1" href="<@s.url action="status/${entity.id}/publish"/>">
				<span><@s.text name="Publicar"/></span>
			</a>
			<a class="button1" href="<@s.url action="status/${entity.id}/cancel"/>">
				<span><@s.text name="Cancelar"/></span>
			</a>
			</#if>
			<#if entity.status.state == "PENDING_APPROVAL">
			<a class="button1" href="<@s.url action="status/${entity.id}/approve"/>">
				<span><@s.text name="Aprovar"/></span>
			</a>
			<a class="button1" href="<@s.url action="status/${entity.id}/cancel"/>">
				<span><@s.text name="Cancelar"/></span>
			</a>
			</#if>
			<#if entity.status.state == "PENDING_QUOTES">
			<a class="button1" href="<@s.url action="request/${entity.id}/newQuote"/>">
				<span><@s.text name="Nova Cotação"/></span>
			</a>
			<a class="button1" href="<@s.url action="status/${entity.id}/endQuoting"/>">
				<span><@s.text name="Encerrar período de Cotação"/></span>
			</a>
			<a class="button1" href="<@s.url action="status/${entity.id}/cancel"/>">
				<span><@s.text name="Cancelar"/></span>
			</a>
			</#if>
			<#if entity.status.state == "PENDING_ORDER">
			<a class="button1" href="<@s.url action="status/${entity.id}/approveBestQuote"/>">
				<span><@s.text name="Aprovar melhor Cotação"/></span>
			</a>
			</#if>
		</div>
		<table class="table1">
			<thead>
				<tr>
					<th>Requisição</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Descrição : ${entity.description!}</td>
				</tr>
				<tr>
					<td>Status : ${entity.status.state}</td>
				</tr>
			</tbody>
		</table>
		<#if entity.quote?exists>
		<table class="table1">
			<thead>
				<tr>
					<th>Fornecedor da Cotação</th><th>Preço</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${entity.quote.supplier.name}</td> <td>${entity.quote.price}</td>
				</tr>
			</tbody>
		</table>
		</#if>
		<#if entity.history?has_content>
		<table class="table1">
			<thead>
				<tr>
					<th>Histórico</th><th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<#list entity.history as hist>
				<tr>
					<td>${hist.state}</td> <td>${hist.description!}</td>
				</tr>
				</#list>
			</tbody>
		</table>
		</#if>
		<#if entity.items?has_content>
		<table class="table1">
			<thead>
				<tr>
					<th>Produto</th><th>Quantidade</th><th>Preço</th>
				</tr>
			</thead>
			<tbody>
				<#list entity.items as item>
				<tr>
					<td>${item.product.name}</td> <td>${item.quantity}</td> <td>${item.price}</td>
				</tr>
				</#list>
			</tbody>
		</table>
		</#if>
		<#if entity.quotes?has_content>
		<table class="table1">
			<thead>
				<tr>
					<th>Fornecedor da Contação</th><th>Preço</th>
				</tr>
			</thead>
			<tbody>
				<#list entity.quotes as quote>
				<tr>
					<td>${quote.supplier.name}</td> <td>${quote.price}</td>
				</tr>
				</#list>
			</tbody>
		</table>
		</#if>
	</div>
</body>
</html>