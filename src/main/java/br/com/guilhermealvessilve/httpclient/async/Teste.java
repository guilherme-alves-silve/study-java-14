package br.com.guilhermealvessilve.httpclient.async;

import br.com.guilhermealvessilve.httpclient.async.dao.CriaturaDAO;
import br.com.guilhermealvessilve.httpclient.async.dao.GalaxiaDAO;
import br.com.guilhermealvessilve.httpclient.async.dao.PlanetaDAO;
import java.net.URISyntaxException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Teste {

	public static void main (final String[] args) throws InterruptedException, URISyntaxException {
		final var thread = new Thread(() -> {
			try {
				System.out.println("Executing in new thread: ");
				new PlanetaDAO().listar();
			} catch (final Exception ex) {
				ex.printStackTrace();
			}
		});
		thread.start();

		new PlanetaDAO().listarAsync();
		new GalaxiaDAO().listar();
		new CriaturaDAO().listar();

		thread.join();

		/*
		 * O CompletableFuture usa o ForkJoinPool para realizar seus processos assincronos por padrão,
		 * coloquei para que a thread main espere o método listarAsync finalizar antes de sair.
		 */
		final var forkJoinPool = ForkJoinPool.commonPool();
		forkJoinPool.shutdownNow();
		forkJoinPool.awaitTermination(1, TimeUnit.MINUTES);
	}
}
