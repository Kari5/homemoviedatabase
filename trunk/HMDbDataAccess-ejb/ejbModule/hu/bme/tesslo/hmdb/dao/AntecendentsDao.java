package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Antecendents;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.futurion.mt.dao.GenericDao;

import javax.ejb.Local;

/**
 * Elõzmények entitás kezelésért felelõs osztály interfésze.
 * 
 * @author Karcsi
 * 
 */
@Local
public interface AntecendentsDao extends GenericDao<Antecendents> {

	/**
	 * Visszaadja egy felhasználó elõzményeit.
	 * 
	 * @param user
	 *            felhasználó
	 * @return elõzmények
	 */
	public Antecendents getAntecendents(String userName);

	/**
	 * Egy adott felhasználóhoz berak egy elõzményt. Ha még nem volt elõzménye,
	 * akkor létrehozza azt. Ha már szerepelt az elõzmények között a
	 * kiválasztott film, akkor a lista elejére teszi.
	 * 
	 * @param userName
	 *            felhasználónév.
	 * @param movie
	 *            elõzmény film
	 */
	public void setMovieInAntecendent(String userName, Movie movie);
}
