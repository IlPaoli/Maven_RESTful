package paolicchi.tepsit.restfullwebservices.api;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("books/{book_id}/authors")
public class AuthorServices {
    @GET
    public List<Author> list(@PathParam("{book_id}") long bookId){
        List<Author> authors = new ArrayList<Author>();
        Author author = new Author();
        
        author.setId(1);
        author.setName("Joanne");
        author.setSurname("Rowling");
        
        authors.add(author);
        
        return authors;
    }
}
