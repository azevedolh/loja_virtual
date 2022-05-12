package loja_virtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().createConnection()) {
			connection.setAutoCommit(false);

			String sqlQuery = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

//		Statement stm = connection.createStatement();
//		stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ("Geladeira", "Geladeira Azul")", Statement.RETURN_GENERATED_KEYS);

			try (PreparedStatement stm = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

				adicionarProduto("Mouse", "Mouse sem fio", stm);
				adicionarProduto("Cadeira", "Cadeira de 4 pernas", stm);

				connection.commit();

			} catch (SQLException e) {
				e.printStackTrace();
				connection.rollback();
			}
		}

		System.out.println("<<LOG>> Conexão Encerrada");
	}

	private static void adicionarProduto(String nome, String descricao, PreparedStatement stm) throws SQLException {
		if (nome.equals("Cadeira")) {
			throw new RuntimeException("erro na inserção");
		}

		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();

		try (ResultSet resultado = stm.getGeneratedKeys()) {
			while (resultado.next()) {
				System.out.println("Id Inserido: " + resultado.getInt(1));
			}
		}
	}

}
