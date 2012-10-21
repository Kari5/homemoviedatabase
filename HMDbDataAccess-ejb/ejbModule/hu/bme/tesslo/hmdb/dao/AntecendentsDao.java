package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Antecendents;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.futurion.mt.dao.GenericDao;

import javax.ejb.Local;

/**
 * El�zm�nyek entit�s kezel�s�rt felel�s oszt�ly interf�sze.
 * 
 * @author Karcsi
 * 
 */
@Local
public interface AntecendentsDao extends GenericDao<Antecendents> {

	/**
	 * Visszaadja egy felhaszn�l� el�zm�nyeit.
	 * 
	 * @param user
	 *            felhaszn�l�
	 * @return el�zm�nyek
	 */
	public Antecendents getAntecendents(String userName);

	/**
	 * Egy adott felhaszn�l�hoz berak egy el�zm�nyt. Ha m�g nem volt el�zm�nye,
	 * akkor l�trehozza azt. Ha m�r szerepelt az el�zm�nyek k�z�tt a
	 * kiv�lasztott film, akkor a lista elej�re teszi.
	 * 
	 * @param userName
	 *            felhaszn�l�n�v.
	 * @param movie
	 *            el�zm�ny film
	 */
	public void setMovieInAntecendent(String userName, Movie movie);
}
