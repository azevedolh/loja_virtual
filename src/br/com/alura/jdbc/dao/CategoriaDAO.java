package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDAO {

	Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Categoria categoria) throws SQLException {
		String sqlQuery = "INSERT INTO CATEGORIA (NOME) VALUES (?)";

		try (PreparedStatement pstm = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, categoria.getNome());
			pstm.execute();

			try (ResultSet resultSet = pstm.getGeneratedKeys()) {
				while (resultSet.next()) {
					categoria.setId(resultSet.getInt(1));
				}
			}
		}
	}

	public List<Categoria> listar() throws SQLException {
		String sqlQuery = "SELECT * FROM CATEGORIA";
		List<Categoria> categorias = new ArrayList<Categoria>();

		try (PreparedStatement pstm = connection.prepareStatement(sqlQuery)) {
			pstm.execute();

			try (ResultSet resultSet = pstm.getResultSet()) {
				while (resultSet.next()) {
					Categoria categoria = new Categoria(resultSet.getInt("ID"), resultSet.getString("NOME"));
					categorias.add(categoria);
				}
			}
		}

		return categorias;
	}

	public List<Categoria> listarComProdutos() throws SQLException {
		String sqlQuery = "SELECT A.ID, A.NOME, B.ID, B.NOME, B.DESCRICAO FROM CATEGORIA A LEFT JOIN PRODUTO B ON A.ID = B.CATEGORIA_ID";

		Categoria ultima = null;
		List<Categoria> categorias = new ArrayList<Categoria>();

		try (PreparedStatement pstm = connection.prepareStatement(sqlQuery)) {
			pstm.execute();

			try (ResultSet resultSet = pstm.getResultSet()) {
				while (resultSet.next()) {
					if (ultima == null || !ultima.getId().equals(resultSet.getInt("A.ID"))) {
						Categoria categoria = new Categoria(resultSet.getInt("A.ID"), resultSet.getString("A.NOME"));
						ultima = categoria;
						categorias.add(categoria);
					}
					Produto produto = new Produto(resultSet.getInt("B.ID"), resultSet.getString("B.NOME"),
							resultSet.getString("B.DESCRICAO"));

					if (!produto.getId().equals(0) && produto.getNome() != null) {
						ultima.adicionar(produto);
					}

				}
			}
		}

		return categorias;
	}

}
