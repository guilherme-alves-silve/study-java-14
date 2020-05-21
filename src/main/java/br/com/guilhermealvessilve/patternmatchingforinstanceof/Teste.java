package br.com.guilhermealvessilve.patternmatchingforinstanceof;

import java.util.Random;

public class Teste {

	public static void main (String[] args) {

		//Anteriormente
		final Object object = new Random().nextBoolean()? "Um objeto aqui!" : 5;
		if (object instanceof String) {
			final String string = (String) object;
			System.out.println(string.concat(" Isso mesmo"));
		} else if (object instanceof Integer) {
			final Integer integer = (Integer) object;
			System.out.println("É 10: " + integer + 5);
		}

		//Novidade Java 14 Preview
		final Object object2 = new Random().nextBoolean()? "Um objeto aqui!" : 5;
		if (object2 instanceof String string) {
			System.out.println(string.concat(" Isso mesmo"));
		} else if (object2 instanceof Integer integer) {
			System.out.println("É 10: " + integer + 5);
		}
	}
}
