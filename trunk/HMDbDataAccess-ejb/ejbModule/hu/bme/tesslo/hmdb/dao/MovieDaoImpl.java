/**
 * 
 */
package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.futurion.mt.dao.GenericDaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

/**
 * @author Karcsi
 * 
 */
@Stateless(name = "MovieDao")
public class MovieDaoImpl extends GenericDaoImpl<Movie> implements MovieDao {

	@PersistenceContext(unitName = "HMDbDataAccess")
	EntityManager entityManager;

	private static final Logger logger = Logger.getLogger(MovieDaoImpl.class);

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovie() {
		List<Movie> result = new ArrayList<Movie>();
		String query = "FROM Movie";
		result = (List<Movie>) executeQueryMultipleResult(query);
		logger.info("Filmek száma: " + result.size());
		return result;
	}

	public void setDummieDate() {
		Movie movie = new Movie("A film", 2012, "3 h 23", "Action", "Kari",
				null, null, null, null, 5.0, null, null);
		Movie movie2 = new Movie("B film", 2002, "3 h 23", "Comedy", "Kari",
				null, null, null, null, 3.4, null, null);
		Movie movie3 = new Movie(
				"C film",
				2010,
				"3 h 23",
				"Sci-fi",
				"Kari",
				null,
				null,
				null,
				"http://http://blogs-images.forbes.com/erikkain/files/2011/12/atthemovies.jpg",
				6.9, null, null);
		save(movie);
		save(movie2);
		save(movie3);
	}

}
