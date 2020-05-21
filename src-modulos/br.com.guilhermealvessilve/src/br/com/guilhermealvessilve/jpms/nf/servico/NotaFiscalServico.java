package br.com.guilhermealvessilve.jpms.nf.servico;

import br.com.guilhermealvessilve.jpms.modelo.dominio.NotaFiscal;

public class NotaFiscalServico {

	public static void emitir(final NotaFiscal nf) {
		try {
			System.out.println("emitindo");
			Thread.sleep(5000);
			System.out.println(nf);
		} catch (final Exception ex) {
			System.out.println("Falha ao emitir a Nota Fiscal");
		}
	}
}
