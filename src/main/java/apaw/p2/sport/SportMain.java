package apaw.p2.sport;

import apaw.p2.sport.daos.DaoFactory;
import apaw.p2.sport.daos.memory.DaoFactoryMemory;
import apaw.p2.sport.http.HttpMethod;
import apaw.p2.sport.http.HttpRequest;
import apaw.p2.sport.http.HttpResponse;

public class SportMain {

	private Server server = new Server();

	private HttpRequest request = new HttpRequest();

	public void demo() {
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("uno:uno@gmail.com");
		this.request();
		request.setBody("dos:dos@gmail.com");
        this.request();
		request.setBody("uno:tres@gmail.com");
		this.request();
		
		request.setMethod(HttpMethod.GET);
        request.setPath("users");
        request.clearQueryParams();
        request.setBody("");
        this.request();
		
        request.setMethod(HttpMethod.POST);
		request.setPath("sports");
        request.setBody("tenis");
        this.request();
        request.setBody("tenis");
        this.request();
        request.setBody("ajedrez");
        this.request();
        
        request.setMethod(HttpMethod.GET);
        request.setPath("sports");
        request.clearQueryParams();
        request.setBody("");
        this.request();
	}

	public void request() {
		System.out.println(request.toString());
		HttpResponse response = server.request(request);
		System.out.println(response);
		System.out.println("---------------------------------------ooo----------------------------------------");
	}

	public static void main(String[] args) {
		SportMain main = new SportMain();
		DaoFactory.setFactory(new DaoFactoryMemory());
		main.demo();
	}
}
