<div>
<#if parameters.name?exists && fieldErrors?exists && fieldErrors[parameters.name]?exists>
<p class="error">${fieldErrors[parameters.name][0]?html}</p>
</#if>
<#if parameters.label?exists><label class="desc"><@s.text name="${parameters.label}" />:<#if parameters.required?exists && parameters.required==true><span class="req"> *</span></#if></label></#if>