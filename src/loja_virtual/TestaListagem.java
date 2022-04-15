package loja_virtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		Connection conexao = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "teste");
		System.out.println("<<LOG>> Conexão realizada com sucesso");
		
		Statement stm = conexao.createStatement();
		stm.execute("SELECT * FROM PRODUTO");
		ResultSet resultado = stm.getResultSet();
		
		while (resultado.next()) {
			System.out.println(resultado.getInt("id"));
			System.out.println(resultado.getString("nome"));
			System.out.println(resultado.getString("descricao"));
		}
		
		conexao.close();
		System.out.println("<<LOG>> Conexão Encerrada");
	}

}
