package si.um.feri.jee.sample.dao;

import jakarta.ejb.Stateless;
import si.um.feri.jee.sample.vao.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Stateless
public class MovieDao implements MovieDaoLocal {

    private static final List<Movie> movies = new ArrayList<>();
    private static final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movies); // dışarıya kopya ver (güvenli)
    }

    @Override
    public void create(Movie movie) {
        movie.setId(idCounter.getAndIncrement()); // 🔥 ID AUTO VER
        movies.add(movie);
    }

    @Override
    public Movie findById(Long id) {
        return movies.stream()
                .filter(m -> m.getId() != null && m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie update(Movie movie) {
        Movie existing = findById(movie.getId());

        if (existing != null) {
            existing.setTitle(movie.getTitle());
            existing.setGenre(movie.getGenre());
            existing.setReleaseYear(movie.getReleaseYear());
            existing.setDescription(movie.getDescription());
            existing.setDirector(movie.getDirector());
            return existing;
        }

        return null;
    }

    @Override
    public void delete(Movie movie) {
        movies.removeIf(m -> m.getId() != null && m.getId().equals(movie.getId()));
    }

    @Override
    public List<Movie> findWithoutDirector() {
        return movies.stream()
                .filter(m -> m.getDirector() == null || m.getDirector().trim().isEmpty())
                .toList();
    }
}