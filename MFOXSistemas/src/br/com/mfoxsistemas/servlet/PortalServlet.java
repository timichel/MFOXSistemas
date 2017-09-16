package br.com.mfoxsistemas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mfoxsistemas.bo.QuemSomosBO;
import br.com.mfoxsistemas.model.Paragrafo;
import br.com.mfoxsistemas.model.QuemSomos;


@WebServlet("/PortalServlet")
public class PortalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private QuemSomos quemSomos = null;
     private QuemSomosBO bo = null;
     private String acao = null;
    
    public PortalServlet() {
    	bo = new QuemSomosBO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		List<QuemSomos> listQuemSomos = new ArrayList<>();
		PrintWriter writer = response.getWriter();
		writer.println("ACAO DO GET");
		writer.print(acao);
		if(acao.equals("listar")){
			bo = new QuemSomosBO();
			listQuemSomos = bo.getquemSomos();
		}
		request.setAttribute("listaQuemSomos", listQuemSomos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("gerenciaQuemSomos.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		acao = request.getParameter("acao");
		PrintWriter writer = response.getWriter();
		writer.println("Chegou no servlet pelo post");
		writer.print("Parametro de acao recebido: "+acao);
		
		if(acao.equals("salvar")){
			writer.println("Salvando linha");
			bo.inserir(quemSomos);
			quemSomos = null;
			RequestDispatcher dispatcher = request.getRequestDispatcher("gerenciaQuemSomos.jsp");
			dispatcher.forward(request, response);
		}
		if(acao.equals("adicionar")){
     		if(quemSomos == null){
     			quemSomos = new QuemSomos();
     		}
			Paragrafo p = new Paragrafo(
					request.getParameter("tamFonte").toString(),
					request.getParameter("texto").toString()
			);
			quemSomos.addQuemSomos(p);
			request.setAttribute("quemSomos", quemSomos.getSomos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastraQuemSomos.jsp");
			dispatcher.forward(request, response);	
		}
		if(acao.equals("findById")){
			int Id = Integer.parseInt(request.getParameter("Id"));
     			quemSomos = new QuemSomos();
     			quemSomos = bo.getById(Id);
			request.setAttribute("quemSomos", quemSomos.getSomos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastraQuemSomos.jsp");
			dispatcher.forward(request, response);	
		}
		if(acao.equals("excluir")){
			int Id = Integer.parseInt(request.getParameter("Id"));
			String msg = null;
     			int result = bo.delete(Id);
     			if(result==0)
     				 msg = "Excluido com sucesso";
     			else
     				msg = "Falha ao exlcuir";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("gerenciaQuemSomos.jsp");
			dispatcher.forward(request, response);	
		}
		if(acao.equals("ativar")){
			int Id = Integer.parseInt(request.getParameter("Id"));
			String msg = null;
     			int result = bo.setAtivo(Id);
     			if(result==0)
     				 msg = "Ativado com sucesso";
     			else
     				msg = "Falha ao ativar";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("gerenciaQuemSomos.jsp");
			dispatcher.forward(request, response);	
		}
		if(acao.equals("excluirParagrafo")){//pegar o metodo findById e depois um bo.inserir
			int PosicaoParagrafo = Integer.parseInt(request.getParameter("PosicaoParagrafo"));
			quemSomos.getSomos().remove(PosicaoParagrafo);
			bo.endsSession();
			request.setAttribute("quemSomos", quemSomos.getSomos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastraQuemSomos.jsp");
			dispatcher.forward(request, response);	
		}
		
	}

}
