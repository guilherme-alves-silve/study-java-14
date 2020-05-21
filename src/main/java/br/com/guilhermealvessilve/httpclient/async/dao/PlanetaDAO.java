package br.com.guilhermealvessilve.httpclient.async.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class PlanetaDAO {

	private static final String URL = "http://localhost:8080/planetas";

	public void listar () throws URISyntaxException, IOException, InterruptedException {
		final HttpClient httpClient = HttpClient.newBuilder()
				.build();

		final HttpResponse<String> send = httpClient.send(
				HttpRequest.newBuilder().uri(new URI(URL))
						.GET()
						.build(),
				BodyHandlers.ofString());

		System.out.println("Body: " + send.body());
	}

	public void listarAsync () throws URISyntaxException {

		System.out.println("Executing async: ");
		
		final HttpClient httpClient = HttpClient.newBuilder()
				.build();

		httpClient.sendAsync(
				HttpRequest.newBuilder().uri(new URI(URL))
						.GET()
						.build(),
				BodyHandlers.ofString())
				.whenComplete((success, throwable) -> {
					if (throwable != null) {
						System.out.println("Error: " + throwable.getMessage());
						return;
					}

					System.out.println("Body Async: " + success.body());
				});
	}
}
