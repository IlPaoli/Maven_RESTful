package paolicchi.tepsit.restfulwebservicesclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import junit.framework.TestCase;

public class BookTest extends TestCase {
	public void testGet() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/api").path("books").path("1");
		Response response = target.request().get();
		System.out.println("Response code: " + response.getStatus());
		Book book = response.readEntity(Book.class);
		System.out.println("Title: " + book.getTitle());
	}
	public void testAdd() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/api").path("books");
		Book book = new Book();
		book.setTitle("Test");
		book.setLanguage("english");
		Response response = target.request().post(Entity.entity(book, MediaType.APPLICATION_JSON));
		System.out.println("Response code: " + response.getStatus());
	}
}