package br.com.guilhermealvessilve.jpms.http.dao;

import br.com.guilhermealvessilve.jpms.modelo.dominio.Categoria;
import br.com.guilhermealvessilve.jpms.modelo.dominio.Livro;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LivroDAO {

	public List<Livro> listar() {
		String resposta = null;
		final var httpClient = HttpClient.newHttpClient();
		try {
			resposta = httpClient
					.send(HttpRequest.newBuilder()
							.uri(new URI("https://turini.github.io/livro-java-9/books.csv"))
							.GET()
							.build(),
							BodyHandlers.ofString())
					.body();
		} catch (URISyntaxException | InterruptedException | IOException e) {
			throw new RuntimeException(e);
		}
		
		return Stream.of(resposta.split("\n"))
				.map(LivroDAO::formatar)
				.collect(Collectors.toList());
	}

	public static Livro formatar(final String resposta) {
		final String[] linhas = resposta.split(",");
		final String nome = linhas[0];
		final String autor = linhas[2];
		final Categoria categoria = Categoria.valueOf(linhas[3]);
		return new Livro(nome, autor, categoria);
	}

}
