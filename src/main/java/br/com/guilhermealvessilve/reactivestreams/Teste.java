package br.com.guilhermealvessilve.reactivestreams;

import br.com.guilhermealvessilve.reactivestreams.model.NotaFiscal;
import br.com.guilhermealvessilve.reactivestreams.wsclient.NotaFiscalWSClient;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

public class Teste {

	public static void main (final String[] args) throws InterruptedException {

		//Anteriormente
		final NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
		final Thread thread = new Thread(() -> {
			final List<NotaFiscal> notasFiscais = List.of(
					new NotaFiscal("João", 39.99, LocalDate.now()),
					new NotaFiscal("Renata", 41.20, LocalDate.now()),
					new NotaFiscal("Paulo", 32.10, LocalDate.now()),
					new NotaFiscal("Fernanda", 15.00, LocalDate.now())
			);

			notasFiscais.forEach(nf -> {
				nfwsc.enviar(nf);
				System.out.println("Parabéns pela compra!!");
			});
		});
		thread.start();

		//Novidade Java 11

		final var executors =Executors.newFixedThreadPool(2);
		final var primeiraNotaFiscal = new NotaFiscal("João", 39.99, LocalDate.now());
		/*
		 * //Pode ser também
		 * try (final var publisher = new SubmissionPublisher<NotaFiscal>()) {
		 */
		try (final var publisher = new SubmissionPublisher<NotaFiscal>(executors, 1)) {
			publisher.consume(nfwsc::enviar);
			publisher.submit(primeiraNotaFiscal);
			publisher.consume(nf -> System.out.println("Outra thread: " + Thread.currentThread().getName()));
			publisher.submit(primeiraNotaFiscal);
			System.out.println("Você irá receber a nota fiscal no seu e-mail");
			try (final var scan = new Scanner(System.in)) {
				scan.nextLine();
			}
		}

		thread.join();
	}
}
