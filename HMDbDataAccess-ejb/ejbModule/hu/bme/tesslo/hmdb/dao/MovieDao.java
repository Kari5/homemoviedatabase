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

	/**
	 * C�m �s �v alapj�n visszad egy filmet.
	 * 
	 * @param title
	 *            c�m
	 * @param year
	 *            kiad�s �ve
	 * @return a keresett film, vagy null, ha nem tal�lhat�
	 */
	public Movie getMovie(String title, Integer year);

	/**
	 * Elment, vagy fel�l�r egy l�tez� filem bejegyz�st.
	 * 
	 * @param m
	 *            elmentend�, vagy fel�l�rand� film
	 */
	public void saveOrUpdate(Movie m);

	public void setDummieDate();
}
