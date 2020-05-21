package br.com.guilhermealvessilve.httpclient.blocking;

import static java.net.http.HttpResponse.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Teste {

	public static void main (final String[] args) throws IOException, URISyntaxException, InterruptedException {

		//Anteriormente
		final URL url = new URL("https://www.casadocodigo.com.br");
		final URLConnection uc = url.openConnection();

		try (final BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()))) {

			String line = "";
			String readLine;
			while ((readLine = br.readLine()) != null) {
				line = line.concat(readLine)
						.concat(System.lineSeparator());
			}

			System.out.println(line);
		}

		System.out.println();

		//Novidade Java 11
		final HttpClient httpClient = HttpClient.newBuilder()
				.build();
		final HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://www.casadocodigo.com.br"))
				.build();
		final HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
		System.out.println(httpResponse.statusCode());
		System.out.println(httpResponse.version());
		System.out.println(httpResponse.body());
	}
}
