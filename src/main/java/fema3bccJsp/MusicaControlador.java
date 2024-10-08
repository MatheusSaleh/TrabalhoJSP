package fema3bccJsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MusicaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String operacao = request.getParameter("operacao");
    	if(operacao.equals("Cadastrar Nova Musica")) {
    		cadastrar(request);
    		redirecionar(request, response, "menu.jsp");
    	} else if (operacao.equals("Cadastrar Musica")) {
    		redirecionar(request, response, "cadastrarMusica.jsp");
    	} else if (operacao.equals("Consultar Musica")) {
    		List<Musica> musicas = new MusicaDao().getMusicas();
    		request.setAttribute("musicas", musicas);
    		redirecionar(request, response, "consultarMusica.jsp");
    	} else if (operacao.equals("Excluir")) {
    		Integer id = Integer.parseInt(request.getParameter("codigoMusica"));
    		new MusicaDao().excluir(id);
    		redirecionar(request, response, "menu.jsp");
    	}
    }
    
    
    private void redirecionar(HttpServletRequest request, HttpServletResponse response, String nomePagina)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(nomePagina);
		rd.forward(request, response);
	}
    
    private void cadastrar(HttpServletRequest req) {
    	String codigo = req.getParameter("codigoMusica");
    	String nome = req.getParameter("nomeMusica");
    	Musica m = new Musica();
    	m.setCodigo(Integer.parseInt(codigo));
    	m.setNome(nome);
    	
    	MusicaDao dao = new MusicaDao();
    	dao.add(m);
    }
   
}
