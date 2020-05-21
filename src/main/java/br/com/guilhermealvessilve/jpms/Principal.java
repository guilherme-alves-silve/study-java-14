package br.com.guilhermealvessilve.jpms;

import br.com.guilhermealvessilve.jpms.http.dao.LivroDAO;
import br.com.guilhermealvessilve.jpms.modelo.dominio.NotaFiscal;
import br.com.guilhermealvessilve.jpms.nf.util.NotaFiscalUtil;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Principal {

	public static void main (final String[] args) {
		System.out.println("Listando todos os livros");
		final var livros = new LivroDAO().listar();

		IntStream.range(0, livros.size())
				.forEach(i -> System.out.println(i + " - " + livros.get(i).getNome()));

		try (final var scanner = new Scanner(System.in)) {
			System.out.println("Qual livro deseja?");
			final var numero = scanner.nextInt();

			System.out.println("Livro escolhido é o: " + livros.get(numero).getNome());

			System.out.println("Favor inserir seu nome para gerar nota fiscal");
			final var nome = scanner.next();

			final var util = new NotaFiscalUtil();

			util.emitir(new NotaFiscal(nome));

			System.out.println("Obrigado!!");

			scanner.nextLine();

			util.fechar();
		}

	}

}
