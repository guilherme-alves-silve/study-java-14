package br.com.guilhermealvessilve.switchexpression;

import java.time.Month;
import java.util.Random;

public class Teste {

	public static void main (String[] args) {

		//Anteriormente
		final String nome = "João";
		switch (nome) {
		case "Renata": {
			System.out.println("Acertou: " + nome);
			break;
		}
		case "João": {
			System.out.println("Acertou: " + nome);
			break;
		}
		default: {
			System.out.println("Nenhum nome encontrado!!");
		}
		}

		//Novidade Java 14
		final String nome2 = "Pedro";
		switch (nome2) {
		case "Renata" -> System.out.println("Acertou: " + nome2);
		case "Pedro" -> System.out.println("Acertou: " + nome2);
		default -> System.out.println("Nenhum nome encontrado!!");
		}

		final var month = Month.values()[new Random().nextInt(Month.values().length)];
		final int number = switch (month) {
		case JANUARY, FEBRUARY, MAY -> 1;
		case APRIL, MARCH, JUNE -> 2;
		case JULY, AUGUST, SEPTEMBER -> 3;
		case OCTOBER, NOVEMBER, DECEMBER -> 4;
		default -> {
			final var value = new Random().nextInt();
			yield value;
		}
		};

		System.out.println(number);
	}
}
