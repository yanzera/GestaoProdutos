package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

@WebServlet("/ExcluirProduto.do")
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Captura de parâmetros: (a matrícula do professor a ser excluído do BD)
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		// Instanciando um objeto do tipo professor:
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		
		// Solicitando à service que remova o professor:
		ProdutoService produtoService = new ProdutoService();
		produtoService.excluir(produto);
		
	}

}
