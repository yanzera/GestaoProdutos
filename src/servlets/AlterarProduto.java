package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProdutoService;

import model.Produto;

import java.io.PrintWriter;

@WebServlet("/AlterarProduto.do")
public class AlterarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Capturando codigo do produto, que o usuário quer alterar:
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		// Solicitando à service os dados do professor da matrícula informada:
		ProdutoService produtoService = new ProdutoService();
		Produto produto= produtoService.consultar(codigo);
		
		// Saída:
		// Formulário para alterar os dados do professor:
		response.setContentType("text/html");
		
		// Criando um objeto para saída de caracteres:
		PrintWriter saida = response.getWriter();
		saida.println("<form action='AlterarProduto.do' method='post'>");
		saida.println("Produto: " + produto.getCodigo());
		saida.println("<input type=\"hidden\" name='codigo_produto' value='"
						+ produto.getCodigo() + "'> <br>");
		saida.println("Nome: ");
		saida.println("<input type='text' name='nome_produto' value='" 
						+ produto.getNome() + "'> <br> ");
		saida.println("Descricao: ");
		saida.println("<input type='text' name='descricao_produto' value='"
						+ produto.getDescricao() + "'> <br> ");
		saida.println("Valor: ");
		saida.println("<input type='text' name='valor_produto' value='"
						+ produto.getValor() + "'> <br>");
		saida.println("<input type='submit'> ");
		saida.println("</form>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

