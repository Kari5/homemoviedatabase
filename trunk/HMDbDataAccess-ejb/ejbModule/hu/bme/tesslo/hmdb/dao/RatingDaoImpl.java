package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.Rating;
import hu.bme.tesslo.hmdb.model.User;
import hu.futurion.mt.dao.GenericDaoImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

@Stateless(name = "ratingDao")
public class RatingDaoImpl extends GenericDaoImpl<Rating> implements RatingDao {

	@PersistenceContext(unitName = "HMDbDataAccess")
	EntityManager entityManager;

	private static final Logger logger = Logger.getLogger(MovieDaoImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Rating> userRatings(String userName) {
		String query = "FROM Rating AS R WHERE R.user.userName=?";
		List<Rating> result = (List<Rating>) executeQueryMultipleResult(query,
				userName);
		logger.info(userName + " - Visszaadott értékelések száma: "
				+ result.size());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public Rating userRatingMovie(String userName, Movie movie) {
		String query = "FROM Rating AS R WHERE R.user.userName=? AND R.movie.id = ?";
		Rating result = (Rating) executeQuerySingleResult(query, userName,
				movie.getId());
		logger.info(userName + " - Visszaadott értékelés ok: "
				+ (result != null));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean ratingExist(String userName, Movie movie) {
		String query = "SELECT COUNT(*) FROM Rating AS R WHERE R.user.userName=? AND R.movie.id = ?";
		Long result = (Long) executeQuerySingleResult(query, userName,
				movie.getId());
		logger.info(userName + " - Visszaadott értékelés létezik: "
				+ (result > 0));
		return result > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Rating> movieRatings(Movie movie) {
		String query = "FROM Rating AS R WHERE R.movie.id=?";
		List<Rating> result = (List<Rating>) executeQueryMultipleResult(query,
				movie.getId());
		logger.info(movie.getTitle() + " - Visszaadott értékelések száma: "
				+ result.size());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveRating(String userName, Rating rating) {
		Movie attachedMovie = (Movie) executeQuerySingleResult(
				"FROM Movie AS m WHERE m.id=?", rating.getMovie().getId());
		User user = (User) executeQuerySingleResult(
				"FROM User_ AS u WHERE u.userName=?", userName);
		rating.setUser(user);
		rating.setMovie(attachedMovie);
		save(rating);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteRating(Rating rating) {
		try {
			Rating attachedRating = findByPrimaryKey(rating.getId());
			remove(attachedRating);
			logger.info("Sikeres törlés!");
		} catch (Exception e) {
			logger.error("Törlés nem sikerült: " + e.getMessage(), e);
		}

	}

}
