/**
 * 
 */
package hu.bme.tesslo.hmdb.session;

import hu.bme.tesslo.hmdb.dao.MovieDao;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.util.ImdbReader;
import hu.bme.tesslo.hmdb.util.StateHolder;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * @author Karcsi
 * 
 */
@Name("HomePageBean")
@Scope(ScopeType.EVENT)
public class HomePageBackBean {

	private Movie newMovie;

	@In(create = true)
	private StateHolder<Movie> selectedMovieStateHolder;

	private static final Logger logger = Logger
			.getLogger(HomePageBackBean.class);

	@Create
	public void init() {
		newMovie = new Movie();
	}

	/**
	 * @return the newMovie
	 */
	public Movie getNewMovie() {
		return newMovie;
	}

	/**
	 * @param newMovie
	 *            the newMovie to set
	 */
	public void setNewMovie(Movie newMovie) {
		this.newMovie = newMovie;
	}

	/**
	 * Elmenti az új filmet.
	 */
	public void saveNewMovie() {
		MovieDao movieDao;
		try {
			movieDao = (MovieDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/MovieDao/local");
		} catch (NamingException e) {
			logger.error("MovieDao nem található!", e);
			return;
		}
		if (newMovie.getTitle().isEmpty() || newMovie.getTitle() == null) {
			logger.info("Nincs beállítva cím");
			return;
		}
		movieDao.save(newMovie);
	}

	/**
	 * Beállítja a kiválasztott filmet.
	 * 
	 * @param selected
	 *            újonnan kiválasztott film
	 */
	public String changeSelectedMovie(Movie selected) {
		logger.info("Kiválasztott film: " + selected.getTitle());
		this.selectedMovieStateHolder.setSelected(selected);
		return "moviePage";
	}
}
