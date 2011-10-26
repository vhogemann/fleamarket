<#import "/WEB-INF/macros/crud.ftl" as crud>

<@crud.list 
	title="Listagem de Produtos"
	buttons=[["Novo Produto","product/create"]]
	emptyListMessage="Nenhum produto encontrado"
	type="product"
	columns=[["Código","id"],["Nome","name"],["Descrição","description"],["Preço Ref.","referencePrice"]]
	removalConfirmation="Tem certeza?"
/>