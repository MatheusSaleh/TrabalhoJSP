package fema3bccJsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArtistaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operacao = request.getParameter("operacao");
		if (operacao.equals("Cadastrar")) {
			cadastrar(request);
			redirecionar(request, response, "menu.jsp");
		} else if (operacao.equals("Cadastrar Artista")) {
			redirecionar(request, response, "cadastrarArtista.jsp");
		} else if (operacao.equals("Consultar Artista")) {
			List<Artista> artistas = new ArtistaDao().getArtistas();
			request.setAttribute("artistas", artistas);
			redirecionar(request, response, "consultarArtista.jsp");
		} else if (operacao.equals("Excluir")) {
			Integer id = Integer.parseInt(request.getParameter("codigoArtista"));
			new ArtistaDao().excluir(id);
			redirecionar(request, response, "menu.jsp");	
		}
	}

	private void redirecionar(HttpServletRequest request, HttpServletResponse response, String nomePagina)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher(nomePagina);
		rd.forward(request, response);
	}

	private void cadastrar(HttpServletRequest req) {
		String codigo = req.getParameter("codigoArtista");
		String nome = req.getParameter("nomeArtista");
		String gravadora = req.getParameter("gravadora");
		Artista a = new Artista();
		a.setCodigo(Integer.parseInt(codigo));
		a.setNome(nome);
		a.setGravadora(gravadora);

		ArtistaDao dao = new ArtistaDao();
		dao.add(a);

	}

}
