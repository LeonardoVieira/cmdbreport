<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="shortcut icon" type="image/x-icon" href="/resources/img/icon.ico" />
		<script src="http://webpcapvwbr01/teste/scripts/funcoes_gerais.js" type="text/javascript"></script>
	    <link href="http://webpcapvwbr01/teste/styles/html.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript">
		    function Mudarestado(el) {
		        var display = document.getElementById(el).style.display;
		        if(display == "none") {
		        	document.getElementById(el).style.display = 'block';
		        } else {
		            document.getElementById(el).style.display = 'none';
		        }
		    }
	    </script>
	    <style type="text/css">
	        .imagem_topo{width: 800px;height: 60px;}
	        .div_nome_area{font-family: Verdana;font-weight: bold;font-style: italic;font-size: large;position: Absolute;margin-top: 15px;margin-left: 150px;}
	        .div_nome_usuario{font-family: Verdana;font-style: italic;font-size: x-small;position: Absolute;margin-top: 40px;margin-left: 10px;}
	        .style3{font-family: Verdana;font-weight: bold;font-style: italic;font-size: large;position: Absolute;margin-top: 15px;margin-left: 150px;color: black;}
			table, th, td {border: 1px solid grey;border-collapse: collapse;padding: 5px;}
			th {background-color: #f1f1f1;}
	    </style>
</head>
	<div class="style3"  style="mso-fareast-font-family: Calibri; mso-fareast-theme-font: minor-latin; mso-ansi-language: PT-BR; mso-fareast-language: PT-BR; mso-bidi-language: AR-SA"> 
		
	</div>
<body style="margin-top: 0; margin-left: 0;" bgcolor="white">
	<div>
   		<img id="img_topo" src="http://webpcapvwbr01/teste/images/topo.gif" style="height:78px;width:1350px;" />
   	</div>
	<a href="exportCsv">
		<button>Exportar</button>
	</a>

	<br><br>
	Quantidade de hostname: ${hostname} <br>
	Quantidade de Instance Name: ${instanceName}<br><br>

	<c:forEach items="${response}" var="response">
		<fieldset>
	        <legend>
	            <b>${response.name} - ${response.quantity}</b>
	        </legend>
	        <label onclick="Mudarestado('div${response.name}')">Exibir - ${response.name} - ${response.quantity}</label><br><br>
			<div id="div${response.name}" style="display:none">
				<c:if test="${show}">
			    	Quantidade de hostname: ${response.hostname} <br>
					Quantidade de Instance Name: ${response.instanceName}<br><br>
				</c:if>
				<table style="width: 100%">
					<tr>
						<th>Tipo</th>
						<th>Instance Name</th>
						<th>Hostname</th>
						<th>Datacenter</th>
						<th>Service Component</th>
						<th>Technical Service</th>
						<th>Business Service</th>
						<th>Rede</th>
					</tr>
		
					<c:forEach items="${response.results}" var="result" varStatus="teste">
						<tr>
							<td>${result.type}</td>
							<td>${result.instanceName}</td>
							<td>${result.hostname}</td>
							<td>${result.datacenter}</td>
							<td>${result.serviceComponent}</td>
							<td>${result.technicalService}</td>
							<td>${result.businessService}</td>
							<td>${result.rede}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</fieldset>
		<br><br>
	</c:forEach>
</body>
</html>