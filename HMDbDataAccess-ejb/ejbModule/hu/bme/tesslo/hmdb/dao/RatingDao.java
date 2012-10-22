/**
 * 
 */
package hu.bme.tesslo.hmdb.dao;

import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.Rating;
import hu.futurion.mt.dao.GenericDao;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Karcsi
 * 
 */
@Local
public interface RatingDao extends GenericDao<Rating> {

	/**
	 * Visszaadja a felhasználó értékeléseit
	 * 
	 * @param userName
	 *            felhasználó neve
	 * @return felhasználó értékelései
	 */
	public List<Rating> userRatings(String userName);

	/**
	 * Visszaadja a felhasználó adott filmhez tartozó értékelését.
	 * 
	 * @param userName
	 * @param movie
	 * @return felhasználó értékelése
	 */
	public Rating userRatingMovie(String userName, Movie movie);

	/**
	 * Visszaadja, hogy adott filmhez van-e már értékelése a felhasználónak.
	 * 
	 * @param userName
	 *            felhasználónév
	 * @param movie
	 *            film
	 * @return igaz, ha már van értékelés, hamis ha még nincs
	 */
	public boolean ratingExist(String userName, Movie movie);

	/**
	 * Visszaadja egy filmhez tartozó értékeléseket.
	 * 
	 * @param movie
	 *            film
	 * @return film értékelései
	 */
	public List<Rating> movieRatings(Movie movie);

	/**
	 * Felhasználónév alapján kikeresi a felhasználót, és elmenti az értékelést.
	 * 
	 * @param userName
	 * @param rating
	 */
	public void saveRating(String userName, Rating rating);
}
