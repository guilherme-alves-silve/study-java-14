package br.com.guilhermealvessilve.jpms.modelo.dominio;

import java.util.List;

public class Livro {

	public Livro (
			final String nome,
			final String autor,
			final Categoria... categorias
	) {
		this.nome = nome;
		this.autor = autor;
		this.categorias = List.of(categorias);
	}

	private final String nome;

	private final String autor;

	private final List<Categoria> categorias;

	public String getNome () {
		return nome;
	}

	@Override
	public String toString () {
		return "\n" + nome + " - " + autor + " - " + categorias;
	}
}
