package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {

	Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {
		String sqlQuery = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)";

		try (PreparedStatement pstm = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.execute();

			try (ResultSet resultSet = pstm.getGeneratedKeys()) {
				while (resultSet.next()) {
					produto.setId(resultSet.getInt(1));
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {
		String sqlQuery = "SELECT * FROM PRODUTO";
		List<Produto> produtos = new ArrayList<Produto>();

		try (PreparedStatement pstm = connection.prepareStatement(sqlQuery)) {
			pstm.execute();

			try (ResultSet resultSet = pstm.getResultSet()) {
				while (resultSet.next()) {
					Produto produto = new Produto(resultSet.getInt("ID"), resultSet.getString("NOME"),
							resultSet.getString("DESCRICAO"));
					produtos.add(produto);
				}
			}
		}

		return produtos;
	}

}
