 <#macro toolbar>
	<tr>
	    <td height="44" valign="top" background="${base}/static/img/bg_menuSubmenu.jpg">
	    	<table width="100%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
	            <tr>
	                <td width="2%"><img src="${base}/static/img/gif_transparente.png" width="15" height="20"></td>
	                <td width="2%" height="30"><img src="${base}/static/img/novo.png" width="14" height="18"></td>
	                <td width="1%"><img src="${base}/static/img/gif_transparente.png" width="15" height="20"></td>
	                <td width="4%"><img src="${base}/static/img/abrir.png" width="31" height="18"></td>
	                <td width="72%"><img src="${base}/static/img/configurar1.png" width="93" height="18"></td>
	                <td width="1%"><div align="center"><img src="${base}/static/img/barra.png" width="1" height="18"></div></td>
	                <td width="4%"><div align="center"><img src="${base}/static/img/home.png" width="16" height="18"></div></td>
	                <td width="5%"><div align="center"><img src="${base}/static/img/configurar2.png" width="37" height="18"></div></td>
	                <td width="3%"><div align="center"><img src="${base}/static/img/help.png" width="17" height="18"></div></td>
	                <td width="3%"><div align="center"><img src="${base}/static/img/sair.png" width="16" height="18"></div></td>
	                <td width="3%"><img src="${base}/static/img/gif_transparente.png" width="40" height="15"></td>
	            </tr>
	        </table>
	    </td>
	</tr>
 </#macro>
 
 <#macro staticURL value>${staticURLBase}/${value}</#macro>
 
 <#macro cronSelector label>
 	<table class="dateTable">
 	<tr>
    	<td>
	 	<#--
	 	<@s.checkboxlist label=label name="days" list=r"#{
	 		'SUN':getText('Domingo'),
	 		'MON':getText('Segunda-feira'),
	 		'TUE':getText('Terça-feira'),
	 		'WED':getText('Quarta-feira'),
	 		'THU':getText('Quinta-feira'),
	 		'FRI':getText('Sexta-feira'),
	 		'SAT':getText('Sábado')
	 	}" />
	 	<@s.textfield name="hour" id="mailConfiguration_save_hour" label="${action.getText('Horário')}"/>
	 	-->
	 	
	 	<#--
	 	<@s.checkboxlist label=label name="entity.scheduleDate.days" list=action.daysOfWeek />
	 	-->
	 	<@s.checkboxlist label=label name="entity.scheduleDate.days" list=r"#{
	 		'SUN':getText('Domingo'),
	 		'MON':getText('Segunda-feira'),
	 		'TUE':getText('Terça-feira'),
	 		'WED':getText('Quarta-feira'),
	 		'THU':getText('Quinta-feira'),
	 		'FRI':getText('Sexta-feira'),
	 		'SAT':getText('Sábado')
	 	}" />
	 	<@s.textfield name="entity.scheduleDate.time" id="mailConfiguration_save_hour" label="${action.getText('Horário')}"/>
	 	<script type="text/javascript">
			$('#mailConfiguration_save_hour').timeEntry({show24Hours: true, spinnerImage: ''});
		</script>
		</td>
	</tr>
	</table>
 </#macro>
 
	