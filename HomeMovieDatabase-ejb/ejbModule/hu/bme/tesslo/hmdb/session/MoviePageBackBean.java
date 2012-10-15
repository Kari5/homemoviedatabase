/**
 * 
 */
package hu.bme.tesslo.hmdb.session;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.util.StateHolder;

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

	@In(create = true)
	private StateHolder<Movie> selectedMovieStateHolder;

	@Create
	public void init() {
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
					6.9, null, null);
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

}
