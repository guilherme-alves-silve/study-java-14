module br.com.guilhermealvessilve.http {
	requires java.net.http;
	requires transitive br.com.guilhermealvessilve.modelo;
	exports br.com.guilhermealvessilve.jpms.http.dao;
}
