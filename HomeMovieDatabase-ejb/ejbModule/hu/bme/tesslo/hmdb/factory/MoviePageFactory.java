/**
 * 
 */
package hu.bme.tesslo.hmdb.factory;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.util.StateHolder;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * A MoviePage-hez kell� v�ltoz�k factory met�dusait tartalmaz� oszt�ly.
 * 
 * @author Karcsi
 * 
 */
@Name("moviePageFactory")
@Scope(ScopeType.STATELESS)
public class MoviePageFactory {

	/**
	 * A kiv�lasztott filmet t�rol� StateHoldert hozza l�tre.
	 * 
	 * @return
	 */
	@Factory(value = "selectedMovieStateHolder", scope = ScopeType.CONVERSATION)
	public StateHolder<Movie> getSelectedMovie() {
		return new StateHolder<Movie>();
	}
}
