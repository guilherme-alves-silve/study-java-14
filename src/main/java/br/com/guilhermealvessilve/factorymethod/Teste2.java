package br.com.guilhermealvessilve.factorymethod;

import java.util.Arrays;
import java.util.List;

public class Teste2 {

	public static void main (final String[] args) {

		//Anteriormente
		final List<String> arraysAsList = Arrays.asList("nome1", "nome2", "nome3");
		tryExecution(() -> arraysAsList.add("nome4"), "Arrays.asList() can't add new objects");
		System.out.println("But can modify");
		arraysAsList.set(1, "nome4");
		System.out.println("arraysAsList: " + arraysAsList + "\n");

		//Novidade Java 9
		final List<String> listOf = List.of("nome1", "nome2", "nome3");
		tryExecution(() -> listOf.add("nome4"), "List.of() can't add new objects");
		tryExecution(() -> listOf.set(1, "nome4"), "List.of() can't modify too");
		System.out.println("listOf: " + listOf);
	}

	private static void tryExecution(final Runnable runnable, final String explanation) {
		try {
			runnable.run();
		} catch (final UnsupportedOperationException ex) {
			System.out.println(explanation);
		}
	}
}
