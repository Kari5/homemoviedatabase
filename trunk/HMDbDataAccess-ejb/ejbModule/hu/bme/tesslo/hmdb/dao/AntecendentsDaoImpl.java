package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Antecendents;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.User;
import hu.futurion.mt.dao.GenericDaoImpl;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

@Stateless(name = "AntecendentsDao")
public class AntecendentsDaoImpl extends GenericDaoImpl<Antecendents> implements
		AntecendentsDao {

	@PersistenceContext(unitName = "HMDbDataAccess")
	EntityManager entityManager;

	private static final Logger logger = Logger
			.getLogger(AntecendentsDaoImpl.class);

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	public Antecendents getAntecendents(String userName) {
		StringBuilder query = new StringBuilder();
		query.append("FROM Antecendents as A ");
		query.append("		WHERE");
		query.append("			A.user.userName=?");
		Antecendents result = (Antecendents) executeQuerySingleResult(
				query.toString(), userName);
		logger.info(userName + " - Volt elõzmény: " + (result != null));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setMovieInAntecendent(String userName, Movie movie) {
		Antecendents antecendents = getAntecendents(userName);
		Movie attachedMovie = (Movie) executeQuerySingleResult(
				"FROM Movie AS m WHERE m.id=?", movie.getId());
		if (antecendents == null) {
			User user = (User) executeQuerySingleResult(
					"FROM User_ AS u WHERE u.userName=?", userName);
			antecendents = new Antecendents(user, new ArrayList<Movie>());
			save(antecendents);
		}
		if (antecendents.getMovies().contains(attachedMovie)) {
			antecendents.getMovies().remove(attachedMovie);
		}
		antecendents.getMovies().add(0, attachedMovie);
		logger.info(userName + " elõzményéhez hozzáadva: " + movie.getTitle());
	}

}
