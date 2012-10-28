package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.User;
import hu.futurion.mt.dao.GenericDaoImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

@Stateless(name = "UserDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@PersistenceContext(unitName = "HMDbDataAccess")
	EntityManager entityManager;

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

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
	public boolean changeFavoriteMovie(String userName, Movie movie) {
		User user = (User) executeQuerySingleResult(
				"FROM User_ AS u WHERE u.userName=?", userName);
		if (user.getFavoriteMovies().contains(movie)) {
			user.getFavoriteMovies().remove(movie);
			logger.info(userName + " - Kedvencei közül eltávolítva: "
					+ movie.getTitle());
			return false;
		} else {
			Movie attachedMovie = (Movie) executeQuerySingleResult(
					"FROM Movie AS m WHERE m.id=?", movie.getId());
			user.getFavoriteMovies().add(attachedMovie);
			logger.info(userName + " - Kedvenceihez adva: " + movie.getTitle());
		}
		return true;

	}

	/**
	 * {@inheritDoc}
	 */
	public List<Movie> favoriteMovies(String userName) {
		User user = (User) executeQuerySingleResult(
				"FROM User_ AS u WHERE u.userName=?", userName);
		return user.getFavoriteMovies();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isFavoriteMovie(String userName, Movie m) {
		User user = (User) executeQuerySingleResult(
				"FROM User_ AS u WHERE u.userName=?", userName);
		return user.getFavoriteMovies().contains(m);
	}

}
