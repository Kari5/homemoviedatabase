package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.User;
import hu.futurion.mt.dao.GenericDao;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserDao extends GenericDao<User> {

	/**
	 * A kedvenc filmek listáját módosítja. Ha adott felhasználóhoz már fel volt
	 * véve a film, akkor törli, ha nem volt felvéve, akor felveszi.
	 * 
	 * @param userName
	 *            felhasználónév
	 * @param movei
	 *            film
	 * @return igaz, ha újat vesz fel, hamis, ha kedvencet törölt
	 */
	public boolean changeFavoriteMovie(String userName, Movie movie);

	/**
	 * Visszaadja a felhasználó kedvenc filmjeit.
	 * 
	 * @param userName
	 *            felhasználónév
	 * @return kedvenc filmjei
	 */
	public List<Movie> favoriteMovies(String userName);

	/**
	 * Visszaadja, hogy egy adott film kedvence-e a felhasználónak.
	 * 
	 * @param userName
	 *            felhasználó neve
	 * @param m
	 *            film
	 * @return igaz, ha kedvence, hamis ha nem
	 */
	public boolean isFavoriteMovie(String userName, Movie m);

}
