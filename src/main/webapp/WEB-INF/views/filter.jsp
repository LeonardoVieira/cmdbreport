<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>
			Filter
		</title>
	
		<link rel="shortcut icon" type="image/x-icon" href="/resources/img/icon.ico" />
		<script src="http://webpcapvwbr01/teste/scripts/funcoes_gerais.js" type="text/javascript"></script>
	    <link href="http://webpcapvwbr01/teste/styles/html.css" rel="stylesheet" type="text/css" />
	    <style type="text/css">
	        .imagem_topo
	        {
	            width: 800px;
	            height: 60px;
	        }
	        
	        .div_nome_area
	        {
	            font-family: Verdana;
	            font-weight: bold;
	            font-style: italic;
	            font-size: large;
	            position: Absolute;
	            margin-top: 15px;
	            margin-left: 150px;
	        }
	        
	        .div_nome_usuario
	        {
	            font-family: Verdana;
	            font-style: italic;
	            font-size: x-small;
	            position: Absolute;
	            margin-top: 40px;
	            margin-left: 10px;
	        }
	        .style3
	        {
	            font-family: Verdana;
	            font-weight: bold;
	            font-style: italic;
	            font-size: large;
	            position: Absolute;
	            margin-top: 15px;
	            margin-left: 150px;
	            color: black;
	        }
	    </style>
	
		<script type="text/javascript">
			function myJavascriptFunction() {
				window.location = "http://srvbigpvlbr09:8088/cmdb/filter?businessService=" + document.getElementById("businessService").value + 
						"&technicalService=" + document.getElementById("technicalService").value + 
						"&serviceComponent=" + document.getElementById("serviceComponent").value + 
						"&hostname=" + document.getElementById("hostname").value +
						"&networdDistribution=" + document.getElementById("networdDistribution").value + 
						"&datacenter=" + document.getElementById("datacenter").value + 
						"&show=" + document.getElementById("show").value;
			}
		</script>
	</head>
	<div class="style3"  style="mso-fareast-font-family: Calibri; mso-fareast-theme-font: minor-latin; mso-ansi-language: PT-BR; mso-fareast-language: PT-BR; mso-bidi-language: AR-SA"> 
		
	</div>
	<body style="margin-top: 0; margin-left: 0;" bgcolor="white">
		<form:form method="POST" action="/cmdb/makeSearch">
    
    	<div>
    		<img id="img_topo" src="http://webpcapvwbr01/teste/images/topo.gif" style="height:78px;width:1350px;" />
    	</div>
		<table>
			<tr>
				<td><form:label path="hostname">Hostname: </form:label></td>
				<td><form:input path="hostname" /></td>
			</tr>
			<tr>
				<td><form:label path="businessService">Business Service: </form:label></td>
				<td>
					<form:select id="businessService" path="businessService" onchange="myJavascriptFunction()" style="width: 200px">
						<form:option value="" label="--- Selecione ---" />
						<form:options items="${businessServiceList}" itemValue="value" itemLabel="label" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="technicalService">Technical Service: </form:label></td>
				<td>
					<form:select id="technicalService" path="technicalService" onchange="myJavascriptFunction()" style="width: 200px">
						<form:option value="" label="--- Selecione ---" />
						<form:options items="${technicalServiceList}" itemValue="value" itemLabel="label" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="serviceComponent">Service Component: </form:label></td>
				<td>
					<form:select id="serviceComponent" path="serviceComponent" onchange="myJavascriptFunction()" style="width: 200px">
						<form:option value="" label="--- Selecione ---" />
						<form:options items="${serviceComponentList}" itemValue="value" itemLabel="label" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="networdDistribution">Distribuited Network: </form:label></td>
				<td>
					<form:select id="networdDistribution" path="networdDistribution" onchange="myJavascriptFunction()" style="width: 200px">
						<form:option value="" label="--- Selecione ---" />
						<form:options items="${networkList}" itemValue="value" itemLabel="label" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="datacenter">Datacenter: </form:label></td>
				<td>
					<form:select id="datacenter" path="datacenter" onchange="myJavascriptFunction()" style="width: 200px">
						<form:option value="" label="--- Selecione ---" />
						<form:options items="${datacenterList}" itemValue="value" itemLabel="label" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="show">Mostrar estatisticas: </form:label></td>
				<td>
					<form:select id="show" path="show" style="width: 200px">
						<form:option value="true" label="Sim" />
						<form:option value="false" label="Não" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Buscar" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>