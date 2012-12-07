/**
 * 
 */
package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.futurion.mt.dao.GenericDao;

import java.util.List;

import javax.ejb.Local;

/**
 * Movie adatb�zis t�bla hozz�f�r�s interf�sze.
 * 
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
	 * @return True, ha �j elemet vett fel, false, ha r�git �rt fel�l.
	 */
	public boolean saveOrUpdate(Movie m);

	/**
	 * Elt�vol�t egy filmet minden adatb�zisb�l.
	 * 
	 */
	public void removeMovie(Movie m);

	/**
	 * Tesztel�shez. Be�ll�t n�h�ny teszt adatot, �s elmenti az adatb�zisba.
	 */
	public void setDummieDate();
}
