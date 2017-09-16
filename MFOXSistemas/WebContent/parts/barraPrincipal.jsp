  <nav class=" blue-grey darken-2" style="height: 100px;" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="index.jsp" class="brand-logo"><img src="<%= request.getServletContext().getContextPath() %>//resources//img//Logo.png"/></a>
      <ul class="right hide-on-med-and-down">
          <li><a href="index.jsp">Início</a></li>
          <li><a href="sobremim.jsp">Quem sou eu</a></li>
          <li><a href="#">Projetos</a></li>
          <li><a href="#">Contato</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="index.jsp">Início</a></li>
        <li><a href="sobremim.jsp">Quem sou eu</a></li>
        <li><a href="#">Projetos</a></li>
        <li><a href="#">Contato</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>