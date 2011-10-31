<#import "/WEB-INF/macros/crud.ftl" as crud>

<@crud.list 
	title="Listagem de Fornecedores"
	buttons=[["Novo Fornecedor","supplier/create"]]
	emptyListMessage="Nenhum fornecedor encontrado"
	type="supplier"
	columns=[["Código","id"],["Nome","name"]]
	removalConfirmation="Tem certeza?"
/>