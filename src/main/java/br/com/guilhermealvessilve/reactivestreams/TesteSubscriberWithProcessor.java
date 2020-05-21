package br.com.guilhermealvessilve.reactivestreams;

import br.com.guilhermealvessilve.reactivestreams.model.NotaFiscal;
import br.com.guilhermealvessilve.reactivestreams.reactive.NotaFiscalFilter;
import br.com.guilhermealvessilve.reactivestreams.reactive.NotaFiscalSubscriber;
import br.com.guilhermealvessilve.reactivestreams.wsclient.NotaFiscalWSClient;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TesteSubscriberWithProcessor {

	public static void main (final String[] args) throws InterruptedException {

		//Novidade Java 11
		final int numberMaxRequests = 1;
		final var notasFiscais = List.of(
				new NotaFiscal("Maria", -5.50, LocalDate.now()),
				new NotaFiscal("João", 39.99, LocalDate.now()),
				new NotaFiscal("Renata", 41.20, LocalDate.now()),
				new NotaFiscal("Paulo", 32.10, LocalDate.now()),
				new NotaFiscal("Fernanda", 15.00, LocalDate.now()),
				new NotaFiscal("Carlos", -65.52, LocalDate.now())
		);

		final NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();

		final var executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberMaxRequests);
		executor.prestartAllCoreThreads();
		
		try (final var publisher = new SubmissionPublisher<NotaFiscal>(executor, numberMaxRequests)) {
			final var subscriber = new NotaFiscalSubscriber(numberMaxRequests, nfwsc);
			final var filter = new NotaFiscalFilter(numberMaxRequests);
			filter.subscribe(subscriber);
			publisher.subscribe(filter);
			notasFiscais.forEach(publisher::submit);
			System.out.println("Você irá receber a nota fiscal no seu e-mail");
			try (final var scan = new Scanner(System.in)) {
				scan.nextLine();
			}

			filter.getNotasFiscaisParaReprocessar()
					.forEach(nf -> System.out.println("Corrigindo nf: " + nf.getNome()));
		}

		executor.shutdownNow();
		executor.awaitTermination(1, TimeUnit.MINUTES);
	}
}
