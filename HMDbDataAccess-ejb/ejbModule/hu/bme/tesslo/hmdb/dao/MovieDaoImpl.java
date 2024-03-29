/**
 * 
 */
package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Antecendents;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.User;
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

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovie() {
		List<Movie> result = new ArrayList<Movie>();
		String query = "FROM Movie";
		result = (List<Movie>) executeQueryMultipleResult(query);
		logger.info("Filmek sz�ma: " + result.size());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public Movie getMovie(String title, Integer year) {
		if (year != null) {
			String query = "FROM Movie AS M WHERE M.title = ? AND M.year=?";
			return (Movie) executeQuerySingleResult(query, title, year);
		} else {
			String query = "FROM Movie AS M WHERE M.title = ?";
			return (Movie) executeQuerySingleResult(query, title);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean saveOrUpdate(Movie m) {
		Movie existing = getMovie(m.getTitle(), m.getYear());
		if (existing == null) {
			save(m);
			return true;
		} else {
			existing.setTitle(m.getTitle());
			existing.setActors(m.getActors());
			existing.setDirector(m.getDirector());
			existing.setGenre(m.getGenre());
			existing.setImdbID(m.getImdbID());
			existing.setImdbRating(m.getImdbRating());
			existing.setLanguage(m.getLanguage());
			existing.setLocalUrl(m.getLocalUrl());
			existing.setPlot(m.getPlot());
			existing.setPosterUrl(m.getPosterUrl());
			existing.setRuntime(m.getRuntime());
			existing.setSubtitle(m.getSubtitle());
			existing.setWriter(m.getWriter());
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDummieDate() {
		Movie movie = new Movie("A film", 2012, "3 h 23", "Action", "Kari",
				null, null, null, null, 5.0, null, null, null, null);
		Movie movie2 = new Movie("B film", 2002, "3 h 23", "Comedy", "Kari",
				null, null, null, null, 3.4, null, null, null, null);
		Movie movie3 = new Movie(
				"C film",
				2010,
				"3 h 23",
				"Sci-fi",
				"Kari",
				null,
				null,
				null,
				"http://blogs-images.forbes.com/erikkain/files/2011/12/atthemovies.jpg",
				6.9, null, null, null, null);
		save(movie);
		save(movie2);
		save(movie3);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public void removeMovie(Movie m) {
		try {
			Movie attachedMovie = findByPrimaryKey(m.getId());
			logger.info("Megtal�lt film: " + attachedMovie.getTitle());

			List<Antecendents> antecendents = (List<Antecendents>) executeQueryMultipleResult("FROM Antecendents");
			for (Antecendents ant : antecendents) {
				if (ant.getMovies().contains(attachedMovie)) {
					ant.getMovies().remove(attachedMovie);
				}
			}

			List<User> users = (List<User>) executeQueryMultipleResult("FROM User_");
			for (User user : users) {
				if (user.getFavoriteMovies().contains(attachedMovie)) {
					user.getFavoriteMovies().remove(attachedMovie);
				}
			}

			String ratingQuery = "DELETE FROM Rating AS R WHERE R.movie.id=?";
			executeUpdate(ratingQuery, attachedMovie.getId());
			remove(attachedMovie);
		} catch (Exception e) {
			logger.error("Film t�rl�se k�zben hiba! " + e.getMessage());
		}
	}

}
