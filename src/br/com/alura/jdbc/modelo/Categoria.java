package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	public Integer id;
	public String nome;
	public List<Produto> produtos = new ArrayList<Produto>();

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return this.id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void adicionar(Produto produto) {
		this.produtos.add(produto);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Categoria {id=" + id + ", nome=" + nome + ", produtos=");

		for (Produto produto : this.produtos) {
			sb.append("[nome=" + produto.getNome() + ", descricao=" + produto.getDescricao() + "]");
		}

		if (produtos.isEmpty()) {
			return sb.append("[]}").toString();
		}

		return sb.append("}").toString();
	}

}
