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
 * @author Karcsi
 * 
 */
@Name("moviePageFactory")
@Scope(ScopeType.STATELESS)
public class MoviePageFactory {

	@Factory(value = "selectedMovieStateHolder", scope = ScopeType.CONVERSATION)
	public StateHolder<Movie> getSelectedMovie() {
		return new StateHolder<Movie>();
	}
}
