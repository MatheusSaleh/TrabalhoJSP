package fema3bccJsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaisControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operacao = request.getParameter("operacao");
		if (operacao.equals("Cadastrar")) {
			cadastrar(request);
			redirecionar(request, response, "menu.jsp");
		} else if (operacao.equals("Cadastrar Pais")) {
			redirecionar(request, response, "cadastrarPais.jsp");
		} else if (operacao.equals("Consultar Pais")) {
			List<Pais> paises = new PaisDao().getPaises();
			request.setAttribute("paises", paises);
			redirecionar(request, response, "consultarPais.jsp");
		} else if (operacao.equals("Excluir")) {
			Integer id = Integer.parseInt(request.getParameter("codigoPais"));
			new PaisDao().excluir(id);
			redirecionar(request, response, "menu.jsp");	
		}
	}

	private void redirecionar(HttpServletRequest request, HttpServletResponse response, String nomePagina)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher(nomePagina);
		rd.forward(request, response);
	}

	private void cadastrar(HttpServletRequest req) {
		String codigo = req.getParameter("codigoPais");
		String nome = req.getParameter("nomePais");
		String sigla = req.getParameter("siglaPais");
		Pais p = new Pais();
		p.setCodigo(Integer.parseInt(codigo));
		p.setNome(nome);
		p.setSigla(sigla);

		PaisDao dao = new PaisDao();
		dao.add(p);

	}

}
