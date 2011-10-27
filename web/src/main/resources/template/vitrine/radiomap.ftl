<div class="radio">
<#if parameters.label?exists><strong class="label"><@s.text name="${parameters.label}" />:<#if parameters.required?exists && parameters.required==true><span class="req"> *</span></#if></strong></#if>


<@s.iterator value="parameters.list">
    <#if parameters.listKey?exists>
        <#assign itemKey = stack.findValue(parameters.listKey)/>
    <#else>
        <#assign itemKey = stack.findValue('top')/>
    </#if>
    <#assign itemKeyStr = itemKey.toString() />
    <#if parameters.listValue?exists>
        <#assign itemValue = stack.findString(parameters.listValue)/>
    <#else>
        <#assign itemValue = stack.findString('top')/>
    </#if>
<input type="radio" name="${parameters.name?html}" id="${parameters.id?html}${itemKeyStr?html}"<#rt/>
<#if tag.contains(parameters.nameValue, itemKey)>
 checked="checked"<#rt/>
</#if>
<#if itemKey?exists>
 value="${itemKeyStr?html}"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.tabindex?exists>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html} field radio"<#rt/>
<#else>
 class="field radio"<#rt/>
</#if>
<#if parameters.cssStyle?exists>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title?exists>
 title="${parameters.title?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
/><#rt/>
<label class="choice" for="${parameters.id?html}${itemKeyStr?html}"><#rt/>
    ${itemValue?html}<#t/>
</label>
</@s.iterator>

<#if parameters.name?exists && fieldErrors?exists && fieldErrors[parameters.name]?exists>
<p class="error">${fieldErrors[parameters.name][0]?html}</p>
</#if>
</div>
