package fema3bccJsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlbumControlador
 */
public class AlbumControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String operacao = request.getParameter("operacao");
    	if(operacao.equals("Cadastrar Novo Album")) {
    		cadastrar(request);
    		redirecionar(request, response, "menu.jsp");
    	} else if (operacao.equals("Cadastrar Album")) {
    		redirecionar(request, response, "cadastrarAlbum.jsp");
    	} else if (operacao.equals("Consultar Album")) {
    		List<Album> albuns = new AlbumDao().getAlbuns();
    		request.setAttribute("albuns", albuns);
    		redirecionar(request, response, "consultarAlbum.jsp");
    	} else if (operacao.equals("Excluir")) {
    		Integer id = Integer.parseInt(request.getParameter("codigoAlbum"));
    		new AlbumDao().excluir(id);
    		redirecionar(request, response, "menu.jsp");
    	}
    }
    
    
    private void redirecionar(HttpServletRequest request, HttpServletResponse response, String nomePagina)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(nomePagina);
		rd.forward(request, response);
	}
    
    private void cadastrar(HttpServletRequest req) {
    	String codigo = req.getParameter("codigoAlbum");
    	String nome = req.getParameter("nomeAlbum");
    	Album a = new Album();
    	a.setCodigo(Integer.parseInt(codigo));
    	a.setNome(nome);
    	
    	AlbumDao dao = new AlbumDao();
    	dao.add(a);
    }
}
