package paolicchi.tepsit.restfullwebservices.config;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class Application extends ResourceConfig {
    public Application() {
        packages("paolicchi.tepsit.api");
    }
}