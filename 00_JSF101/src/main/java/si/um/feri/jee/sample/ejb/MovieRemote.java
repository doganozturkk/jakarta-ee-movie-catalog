package si.um.feri.jee.sample.ejb;

import jakarta.ejb.Remote;
import si.um.feri.jee.sample.vao.Movie;

import java.util.List;

@Remote
public interface MovieRemote {

    int countMovies();

    List<Movie> findAll();

    Movie findById(Long id);

    void create(Movie movie);

    void update(Movie movie);

    void delete(Movie movie);

    List<String> getMovieTitles();

    List<Movie> findWithoutDirector();

    List<String> getMoviesWithoutDirector();
}