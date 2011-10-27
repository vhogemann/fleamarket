<input type="hidden" name="__checkbox_${parameters.name?html}" value="${parameters.fieldValue?html}"/>
<div>
<input type="checkbox" name="${parameters.name?html}" value="${parameters.fieldValue?html}"<#rt/>
<#if parameters.nameValue?exists && parameters.nameValue>
 checked="checked"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="readonly"<#rt/>
</#if>
<#if parameters.tabindex?exists>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id?exists>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.cssClass?exists>
 class="field checkbox ${parameters.cssClass?html}"<#rt/>
<#else>
 class="field checkbox"<#rt/>
</#if>
<#if parameters.cssStyle?exists>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title?exists>
 title="${parameters.title?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
/>
<#if parameters.label?exists><label class="choice" <#if parameters.id?exists>for="${parameters.id?html}"</#if>><@s.text name="${parameters.label}" /></label></#if>
<#include "controlfooter.ftl" />
