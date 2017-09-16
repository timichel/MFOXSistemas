<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function acao(valor) { 
	alert("javascript acionado"+valor);
	document.forms[0].action=valor;
	document.forms[0].submit();
	}
</script>
</head>
<body>
<form  method="post"  name="cadQuemSomos" id="cadQuemSomos" action="">
	<input type="hidden" id="acao">
Tamanho da Fonte:	
<input type="text" name="tamFonte" /><br/>
<br>
Texto:	
<input type="text" name="texto" /><br/>
<br>
<br>
<a href="#" onclick="acao('./PortalServlet?acao=adicionar');">Adicionar Item</a>
<a href="#" onclick="acao('./PortalServlet?acao=salvar');">Salvar</a>

</form>
<table>
<thead>
<tr>
	<th>Tamanho da Fonte</th>
	<th>Paragrafo</th>
</tr>
</thead>
<tbody>

<c:forEach items="${quemSomos }" var="paragrafo" varStatus="status">
<form method="post" action="">
		<tr>
		<td>${paragrafo.tamFonte }</td>
		<td>  ${paragrafo.texto }</td>
		<td>
			<a href="#" onclick="acao('./PortalServlet?acao=excluirParagrafo&PosicaoParagrafo=${status.index }')">Remover</a>
		</td>
		</tr>
</form>	
</c:forEach>

</tbody>
</table>
</body>
</html>