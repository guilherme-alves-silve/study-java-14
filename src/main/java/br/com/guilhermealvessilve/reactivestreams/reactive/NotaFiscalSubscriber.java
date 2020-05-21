package br.com.guilhermealvessilve.reactivestreams.reactive;

import static java.util.concurrent.Flow.Subscription;

import br.com.guilhermealvessilve.reactivestreams.model.NotaFiscal;
import br.com.guilhermealvessilve.reactivestreams.wsclient.NotaFiscalWSClient;
import java.util.Objects;
import java.util.concurrent.Flow.Subscriber;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal> {

	private final int numberMaxRequests;

	private final NotaFiscalWSClient nfwsc;

	private Subscription subscription;

	public NotaFiscalSubscriber (final int numberMaxRequests, final NotaFiscalWSClient nfwsc) {
		this.numberMaxRequests = numberMaxRequests;
		this.nfwsc = Objects.requireNonNull(nfwsc);
	}

	@Override
	public void onSubscribe (final Subscription subscription) {
		this.subscription = subscription;
		//Informo para o publisher que estou pronto para trabalhar com o processamento
		this.subscription.request(numberMaxRequests);
	}

	@Override
	public void onNext (final NotaFiscal item) {
		nfwsc.enviar(item);
		//Pronto para processar o próximo
		subscription.request(numberMaxRequests);
	}

	@Override
	public void onError (final Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete () {
		System.out.println("Todas as notas fiscais foram enviadas!");
	}
}
