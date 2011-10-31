<#import "/WEB-INF/macros/crud.ftl" as crud>

<#macro localIconsRenderer type entity removalConfirmation>
	<@crud.actionIcon icon="folder-open" alt="AdicionarProdutos">
		<@s.url action="product/list/${entity.id}"/>
	</@crud.actionIcon>
	<@crud.actionIcon icon="icoPreview" alt="Exibir Requisição">
		<@s.url action="request/${entity.id}/show"/>
	</@crud.actionIcon>
	<@crud.actionIcon icon="icoEditar" alt="Editar"><@s.url action="${type}/${entity.id}/edit" /></@crud.actionIcon>
	<@crud.actionIcon icon="icoLixeira" confirm=removalConfirmation alt="Apagar">
		<@s.url action="${type}/delete"><@s.param name="entity">${entity.id}</@s.param></@s.url>
	</@crud.actionIcon>
</#macro>

<@crud.list 
	title="Listagem de Requisições"
	buttons=[["Nova Requisição","request/create"]]
	emptyListMessage="Nenhuma requisição encontrada"
	type="request"
	columns=[["Código","id"],["Descrição","description"],["Status","status.state"]]
	removalConfirmation="Tem certeza?"
	actionIconsRenderer=localIconsRenderer />