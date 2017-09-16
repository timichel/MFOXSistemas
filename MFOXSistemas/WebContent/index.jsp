<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MFOXSistemas</title>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="resources/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<style>
body{    background-image: url("resources/img/cafejava.png");
    background-repeat: repeat; }
</style>
<body>
<!-- BARRA DE MENU PRINCIPAL -->
<jsp:include page="./parts/barraPrincipal.jsp"></jsp:include>
<div class="section no-pad-bot" id="index-banner">
    <div class="container" style="background-color: white; border: 1 px solid grey;">
      <br><br>
      <!-- CABECALHO -->
      <jsp:include page="./parts/cabecalho.jsp"></jsp:include>
      <div class="section">

      <!--   SERVICOS   -->
      <div class="row">
      	<jsp:include page="./parts/servicos.jsp"></jsp:include>
      </div>
       <!--   SERVICOS   -->
      <div class="row">
      	<jsp:include page="./parts/comoTrabalhamos.jsp"></jsp:include>
      </div>
       <!-- FIM DA SECION -->
      </div>
      <!--   QUEM SOMOS   -->
      <div class="row">
      	<jsp:include page="./parts/quemSomos.jsp"></jsp:include>
      </div>
    <!--   FIM DO CONTAINER   -->  
 </div> 
 
 	  <!--   RODAPE   -->
      <div class="row">
      	<jsp:include page="./parts/rodape.jsp"></jsp:include>
      </div> 

<!--  Scripts-->
  <script src="resources/js/jquery-3.2.1.min.js"></script>
  <script src="resources/js/materialize.js"></script>
  <script src="resources/js/init.js"></script>
</body>
</html>