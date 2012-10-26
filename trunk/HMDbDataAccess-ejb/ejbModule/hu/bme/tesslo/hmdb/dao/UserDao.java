package hu.bme.tesslo.hmdb.dao;

import java.util.List;

import javax.ejb.Local;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.User;
import hu.futurion.mt.dao.GenericDao;

@Local
public interface UserDao extends GenericDao<User> {
	
	/**
	 * A kedvenc filmek list�j�t m�dos�tja.
	 * Ha adott felhaszn�l�hoz m�r fel volt v�ve a film, akkor t�rli, 
	 * ha nem volt felv�ve, akor felveszi.
	 * @param userName felhaszn�l�n�v
	 * @param movei film
	 * @return igaz, ha �jat vesz fel, hamis, ha kedvencet t�r�lt
	 */
	public boolean changeFavoriteMovie(String userName, Movie movie);
	
	/**
	 * Visszaadja a felhaszn�l� kedvenc filmjeit.
	 * @param userName felhaszn�l�n�v
	 * @return kedvenc filmjei
	 */
	public List<Movie> favoriteMovies(String userName);

}
