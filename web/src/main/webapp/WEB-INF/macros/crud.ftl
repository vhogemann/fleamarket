<#import "/WEB-INF/macros/general-utils.ftl" as utl>

<#macro actionIcon icon alt confirm="">
	<a href="<#nested>"<#if confirm?has_content> onclick="if(!confirm('<@s.text name=confirm?js_string />')) {return false;}"</#if>>
		<img src="<@utl.staticUrl "/img/${icon}.gif" />" alt="<@s.text name=alt />" title="<@s.text name=alt />" />
	</a>
</#macro>

<#macro defaultActionIconsRenderer type entity removalConfirmation>
	<@actionIcon icon="icoEditar" alt="Editar"><@s.url action="${type}/${entity.id}/edit" /></@actionIcon>
	<@actionIcon icon="icoLixeira" confirm=removalConfirmation alt="Apagar"><@s.url action="${type}/delete"><@s.param name="entity">${entity.id}</@s.param></@s.url></@actionIcon>
</#macro>

<#macro list
	title
	emptyListMessage
	type
	columns
	removalConfirmation="Tem certeza que deseja excluir este registro?"
	buttons=[]
	actionIconsRenderer=defaultActionIconsRenderer 
	hasActions=true
>
	<html>
		<head>
			<title><@s.text name="${title}" /></title>
	    </head>
	    <body>
			<div id="area2">
				<#if buttons?has_content>
					<div class="buttons">
						<#list buttons as button>
							<a class="button1" href="<@s.url action="${button[1]}" />"><span><@s.text name=button[0] /></span></a>
						</#list>
					</div>
				</#if>
				<#if entities?has_content>
		        	<table class="table1 datatable">
						<thead>
							<tr>
								<#list columns as col>
									<th><@s.text name="${col[0]}"/></th>
								</#list>
								<#if hasActions>
								<th><@s.text name="Ação"/></th>
								</#if>
							</tr>
						</thead>
						<tbody>
							<#list entities as entity>
								<tr>
									<#list columns as col>
										<td>
											<#if col[1]?is_macro>
												<@col[1] entity=entity />
											<#else>
												${"(entity.${col[1]})!'-'"?eval}
											</#if>
										</td>
									</#list>
									<#if hasActions>
										<td class="icons">
											<@actionIconsRenderer type, entity, removalConfirmation />
										</td>
									</#if>
								</tr>
							</#list>
						</tbody>
					</table>
				<#else>
					<p class="information"><@s.text name="${emptyListMessage}" /></p>		
				</#if>
	        </div>
	    </body>
	</html>
</#macro>

<#macro form title type isNew>
<html>
    <head>
        <title><@s.text name=title /></title>
    </head>
    <body>
    	<#assign operation><#if isNew>save<#else>update</#if></#assign>
		<@s.form id="${type}_${operation}" action="${type}/${operation}">
			<h1 class="formTitle"><@s.text name=title /></h1>
			<#if !isNew><@s.hidden name="entity" /></#if>
			<#include "/WEB-INF/pages/${type}/form.ftl" />
			<#nested>
	     	<@s.submit />
	    </@s.form>
    </body>
</html>
</#macro>
