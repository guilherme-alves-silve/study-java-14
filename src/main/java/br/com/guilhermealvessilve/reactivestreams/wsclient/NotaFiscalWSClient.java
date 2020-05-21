package br.com.guilhermealvessilve.reactivestreams.wsclient;

import br.com.guilhermealvessilve.reactivestreams.model.NotaFiscal;

public class NotaFiscalWSClient {

	public void enviar (final NotaFiscal nf) {
		try {
			final String threadName = Thread.currentThread().getName();
			System.out.format("Emitindo nota fiscal pela thread %s%n", threadName);
			Thread.sleep(2000);
			System.out.format("Nota fiscal emitida %nEm nome de %s com valor de R$ %.2f %nNa data de %s pela thread %s%n",
					nf.getNome(), nf.getValor(), nf.getData(), threadName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
