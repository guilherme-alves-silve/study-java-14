package br.com.guilhermealvessilve.factorymethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teste {

	public static void main (String[] args) {
		//Anteriormente
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("primeiroNome");
		nomes.add("segundoNome");
		nomes.add("terceiroNome");
		List<String> nomesImutavel = Collections.unmodifiableList(nomes);
		System.out.println(nomesImutavel);

		//Novidade Java 9
		final List<String> nomesImutavel2 = List.of("primeiroNome", "segundoNome", "terceiroNome");
		System.out.println(nomesImutavel2);
	}
}
