package si.um.feri.jee.sample.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ejb.EJB;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

import si.um.feri.jee.sample.ejb.MovieRemote;
import si.um.feri.jee.sample.jms.MovieProducer;
import si.um.feri.jee.sample.vao.Movie;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("movies")
@SessionScoped
public class MovieJsfBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Inject
    private MovieProducer movieProducer;

    @EJB
    private MovieRemote movieRemote;

    private Movie movieOnUi = new Movie(null, "", "", 2000, "", "");

    private boolean editMode = false;

    // ASYNC CREATE (JMS)
    public String addMovieFromUi() {

        movieProducer.sendMovie(movieOnUi);

        log.info(" Movie request sent to queue");

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Request received",
                        "Movie is being processed asynchronously..."));

        movieOnUi = new Movie(null, "", "", 2000, "", "");

        return null;
    }

    // LIST METHODS
    public List<Movie> getAllMovies() {
        return movieRemote.findAll();
    }

    public List<Movie> getMoviesWithoutDirector() {
        return movieRemote.findWithoutDirector();
    }

    // ✏EDIT
    public String editMovie(Movie movie) {
        this.movieOnUi = movie;
        this.editMode = true;
        return "createMovie";
    }

    public String cancelEdit() {
        this.movieOnUi = new Movie(null, "", "", 2000, "", "");
        this.editMode = false;
        return "createMovie";
    }

    public void deleteMovie(Movie movie) {
        movieRemote.delete(movie);
    }

    // DETAILS
    public String viewDetails(Movie movie) {
        return "movieDetails?faces-redirect=true&amp;id=" + movie.getId();
    }

    // GETTERS / SETTERS
    public Movie getMovieOnUi() {
        return movieOnUi;
    }

    public void setMovieOnUi(Movie movieOnUi) {
        this.movieOnUi = movieOnUi;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }
}