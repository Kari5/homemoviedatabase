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
 * HomePage-hez tartoz� backBean.
 * 
 * @author Karcsi
 * 
 */
@Name("HomePageBean")
@Scope(ScopeType.PAGE)
public class HomePageBackBean {

	/**
	 * �j film felv�tel�hez egy movie v�ltoz�.
	 */
	private Movie newMovie;

	/**
	 * A kiv�lasztott film stateHolder-e.
	 */
	@In(create = true)
	private StateHolder<Movie> selectedMovieStateHolder;

	/**
	 * Felhaszn�l� adatai.
	 */
	@In
	Credentials credentials;

	/**
	 * Logol�shoz logger.
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
	 * Elmenti az �j filmet.
	 */
	public String saveNewMovie() {
		MovieDao movieDao;
		try {
			movieDao = (MovieDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/MovieDao/local");
		} catch (NamingException e) {
			logger.error("MovieDao nem tal�lhat�!", e);
			FacesMessages.instance().add("Bels� hiba!");
			return "#";
		}
		if (newMovie.getTitle().isEmpty() || newMovie.getTitle() == null) {
			logger.info("Nincs be�ll�tva c�m");
			FacesMessages.instance().add("Nem adt�l meg c�met!");
			return "#";
		}
		if (movieDao.saveOrUpdate(newMovie)) {
			FacesMessages.instance().add("Sikeres ment�s!");
		} else {
			FacesMessages.instance().add("A film m�r fel volt v�ve!");
		}
		return "home";
	}

	/**
	 * Be�ll�tja a kiv�lasztott filmet. A felhaszn�l� el�zm�nyeit is v�ltoztatja
	 * a megfelel� m�don.
	 * 
	 * @param selected
	 *            �jonnan kiv�lasztott film
	 */
	public String changeSelectedMovie(Movie selected) {
		logger.info("Kiv�lasztott film: " + selected.getTitle());
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
