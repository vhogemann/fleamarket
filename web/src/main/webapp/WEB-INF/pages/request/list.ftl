<#import "/WEB-INF/macros/crud.ftl" as crud>

<@crud.list 
	title="Listagem de Requisições"
	buttons=[["Nova Requisição","request/create"]]
	emptyListMessage="Nenhuma requisição encontrada"
	type="request"
	columns=[["Código","id"],["Descrição","description"]]
	removalConfirmation="Tem certeza?"
/>