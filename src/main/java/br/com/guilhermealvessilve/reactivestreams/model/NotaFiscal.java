package br.com.guilhermealvessilve.reactivestreams.model;

import java.time.LocalDate;
import java.util.StringJoiner;

public class NotaFiscal {

	private final String nome;

	private final Double valor;

	private final LocalDate data;

	public NotaFiscal (
			final String nome,
			final Double valor,
			final LocalDate data
	) {
		this.nome = nome;
		this.valor = valor;
		this.data = data;
	}

	public String getNome () {
		return nome;
	}

	public LocalDate getData () {
		return data;
	}
	
	public Double getValor () { return valor; }

	@Override
	public String toString () {
		return new StringJoiner(", ", NotaFiscal.class.getSimpleName() + "[", "]")
				.add("nome='" + nome + "'")
				.add("valor=" + valor)
				.add("data=" + data)
				.toString();
	}
}
