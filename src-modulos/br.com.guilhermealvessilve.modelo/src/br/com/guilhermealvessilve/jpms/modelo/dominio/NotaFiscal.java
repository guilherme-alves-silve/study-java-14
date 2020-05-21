package br.com.guilhermealvessilve.jpms.modelo.dominio;

import java.time.LocalDate;

public class NotaFiscal {

	private final  String nome;
	private final LocalDate data;
	private final Double valor;

	public NotaFiscal(final String nome) {
		this.nome = nome;
		this.data = LocalDate.now();
		this.valor = 39.99;
	}

	@Override
	public String toString() {
		return "Nota fiscal gerada no nome de " + nome + " dia " + data + " no valor de " + valor;
	}
}
