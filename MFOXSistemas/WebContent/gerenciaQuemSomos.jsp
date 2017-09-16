<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	button.accordion {
    background-color: #eee;
    color: #444;
    cursor: pointer;
    padding: 18px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
    transition: 0.4s;
}

button.accordion.active, button.accordion:hover {
    background-color: #ddd;
}

button.accordion:after {
    content: '\002B';
    color: #777;
    font-weight: bold;
    float: right;
    margin-left: 5px;
}

button.accordion.active:after {
    content: "\2212";
}

div.panel {
    padding: 0 18px;
    background-color: white;
    max-height: 0;
    overflow: hidden;
    transition: max-height 0.2s ease-out;
}
</style>

</head>
<body>
<p> ${msg }</p>
<a href="cadastraQuemSomos.jsp">Cadastrar</a>
<jsp:useBean id="listaQuemSomos" class="br.com.mfoxsistemas.bo.QuemSomosBO"></jsp:useBean>


<c:forEach items="${listaQuemSomos.getquemSomos() }" var="quemSomos" >
		
		<button class="accordion">${quemSomos.id}
		<form style="float:right;" method="post" action="./PortalServlet?acao=findById&Id=${quemSomos.id}">
			<input type="submit" value="Alterar"/>
		</form>
		<form style="float:right;" method="post" action="./PortalServlet?acao=excluir&Id=${quemSomos.id}">
			<input type="submit" value="Excluir"/>
		</form>
		<form style="float:right;" method="post" action="./PortalServlet?acao=ativar&Id=${quemSomos.id}">
			<c:if test="${quemSomos.ativo eq true }">
				<input type="radio" name="Ativo" checked="checked">
			</c:if>
			<c:if test="${quemSomos.ativo eq false }">
				<input type="radio" name="Ativo" >
			</c:if>
			<input type="submit" value="Ativar"/>
		</form>
			</button>
		<div class="panel">
		
			<table>
				<tr>
					<td>Fonte</td>
					<td>Paragrafo</td>
				</tr>
				<c:forEach items="${quemSomos.getSomos() }" var="paragrafo" >
				<tr>
					<td>${paragrafo.tamFonte }</td>
					<td>  ${paragrafo.texto }</td>
				</tr>
				</c:forEach>
			</table>
				
		</div>	
</c:forEach>
</body>

<script type="text/javascript">
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].onclick = function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight){
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    } 
  }
}
</script>
</body>
</html>