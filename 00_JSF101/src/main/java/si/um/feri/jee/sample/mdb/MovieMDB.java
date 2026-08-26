package si.um.feri.jee.sample.mdb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.ejb.EJB;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;

import si.um.feri.jee.sample.dao.MovieDaoLocal;
import si.um.feri.jee.sample.vao.Movie;

import java.util.logging.Logger;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName = "destinationLookup",
                        propertyValue = "java:/jms/queue/MovieQueue"
                ),
                @ActivationConfigProperty(
                        propertyName = "destinationType",
                        propertyValue = "jakarta.jms.Queue"
                )
        }
)
public class MovieMDB implements MessageListener {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @EJB
    private MovieDaoLocal movieDao;

    @Override
    public void onMessage(Message message) {

        try {
            log.info(" Message received from queue");

            Thread.sleep(3000);

            if (message instanceof ObjectMessage) {

                Movie movie = (Movie) ((ObjectMessage) message).getObject();

                log.info("🎬 Processing movie: " + movie.getTitle());

                // Validation
                if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
                    log.warning("❌ Invalid movie: title is empty");
                    return;
                }

                if (movie.getReleaseYear() < 1900) {
                    log.warning("❌ Invalid movie: year too old");
                    return;
                }

                // Business logic
                movieDao.create(movie);

                log.info("✅ Movie successfully saved: " + movie.getTitle());
            }

        } catch (Exception e) {
            log.severe("❌ Error processing message: " + e.getMessage());
        }
    }
}