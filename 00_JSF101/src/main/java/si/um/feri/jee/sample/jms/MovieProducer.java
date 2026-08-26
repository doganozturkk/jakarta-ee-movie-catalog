package si.um.feri.jee.sample.jms;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.*;

import si.um.feri.jee.sample.vao.Movie;

import java.util.logging.Logger;

@ApplicationScoped
public class MovieProducer {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Resource(lookup = "java:/jms/queue/MovieQueue")
    private Queue queue;

    @Inject
    private JMSContext context;

    public void sendMovie(Movie movie) {
        context.createProducer().send(queue, movie);
        log.info(" Movie sent to JMS queue: " + movie.getTitle());
    }
}