package si.um.feri.jee.sample.ejb;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import si.um.feri.jee.sample.dao.MovieDaoLocal;
import si.um.feri.jee.sample.vao.Movie;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class MovieRemoteBean implements MovieRemote {

    @Inject
    private MovieDaoLocal dao;

    @Override
    public int countMovies() {
        return dao.findAll().size();
    }

    @Override
    public List<Movie> findAll() {
        return dao.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void create(Movie movie) {
        dao.create(movie);
    }

    @Override
    public void update(Movie movie) {
        dao.update(movie);
    }

    @Override
    public void delete(Movie movie) {
        dao.delete(movie);
    }

    @Override
    public List<String> getMovieTitles() {
        List<String> titles = new ArrayList<>();
        for (Movie m : dao.findAll()) {
            titles.add(m.getTitle());
        }
        return titles;
    }

    @Override
    public List<Movie> findWithoutDirector() {
        return dao.findWithoutDirector();
    }

    @Override
    public List<String> getMoviesWithoutDirector() {
        List<String> result = new ArrayList<>();
        for (Movie m : dao.findWithoutDirector()) {
            result.add(m.getTitle());
        }
        return result;
    }
}