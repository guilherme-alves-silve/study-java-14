package br.com.guilhermealvessilve.reactivestreams;

import br.com.guilhermealvessilve.reactivestreams.model.NotaFiscal;
import br.com.guilhermealvessilve.reactivestreams.reactive.NotaFiscalSubscriber;
import br.com.guilhermealvessilve.reactivestreams.wsclient.NotaFiscalWSClient;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TesteSubscriber {

	public static void main (final String[] args) throws InterruptedException {

		//Novidade Java 11
		final int numberMaxRequests = 1;
		final var notasFiscais = List.of(
				new NotaFiscal("João", 39.99, LocalDate.now()),
				new NotaFiscal("Renata", 41.20, LocalDate.now()),
				new NotaFiscal("Paulo", 32.10, LocalDate.now()),
				new NotaFiscal("Fernanda", 15.00, LocalDate.now())
		);

		final NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();

		final var executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberMaxRequests);
		executor.prestartAllCoreThreads();
		
		try (final var publisher = new SubmissionPublisher<NotaFiscal>(executor, numberMaxRequests)) {
			final var subscriber = new NotaFiscalSubscriber(numberMaxRequests, nfwsc);
			publisher.subscribe(subscriber);
			notasFiscais.forEach(publisher::submit);
			System.out.println("Você irá receber a nota fiscal no seu e-mail");
			try (final var scan = new Scanner(System.in)) {
				scan.nextLine();
			}
		}

		executor.shutdownNow();
		executor.awaitTermination(1, TimeUnit.MINUTES);
	}
}
