package si.um.feri.jee.sample.dao;

import jakarta.ejb.Local;
import si.um.feri.jee.sample.vao.Movie;

import java.util.List;

@Local
public interface MovieDaoLocal {

    List<Movie> findAll();

    void create(Movie movie);

    Movie findById(Long id);

    Movie update(Movie movie);

    void delete(Movie movie);

    List<Movie> findWithoutDirector();
}