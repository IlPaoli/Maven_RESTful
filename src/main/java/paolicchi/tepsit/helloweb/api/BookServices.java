package paolicchi.tepsit.helloweb.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("books")
public class BookServices {
    @GET
    public List<Book> list() {
        List<Book> books = new ArrayList<Book>();
        List<Author> authors = new ArrayList<Author>();
        
        Author author = new Author();
		author.setId(1);
		author.setName("Joanne");
		author.setSurname("Rowling");
        
        Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("Harry Potter and the Philosopher's Stone");
		book1.setLanguage("english");
        authors.add(author);
		book1.setAuthors(authors);
		books.add(book1);
        Book book2 = new Book();
		book2.setId(2);
		book2.setTitle("Harry Potter and the Chamber of Secrets");
		book2.setLanguage("english");
		book2.setAuthors(authors);
		books.add(book2);
        
        return books;
    }
    @GET
    @Path("{id}")
    public Book get(@PathParam("{id}") long id){
        List<Author> authors = new ArrayList<Author>();
        Author author = new Author();
        Book book = new Book();

        author.setId(1);
        author.setName("Joanne");
        author.setSurname("Rowling");
        
        book.setId(1);
        book.setTitle("Harry Potter and the Philosopher's Stone");
        book.setLanguage("english");
        authors.add(author);
		book.setAuthors(authors);
        
        return book;
    }
    @POST
    public Response add(Book book) throws URISyntaxException{
        long newId = 3;
        return Response.created(new URI("api/books/" + newId)).build();
    }
    @PUT
    @Path("{id}")
    public Response update(@PathParam("{id}") long id, Book book){
        return Response.noContent().build();
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("{id}") long id){
        return Response.noContent().build();
    }
}
