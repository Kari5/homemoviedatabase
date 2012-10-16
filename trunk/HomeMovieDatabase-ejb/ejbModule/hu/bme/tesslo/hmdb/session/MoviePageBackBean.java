/**
 * 
 */
package hu.bme.tesslo.hmdb.session;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import hu.bme.tesslo.hmdb.dao.MovieDao;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.util.ImdbReader;
import hu.bme.tesslo.hmdb.util.StateContainer;
import hu.bme.tesslo.hmdb.util.StateHolder;

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
@Name("MoviePageBean")
@Scope(ScopeType.EVENT)
public class MoviePageBackBean {

	/**
	 * Kiválasztott film stateHoldere, conversation scope-ban van.
	 * 
	 */
	@In(create = true)
	private StateHolder<Movie> selectedMovieStateHolder;

	/** Logger. */
	private static final Logger logger = Logger
			.getLogger(MoviePageBackBean.class);

	@Create
	public void init() {
		// FIXME:[Kari] Teszthez kell, ki lesz javítva
		if (selectedMovieStateHolder.getSelected() == null) {
			Movie movie3 = new Movie(
					"C film",
					2010,
					"3 h 23",
					"Sci-fi",
					"Rendezõ:",
					"Író:",
					"Színészek:",
					"Összefoglaló:",
					"http://blogs-images.forbes.com/erikkain/files/2011/12/atthemovies.jpg",
					6.9, null, null, null, null);
			selectedMovieStateHolder.setSelected(movie3);
		}
	}

	/**
	 * @return the selectedMovieStateHolder
	 */
	public StateHolder<Movie> getSelectedMovieStateHolder() {
		return selectedMovieStateHolder;
	}

	/**
	 * @param selectedMovieStateHolder
	 *            the selectedMovieStateHolder to set
	 */
	public void setSelectedMovieStateHolder(
			StateHolder<Movie> selectedMovieStateHolder) {
		this.selectedMovieStateHolder = selectedMovieStateHolder;
	}

	public void changeSelectedMovieData() {
		System.out.println("Kiválasztott film: "
				+ this.selectedMovieStateHolder.getSelected().getTitle());
		ImdbReader reader = new ImdbReader(this.selectedMovieStateHolder
				.getSelected().getTitle(), this.selectedMovieStateHolder
				.getSelected().getYear(), this.selectedMovieStateHolder
				.getSelected().getImdbID());
		Movie searchResult = reader.parseJson();
		if (searchResult == null) {
			return;
		}
		String localUrl = this.selectedMovieStateHolder.getSelected()
				.getLocalUrl();
		String language = this.selectedMovieStateHolder.getSelected()
				.getLanguage();
		Boolean subtitle = this.selectedMovieStateHolder.getSelected()
				.getSubtitle();
		this.selectedMovieStateHolder.setSelected(searchResult);
		this.selectedMovieStateHolder.getSelected().setLocalUrl(localUrl);
		this.selectedMovieStateHolder.getSelected().setLanguage(language);
		this.selectedMovieStateHolder.getSelected().setSubtitle(subtitle);
	}

	public String saveChanges() {
		MovieDao movieDao;
		try {
			movieDao = (MovieDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/MovieDao/local");
		} catch (NamingException e) {
			logger.error("MovieDao nem található!", e);
			return "#";
		}
		movieDao.saveOrUpdate(this.selectedMovieStateHolder.getSelected());
		return "moviePage";
	}

}
