package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;


@WebServlet("/CadastrarProduto.do")
public class CadastrarProduto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		//Recebendo dados do usuário: (capturando os parametros)
       		int codigo =  Integer.parseInt(request.getParameter("codigo_produto"));
       		String nome = request.getParameter("nome_produto");
       		String descricao = request.getParameter("descricao_produto");
       		double valor = Double.parseDouble(request.getParameter("valor_produto"));
       		int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
       		
       		
       		//Instanciar um objeto do tipo professor
       		Produto produto = new Produto();
       		produto.setCodigo(codigo);
       		produto.setNome(nome);
       		produto.setDescricao(descricao);
       		produto.setValor(valor);
       		produto.setEstoque(estoque);
       		
       		//Enviar o objeto professor para a service
       		ProdutoService produtoService = new ProdutoService();
       		produtoService.cadastrar(produto);
       		
       		PrintWriter saida = response.getWriter();
    		saida.println("Produto Cadastrado com sucesso");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
