package br.com.guilhermealvessilve.reactivestreams.reactive;

import static java.util.concurrent.Flow.Processor;
import static java.util.concurrent.Flow.Subscription;

import br.com.guilhermealvessilve.reactivestreams.model.NotaFiscal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class NotaFiscalFilter extends SubmissionPublisher<NotaFiscal> implements Processor<NotaFiscal, NotaFiscal> {

	private final int numberMaxRequests;

	private Subscription subscription;
	private List<NotaFiscal> notasFiscaisParaReprocessar;

	public NotaFiscalFilter (final int numberMaxRequests) {
		this.numberMaxRequests = numberMaxRequests;
	}

	@Override
	public void onSubscribe (final Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(numberMaxRequests);
		this.notasFiscaisParaReprocessar = new ArrayList<>();
	}

	@Override
	public void onNext (final NotaFiscal item) {
		if (item.getValor() <= 0.0) {
			System.out.format("A nota fiscal de %s não será processada, corrigir.%n", item.getNome());
			notasFiscaisParaReprocessar.add(item);
		} else {
			submit(item);
		}

		this.subscription.request(numberMaxRequests);
	}

	@Override
	public void onError (final Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete () {
		System.out.println("As notas fiscais seguintes, devem ser reprocessadas: " + notasFiscaisParaReprocessar);
	}

	public List<NotaFiscal> getNotasFiscaisParaReprocessar() {
		return List.copyOf(notasFiscaisParaReprocessar);
	}
}
