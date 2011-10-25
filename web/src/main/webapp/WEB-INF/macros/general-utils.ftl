<#function generateStaticUrl value i18n=false>
	<#if i18n>
		<#return "${staticURLBase}/i18n/${locale}${value}${('?'+version?html)!}">
	<#else>
		<#return "${staticURLBase}${value}${('?'+version?html)!}">
	</#if>
</#function>
<#macro staticUrl value i18n=false>${generateStaticUrl(value, i18n)}</#macro>
