package br.com.guilhermealvessilve.textblock;

public class Teste {

	public static void main (String[] args) {
		String texto = "\"Lorem ipsum dolor sit amet, \n" + "consectetur adipiscing elit, sed do eiusmod tempor \n"
				+ "incididunt ut labore et dolore magna aliqua. \n"
				+ "Ut enim ad minim veniam, quis nostrud exercitation \n"
				+ "ullamco laboris nisi ut aliquip ex ea commodo \n"
				+ "consequat. Duis aute irure dolor in reprehenderit \n"
				+ "in voluptate velit esse cillum dolore eu fugiat \n"
				+ "nulla pariatur. Excepteur sint occaecat cupidatat \n"
				+ "non proident, sunt in culpa qui officia deserunt \n"
				+ "mollit anim id est laborum.\"\n";
		System.out.println(texto);

		System.out.println();

		//Novidade Java 13
		String texto2 = """
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
				Fusce id congue dolor, a dapibus ipsum. Sed et elit enim. Donec 
				euismod odio eget justo fringilla, at finibus quam congue. 
				Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. 
				Fusce scelerisque vulputate accumsan. Phasellus ut quam id sem condimentum porta eu eu nisi. 
				Aliquam volutpat at leo id iaculis. Quisque accumsan, arcu in vulputate blandit, risus lorem condimentum dolor, 
				non fringilla libero nulla at dolor. Maecenas vestibulum auctor dui, luctus luctus risus malesuada a. 
				Curabitur pretium tellus vel hendrerit venenatis. Mauris quis turpis id lorem ornare egestas. 
				Donec mi mi, condimentum quis maximus a, tempus vel leo. Vestibulum dui lorem, placerat at maximus a, aliquet vitae lacus. 
				Sed lacinia velit eu lobortis semper. Maecenas tincidunt sapien at faucibus sodales. Duis convallis felis ultrices mi ornare vehicula.
				Cras ullamcorper quam eget facilisis vehicula. Nulla accumsan, 
				nisl et rhoncus vulputate, lectus nisl commodo justo, vitae tempor ipsum lectus vitae augue. Vestibulum luctus laoreet mauris, 
				vitae mattis est aliquam quis. Pellentesque eleifend in sapien convallis pellentesque. Sed fermentum semper feugiat. 
				Aliquam vehicula pretium mauris, ut iaculis dui faucibus sed. Morbi vitae nisi orci. Suspendisse at sollicitudin lacus. 
				Duis ullamcorper blandit tempor. Curabitur quam elit, cursus quis molestie id, malesuada quis arcu. 
				Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris est mauris, 
				ornare quis est id, egestas condimentum tellus. Etiam nec nisl a ante interdum ultricies vel vitae nisi. 
				In eleifend rutrum metus sit amet vestibulum. Aliquam non finibus nisl.
				Nam quis risus ut nisi sagittis tincidunt vel quis elit. 
				Pellentesque viverra urna vitae suscipit accumsan. Fusce malesuada ornare purus ut ultricies. 
				Pellentesque ut ultricies nisl, 
				nec lacinia purus. Pellentesque imperdiet imperdiet interdum. Duis efficitur turpis in nunc egestas, a sodales lorem tempus. 
				Sed quis purus lobortis, congue augue quis, tincidunt diam. Fusce eu erat dui. Mauris rhoncus erat non posuere vestibulum. 
				Donec mollis non odio ut interdum. Phasellus molestie magna id porta tempus.
				Aliquam vel blandit magna. Praesent consequat aliquet nisl. 
				Sed porta nulla ligula, tempor varius libero euismod vel. 
				Proin in dapibus massa. Vivamus placerat arcu mauris, et aliquet arcu mollis et. Nam sagittis quis tortor ut finibus. 
				Cras ac orci interdum, viverra nisi eu, venenatis ante. Duis condimentum mattis semper. Vestibulum in lobortis leo. 
				Donec iaculis eu justo non facilisis.
				Sed pellentesque condimentum consequat. Donec ut dictum ante. 
				Duis dignissim risus quam, efficitur gravida sapien molestie id. 
				Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. 
				Vestibulum efficitur, nunc a tempus interdum, ante leo dictum dui, id elementum nisi sem et lectus. 
				Etiam ut mi tempor, cursus turpis sit amet, sagittis urna. 
				Praesent venenatis blandit justo a tempor. Maecenas sit amet facilisis quam, at sodales risus. 
				Maecenas elementum eleifend enim, sit amet ornare nisi fermentum ut.
				""";
		System.out.println(texto2);

		String texto3 = """
    			$titulo
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
				Fusce id congue dolor, a dapibus ipsum. Sed et elit enim. Donec 
				euismod odio eget justo fringilla, at finibus quam congue.
				""".replace("$titulo", "Title");
		System.out.println(texto3);
	}
}
