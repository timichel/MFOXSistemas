<%@page import="java.io.PrintWriter"%>
<%@page import="br.com.mfoxsistemas.model.QuemSomos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="listaQuemSomos" class="br.com.mfoxsistemas.bo.QuemSomosBO"></jsp:useBean>
<c:set var="quemSomos" value="${listaQuemSomos.getAtivo() }" ></c:set>	

	<h5 style="text-align: center;letter-spacing: 2px; font-family: Montserrat; line-height: 1.4;border-bottom:1px solid;">Quem Somos</h5>
    <div class="row center">
   
    	<c:forEach items="${quemSomos.getSomos() }" var="paragrafo" >
     		 <h5 class="header col s12 light" style="font-family: Montserrat;">${paragrafo.texto }</h5>
    	</c:forEach>
    
      </div>    
    <br><br>
    
</body>

</html>