<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<#import "/WEB-INF/macros/general-utils.ftl" as utl>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<#include "/WEB-INF/decorators/internal/head.ftl" />

		<script type="text/javascript" src="<@utl.staticUrl '/js/jquery/jquery-1.4.3.min.js' />"></script>       
		<script type="text/javascript" src="<@utl.staticUrl '/js/jquery/jquery.dataTables.js' />"></script>
		<script type="text/javascript" src="<@utl.staticUrl '/js/jquery/jquery.timeentry.min.js' />"></script>
		
        <link type="text/css" rel="stylesheet" media="all" href="<@utl.staticUrl "/css/components.css" />" />
        <!--[if lte IE 7]><link type="text/css" rel="stylesheet" media="all" href="<@utl.staticUrl "/css/components_IE.css" />"><![endif]-->
        
        <link type="text/css" rel="stylesheet" media="all" href="<@utl.staticUrl "/css/skeleton.css" />"/>
        <!--[if lte IE 7]><link type="text/css" rel="stylesheet" media="all" href="<@utl.staticUrl "/css/skeleton_IE.css" />"><![endif]-->

        <meta http-equiv="Content-Type" content="text/xhtml+xml; charset=UTF-8" />
        <meta name="language" content="pt-br" />
        
        <script type="text/javascript">
		<!--
		$(document).ready(function(){

				$('.header .menu').click(function(){
					
		        	if( !$(this).is('.selected') ) {
						
						if($(this).attr('id').match(/SubMenu$/)){
							$('.header.closed').addClass('opened');
							$('.header.closed').removeClass('closed');
						}		        	
		            	$('.line3').children().hide();
	  		           
		                $('.menu.selected').removeClass('selected');
		                		                
						$(this).addClass('selected');
						if($(this).attr('id').match(/SubMenu$/)){
							$('.'+$(this).attr('id')).fadeIn();
						}else{
							$('.header.opened').addClass('closed');
							$('.header.opened').removeClass('opened');
							$('.header .line3').children().hide();
						}
                        $('.header .menu.selected').removeClass('selected');
                        $(this).addClass('selected');  		                       
		            }
		        });
		        <#if menu?has_content>
		        	$('#${menu}').click();
		        </#if>	
		});
		-->
		</script>
        
        ${head}
	</head>
	<body>
		<div id="container">
		
			<div id="header">

				<div class="header closed">		
					<div class="boxHeader1"><div class="boxHeader2"><div class="boxHeader3"><div class="boxHeader4">
						<img src="<@utl.staticUrl "/img/webbLogo.gif"/>" alt="Webb" class="logo"/>
						<div class="line1">
							<h2 class="title02">POC-MongoDB</h2>
							<#--
							<dl class="user">
								<dt>Usuário:</dt>
									<dd>${authentication.principal}</dd>
							</dl>
							-->
						</div>
						<div class="line2">
						<#--
							<ul class="menu1">
								<li class="menu drop" id="atributosSubMenu"><a href="#"><span>Atributos</span></a></li>
							</ul>
						-->
						</div>
						<div class="line3">
						<#--
							<ul class="subMenu atributosSubMenu">
								<li><a id="atributo_link" href="<@s.url action="atributo/list" />"><span><@s.text name="Atributo" /></span></a></li>	
								<li><a id="atributoDocumento_link" href="<@s.url action="atributoDocumento/list" />"><span><@s.text name="AtributoDocumento" /></span></a></li>	
								<li><a id="grupoAtributo_link" href="<@s.url action="grupoAtributo/list" />"><span><@s.text name="GrupoAtributo" /></span></a></li>	
								<li><a id="configuracaoAtributo_link" href="<@s.url action="configuracaoGrupoAtributo/list" />"><span><@s.text name="ConfiguracaoGrupoAtributo" /></span></a></li>
								<li><a id="enumerado_link" href="<@s.url action="enumerado/list" />"><span><@s.text name="Enumerado" /></span></a></li>
								<li><a id="associacoes_link" href="<@s.url action="associacao/list" />"><span><@s.text name="Associações" /></span></a></li>
							</ul>	
						-->	
						</div>
					</div></div></div></div>
				
				</div>


			</div>
			
			<div id="content">
				${body}
			</div>
		</div>
		<script type="text/javascript">
				$('.datatable').dataTable({
				"sPaginationType": "full_numbers",
				"sPageButton": "button1",
				"oLanguage": {
					"sProcessing":   "Processando...",
					"sLengthMenu":   "Mostrar _MENU_ registros",
					"sZeroRecords":  "Não foram encontrados resultados",
					"sInfo":         "Mostrando de _START_ até _END_ de _TOTAL_ registros",
					"sInfoEmpty":    "Mostrando de 0 até 0 de 0 registros",
					"sInfoFiltered": "(filtrado de _MAX_ registros no total)",
					"sInfoPostFix":  "",
					"sSearch":       "Buscar:",
					"sUrl":          "",
					"oPaginate": {
						"sFirst":    "Primeiro",
						"sPrevious": "Anterior",
						"sNext":     "Seguinte",
						"sLast":     "Último"
					}
				}
			});
	 	</script>
	</body>
</html>
