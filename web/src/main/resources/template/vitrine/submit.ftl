<#if !parameters.includeContainer?exists || parameters.includeContainer=="true">
<div class="<#if parameters.containerClass?exists>${parameters.containerClass}<#else>buttons3</#if>">
</#if>
<#if parameters.type?exists && parameters.type=="image">
		<@s.property value="parameters.body"/>
		<input type="image"<#rt/>
		<#if parameters.label?exists>
		 alt="${parameters.label?html}"<#rt/>
		</#if>
		<#if parameters.id?exists>
		 id="${parameters.id?html}"<#rt/>
		</#if>
		<#if parameters.name?exists>
		 name="${parameters.name?html}"<#rt/>
		</#if>
		<#if parameters.nameValue?exists>
		 value="<@s.property value="parameters.nameValue"/>"<#rt/>
		</#if>
		<#if parameters.cssClass?exists>
		 class="${parameters.cssClass?html}"<#rt/>
		</#if>
		<#if parameters.cssStyle?exists>
		 style="${parameters.cssStyle?html}"<#rt/>
		</#if>
		<#if parameters.title?exists>
		 title="${parameters.title?html}"<#rt/>
		</#if>
		/>
<#else>	
		<span
			<#if parameters.id?exists>
			 id="${parameters.id?html}"<#rt/>
			</#if>
			<#if parameters.cssClass?exists>
			 class="${parameters.cssClass?html}"<#rt/>
			<#else>
			 class="button1"<#rt/>
			</#if>
			<#if parameters.cssStyle?exists>
				style="${parameters.cssStyle?html}"<#rt/>
			</#if>
			<#include "/${parameters.templateDir}/simple/scripting-events.ftl"/>
			<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
		>
			<input type="submit"
				<#if parameters.name?exists>
					name="${parameters.name?html}"<#rt/>
				</#if>
				value="<#if parameters.label?exists><@s.text name="${parameters.label}"/><#else>Enviar</#if>" 
			/>
		</span>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#if !parameters.includeContainer?exists || parameters.includeContainer=="true">
</div>
</#if>
