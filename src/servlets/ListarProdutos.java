package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProdutoService;
import model.Produto;

@WebServlet("/ListarProdutos.do")
public class ListarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Solicitar à service a lista de professores:
		ProdutoService produtoService = new ProdutoService();
		// Instanciando uma lista de professores (vazia):
		ArrayList<Produto> listaProdutos = null;
		// Carregando a lista com os professores do banco de dados:
		listaProdutos = produtoService.listarProdutos();
		
		// Definir o tipo de conteúdo a ser enviado:
		response.setContentType("text/html");
		
		// Criando um objeto de saída de caracteres:
		PrintWriter saida = response.getWriter();
		
		// Percorrer toda a lista de objetos professor e imprimir os dados:
		saida.println("<html>");
		saida.println("<body>");
		saida.println("<table>");
		
		listaProdutos.forEach( 
			p -> {
				saida.println("<tr>");
				saida.println("<td>");
				saida.println(p.getNome());
				saida.println("</td>");
				saida.println("<td>");
				saida.println(p.getDescricao());
				saida.println("</td>");
				saida.println("<td>");
				saida.println(p.getValor());
				saida.println("</td>");
				saida.println("<td>");
				saida.println(p.getEstoque());
				saida.println("</td>");
				
				/* Criando uma coluna para o link de exclusão: */
				saida.println("<td>");
				saida.println("<a href='ExcluirProduto.do?codigo=" 
							+ p.getCodigo() + "'> Excluir </a>");
				
				saida.println("</td>");
				
				/* Criando uma coluna para o link de atualização: */
				saida.println("<td>");
				saida.println("<a href='AlterarProduto.do?codigo="
							+ p.getCodigo() + "'> Alterar </a>");
				saida.println("</td>");
				
				saida.println("</tr>");
			} 
		);
		
		saida.println("</table>");
		
	}

}