package br.com.alura.jdbc.modelo;

public class Produto {
	public Integer id;
	public String nome;
	public String descricao;

	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getId() {
		return this.id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

}
