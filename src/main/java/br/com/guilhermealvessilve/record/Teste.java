package br.com.guilhermealvessilve.record;

import java.time.LocalDate;

public class Teste {

	public static void main (final String[] args) {

		final var dummy = new Dummy();
		System.out.println(dummy);

		final var ponto = new Ponto(5, 10);
		System.out.println(ponto);
		System.out.println(ponto.x() + " - " + ponto.y());

		final var usuario = new Usuario(5, "Pedro", LocalDate.now().minusYears(52));
		System.out.println(usuario);
		System.out.println(usuario.formatted());
		System.out.println(usuario.id() + " - " + usuario.nome() + " - " + usuario.dataNascimento());
	}

	record Dummy() {}
	
	private record Ponto(int x, int y) {
		
	}

	public record Usuario(int id, String nome, LocalDate dataNascimento) {

		public Usuario {
			if ((null == nome) ||
					(null == dataNascimento)) {
				throw new IllegalArgumentException("Null nome ou dataNascimento");
			}
		}

		public String formatted() {
			return String.format("%d - %s - %s",
					id,
					nome,
					dataNascimento);
		}
	}
}
