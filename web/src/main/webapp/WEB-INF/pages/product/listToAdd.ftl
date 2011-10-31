<#import "/WEB-INF/macros/crud.ftl" as crud>

<#macro localIconsRenderer type entity removalConfirmation>
	<@crud.actionIcon icon="folder-open" alt="AdicionarProdutos">
		<@s.url action="request/${requestId}/add/${entity.id}"/>
	</@crud.actionIcon>
</#macro>

<@crud.list 
	title="Listagem de Produtos"
	emptyListMessage="Nenhum produto encontrado"
	type="product"
	columns=[["Código","id"],["Nome","name"],["Descrição","description"],["Preço Ref.","referencePrice"]]
	removalConfirmation="Tem certeza?"
	actionIconsRenderer=localIconsRenderer
/>