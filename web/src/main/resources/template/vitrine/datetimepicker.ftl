<#import "/WEB-INF/macros/lib/general-utils.ftl" as utl>
<#include "controlheader.ftl" />
<input<#rt/>
  <#if parameters.id?if_exists != "">
    id="${parameters.id?replace('/','_')?html}"<#rt/>
  </#if>
  <#if parameters.nameValue?if_exists != "">
    value="${parameters.nameValue}"<#rt/>
  </#if>
  <#if parameters.language?if_exists != "">
    lang="${parameters.language?html}"<#rt/>
  </#if>
  <#if parameters.name?if_exists != "">
    name="${parameters.name?html}"<#rt/>
  </#if>
  <#if parameters.displayWeeks?if_exists != "">
    displayWeeks="${parameters.displayWeeks?html}"<#rt/>
  </#if>
  <#if parameters.adjustWeeks?exists>
    adjustWeeks="${parameters.adjustWeeks?string?html}"<#rt/>
  </#if>
  <#if parameters.startDate?if_exists != "">
    startDate="${parameters.startDate?html}"<#rt/>
  </#if>
  <#if parameters.endDate?if_exists != "">
    endDate="${parameters.endDate?html}"<#rt/>
  </#if>
  <#if parameters.weekStartsOn?if_exists != "">
    weekStartsOn="${parameters.weekStartsOn?html}"<#rt/>
  </#if>
  <#if parameters.staticDisplay?exists>
    staticDisplay="${parameters.staticDisplay?string?html}"<#rt/>
  </#if>
  <#if parameters.dayWidth?if_exists != "">
    dayWidth="${parameters.dayWidth?html}"<#rt/>
  </#if>
  <#if parameters.tabindex?if_exists != "">
    tabindex="${parameters.tabindex?html}"<#rt/>
  </#if>
  <#if parameters.cssClass?if_exists != "">
    class="${parameters.cssClass?html}"<#rt/>
  </#if>
  <#if parameters.cssStyle?if_exists != "">
    style="${parameters.cssStyle?html}"<#rt/>
  </#if>
  <#if parameters.iconPath?if_exists != "">
    iconURL="<@s.url value='${parameters.iconPath}' encode="false" includeParams='none'/>"<#rt/>
  </#if>
  <#if parameters.formatLength?if_exists != "">
    formatLength="${parameters.formatLength?html}"<#rt/>
  </#if>
  <#if parameters.displayFormat?if_exists != "">
    displayFormat="${parameters.displayFormat?html}"<#rt/>
  </#if>
  <#if parameters.toggleType?if_exists != "">
    containerToggle="${parameters.toggleType?html}"<#rt/>
  </#if>
  <#if parameters.toggleDuration?exists>
    containerToggleDuration="${parameters.toggleDuration?string?html}"<#rt/>
  </#if>
  <#if parameters.templateCssPath?exists>
	templateCssPath="<@s.url value='${parameters.templateCssPath}' encode="false" includeParams='none'/>"
  </#if>
  type="hidden"
  <#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
/>
<div id="${parameters.id?replace('/','_')?html}_datepicker"></div>
<div style="clear:both;"></div>
<script type="text/javascript">
	$(document).ready(function() {
		$('#${parameters.id?replace('/','_')?html}_datepicker')
			.datepicker({
				altField: '#${parameters.id?replace('/','_')?html}',
				altFormat: 'dd/mm/yy',
				nextText: '',
				prevText: ''
			});
	});
</script>
<#include "controlfooter.ftl" />