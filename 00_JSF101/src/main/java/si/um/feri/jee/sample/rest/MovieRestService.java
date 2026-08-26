package si.um.feri.jee.sample.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import si.um.feri.jee.sample.ejb.MovieRemote;
import si.um.feri.jee.sample.vao.Movie;

import java.util.List;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieRestService {

    @EJB
    private MovieRemote movieRemote;

    @GET
    public List<Movie> getAllMovies() {
        return movieRemote.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getMovieById(@PathParam("id") Long id) {

        Movie movie = movieRemote.findById(id);

        if (movie == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Movie not found")
                    .build();
        }

        return Response.ok(movie).build();
    }

    // GET MOVIES WITHOUT DIRECTOR
    @GET
    @Path("/no-director")
    public List<Movie> getMoviesWithoutDirector() {
        return movieRemote.findWithoutDirector();
    }

    // CREATE MOVIE (DIRECTOR OPTIONAL)
    @POST
    public Response createMovie(Movie movie) {

        if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Title is required")
                    .build();
        }

        movieRemote.create(movie);

        return Response.status(Response.Status.CREATED)
                .entity(movie)
                .build();
    }

    // UPDATE MOVIE
    @PUT
    @Path("/{id}")
    public Response updateMovie(@PathParam("id") Long id, Movie movie) {

        Movie existing = movieRemote.findById(id);

        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Movie not found")
                    .build();
        }

        movie.setId(id);
        movieRemote.update(movie);

        return Response.ok(movie).build();
    }
}