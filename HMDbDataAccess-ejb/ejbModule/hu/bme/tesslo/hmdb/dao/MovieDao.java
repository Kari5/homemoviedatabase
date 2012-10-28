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
	 * Visszaadja az összes eltárolt filmet.
	 * 
	 * @return filmek listája
	 */
	public List<Movie> getAllMovie();

	/**
	 * Cím és év alapján visszad egy filmet.
	 * 
	 * @param title
	 *            cím
	 * @param year
	 *            kiadás éve
	 * @return a keresett film, vagy null, ha nem található
	 */
	public Movie getMovie(String title, Integer year);

	/**
	 * Elment, vagy felülír egy létezõ filem bejegyzést.
	 * 
	 * @param m
	 *            elmentendõ, vagy felülírandó film
	 * @return True, ha új elemet vett fel, false, ha régit írt felül.
	 */
	public boolean saveOrUpdate(Movie m);

	/**
	 * Eltávolít egy filmet minden aadatbázisból.
	 * 
	 */
	public void removeMovie(Movie m);

	public void setDummieDate();
}
