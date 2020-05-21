package br.com.guilhermealvessilve.inferenciavariavel;

import java.util.HashMap;

public class Teste {

	public static void main (String[] args) {
		//Antes
		HashMap<String, String> cpfPorNomes = new HashMap<>();
		cpfPorNomes.put("João", "04813189");
		System.out.println(cpfPorNomes);

		//Novidade Java 11
		var cpfPorNomes2 = new HashMap<String, String>();
		cpfPorNomes2.put("João", "04813189");

		System.out.println(cpfPorNomes2);
	}
}
