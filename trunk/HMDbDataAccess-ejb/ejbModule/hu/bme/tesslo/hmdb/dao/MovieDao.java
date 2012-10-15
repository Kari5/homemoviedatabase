/**
 * 
 */
package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.futurion.mt.dao.GenericDao;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Karcsi
 * 
 */
@Local
public interface MovieDao extends GenericDao<Movie> {

	/**
	 * Visszaadja az �sszes elt�rolt filmet.
	 * 
	 * @return filmek list�ja
	 */
	public List<Movie> getAllMovie();

	public void setDummieDate();
}
