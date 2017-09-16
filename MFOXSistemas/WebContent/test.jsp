<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TEST</title>
</head>
<body>
<jsp:useBean id="listaQuemSomos" class="br.com.mfoxsistemas.bo.QuemSomosBO"></jsp:useBean>
<c:set var="quemSomos" value="${listaQuemSomos.getAtivo() }" ></c:set>	
	<c:forEach items="${quemSomos.getSomos() }" var="paragrafo" >
		 <p>${paragrafo.texto }</p>
	</c:forEach>
</body>
</html>