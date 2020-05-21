package br.com.guilhermealvessilve.jpms.nf.util;

import br.com.guilhermealvessilve.jpms.modelo.dominio.NotaFiscal;
import br.com.guilhermealvessilve.jpms.nf.subscriber.NotaFiscalSubscriber;
import java.util.concurrent.SubmissionPublisher;

public class NotaFiscalUtil {

	private final SubmissionPublisher<NotaFiscal> publisher;

	public NotaFiscalUtil() {
		this.publisher = new SubmissionPublisher<>();
		this.publisher.subscribe(new NotaFiscalSubscriber());
	}

	public void emitir(final NotaFiscal nf) {
		this.publisher.submit(nf);
	}

	public void fechar() {
		this.publisher.close();
	}
}
