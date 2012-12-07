/**
 * 
 */
package hu.bme.tesslo.hmdb.session;

import hu.bme.tesslo.hmdb.dao.AntecendentsDao;
import hu.bme.tesslo.hmdb.dao.MovieDao;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.util.StateHolder;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.security.Credentials;

/**
 * HomePage-hez tartozó backBean.
 * 
 * @author Karcsi
 * 
 */
@Name("HomePageBean")
@Scope(ScopeType.PAGE)
public class HomePageBackBean {

	/**
	 * Új film felvételéhez egy movie változó.
	 */
	private Movie newMovie;

	/**
	 * A kiválasztott film stateHolder-e.
	 */
	@In(create = true)
	private StateHolder<Movie> selectedMovieStateHolder;

	/**
	 * Felhasználó adatai.
	 */
	@In
	Credentials credentials;

	/**
	 * Logoláshoz logger.
	 */
	private static final Logger logger = Logger
			.getLogger(HomePageBackBean.class);

	/**
	 * Init.
	 */
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
	public String saveNewMovie() {
		MovieDao movieDao;
		try {
			movieDao = (MovieDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/MovieDao/local");
		} catch (NamingException e) {
			logger.error("MovieDao nem található!", e);
			FacesMessages.instance().add("Belsõ hiba!");
			return "#";
		}
		if (newMovie.getTitle().isEmpty() || newMovie.getTitle() == null) {
			logger.info("Nincs beállítva cím");
			FacesMessages.instance().add("Nem adtál meg címet!");
			return "#";
		}
		if (movieDao.saveOrUpdate(newMovie)) {
			FacesMessages.instance().add("Sikeres mentés!");
		} else {
			FacesMessages.instance().add("A film már fel volt véve!");
		}
		return "home";
	}

	/**
	 * Beállítja a kiválasztott filmet. A felhasználó elõzményeit is változtatja
	 * a megfelelõ módon.
	 * 
	 * @param selected
	 *            újonnan kiválasztott film
	 */
	public String changeSelectedMovie(Movie selected) {
		logger.info("Kiválasztott film: " + selected.getTitle());
		this.selectedMovieStateHolder.setSelected(selected);
		AntecendentsDao antecendentsDao;
		try {
			antecendentsDao = (AntecendentsDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/AntecendentsDao/local");
			antecendentsDao.setMovieInAntecendent(credentials.getUsername(),
					selected);
		} catch (NamingException e) {
			logger.error(e.getMessage());
		}
		return "moviePage";
	}
}
