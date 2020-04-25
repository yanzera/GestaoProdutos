package service;

import java.util.ArrayList;

import dao.ProdutosDAO;
import model.Produto;

public class ProdutoService {

	private ProdutosDAO produtosDAO;
	
	/**
	 * Instancia um objeto ProfessorDAO dentro do atributo professorDAO.
	 */
	public ProdutoService() {
		this.produtosDAO = new ProdutosDAO();
	}
	
	public void cadastrar(Produto produto) {
		this.produtosDAO.cadastrar(produto);
	}
	
	public void alterar(Produto produto) {
		this.produtosDAO.alterar(produto);
	}
	
	public void excluir(Produto produto) {
		this.produtosDAO.excluir(produto);
	}
	
	public Produto consultar(int codigo) {
		return this.produtosDAO.consultar(codigo);
	}
	
	public ArrayList<Produto> listarProdutos() {
		return this.produtosDAO.listarProdutos();
	}
}


