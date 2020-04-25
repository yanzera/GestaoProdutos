package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;


import java.sql.ResultSet;

public class ProdutosDAO {
	
	private Connection conexao;
	
	public ProdutosDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Produto produto) {
			
		String inserir = "INSERT INTO produto "
				+ " (codigo, nome, descricao, valor, estoque) "
				+ " VALUES (?, ?, ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getDescricao());
			pst.setDouble(4, produto.getValor());
			pst.setInt(5, produto.getEstoque());
			
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Produto produto) {
		
		String inserir = "UPDATE produto "
				+ "SET nome= ?, descricao= ?, valor= ? , estoque= ? "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricao());
			pst.setDouble(3, produto.getValor());
			pst.setInt(4, produto.getEstoque());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Produto produto) {
		
		String inserir = "DELETE FROM produto "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, produto.getCodigo());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
		}
	}
	
	public Produto consultar(int codigo) {
		
		String inserir = "SELECT * FROM produto"
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, codigo);
			ResultSet resultado = pst.executeQuery();
			
			Produto p = new Produto();
			if (resultado.next()) {
				p.setNome(resultado.getString("nome"));
				p.setDescricao(resultado.getString("descricao"));
				p.setNome("nome");
				p.setDescricao(resultado.getString("descricao"));
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Produto> listarProdutos() {
		
		String inserir = "SELECT * FROM produto";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Produto> lista = new ArrayList<>();
			while (resultado.next()) {
				Produto p = new Produto();
				p.setCodigo(resultado.getInt("codigo"));
				p.setNome(resultado.getString("nome"));
				p.setDescricao(resultado.getString("descricao"));
				p.setValor(resultado.getDouble("valor"));
				p.setEstoque(resultado.getInt("estoque"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
