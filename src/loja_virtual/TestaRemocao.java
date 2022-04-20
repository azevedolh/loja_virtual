package loja_virtual;

import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.createConnection();
		
		int quantidadeLinhasDeletadas = connectionFactory.executeDeleteStatement("DELETE FROM PRODUTO WHERE ID > 2");
		
		System.out.println("Quantidade de linhas deletadas do banco: " + quantidadeLinhasDeletadas);
		
		connectionFactory.closeConnection();
	}

}
