package hu.bme.tesslo.hmdb.factory;

import hu.bme.tesslo.hmdb.dao.MovieDao;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.util.StateContainer;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * HomePage-hez kellõ változók factory függvényeit tartalmazó osztály.
 * 
 * @author Karcsi
 * 
 */
@Name("homePageFactory")
@Scope(ScopeType.STATELESS)
public class HomePageFactory {

	/**
	 * Logoláshoz logger.
	 */
	private static final Logger logger = Logger
			.getLogger(HomePageFactory.class);

	/**
	 * moviesStateContainer. Lekérdezi adatbázisból az elérhetõ filmeket.
	 * 
	 * @return Elérhetõ filmek egy StateContainerben.
	 */
	@Factory(value = "moviesStateContainer", scope = ScopeType.PAGE)
	public StateContainer<Movie> getAllMovies() {
		MovieDao movieDao;
		try {
			movieDao = (MovieDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/MovieDao/local");
		} catch (NamingException e) {
			logger.error("MovieDao nem található!", e);
			return new StateContainer<Movie>(new ArrayList<Movie>());
		}
		List<Movie> movies = movieDao.getAllMovie();
		if (movies.isEmpty()) {
			movieDao.setDummieDate();
			movies = movieDao.getAllMovie();
		}
		return new StateContainer<Movie>(movies);
	}

}
