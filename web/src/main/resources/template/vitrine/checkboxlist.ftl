<#include "controlheader.ftl" />

<#assign itemCount = 0/>

<#if parameters.list?exists>
	<ul class="mSelect">
    <@s.iterator value="parameters.list">
    
        <#assign itemCount = itemCount + 1/>
        
        <#if parameters.listKey?exists>
            <#assign itemKey = stack.findValue(parameters.listKey)/>
        <#else>
            <#assign itemKey = stack.findValue('top')/>
        </#if>
        
        
        <#if parameters.listValue?exists>
            <#assign itemValue = stack.findString(parameters.listValue)/>
        <#else>
            <#assign itemValue = stack.findString('top')/>
        </#if>
        
		<li>
					<input class="radio" type="checkbox" name="${parameters.name?html}" value="${itemKey?html}" id="${parameters.name?replace('[', '_')?replace(']','_')?html}-${itemCount}"<#rt/>
			        <#if tag.contains(parameters.nameValue, itemKey)>
						 checked="checked"<#rt/>
			        </#if>
			        <#if parameters.disabled?default(false)>
						disabled="disabled"<#rt/>
			        </#if>
			        <#if parameters.title?exists>
						title="${parameters.title?html}"<#rt/>
			        </#if>
			        <#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
			        <#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
			/>
			
			${itemValue?html}
			
		  </li>	     
	
    </@s.iterator>
    </ul>
<#else>
  &nbsp;
</#if>

<#include "controlfooter.ftl" />
