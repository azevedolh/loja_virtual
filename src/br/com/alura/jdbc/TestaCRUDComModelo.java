package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaCRUDComModelo {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().createConnection()) {
			// Insert
			Produto produtoInsercao = new Produto("PS5", "Playstation 5");
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(produtoInsercao);
			// Listagem
			List<Produto> produtos = produtoDAO.listar();
			produtos.stream().forEach(produto -> System.out.println(produto));
		}

	}

}
