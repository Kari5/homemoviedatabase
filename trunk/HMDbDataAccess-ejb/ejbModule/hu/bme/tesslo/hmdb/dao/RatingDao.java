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
	 * Visszaadja a felhaszn�l� �rt�kel�seit
	 * 
	 * @param userName
	 *            felhaszn�l� neve
	 * @return felhaszn�l� �rt�kel�sei
	 */
	public List<Rating> userRatings(String userName);

	/**
	 * Visszaadja a felhaszn�l� adott filmhez tartoz� �rt�kel�s�t.
	 * 
	 * @param userName
	 * @param movie
	 * @return felhaszn�l� �rt�kel�se
	 */
	public Rating userRatingMovie(String userName, Movie movie);

	/**
	 * Visszaadja, hogy adott filmhez van-e m�r �rt�kel�se a felhaszn�l�nak.
	 * 
	 * @param userName
	 *            felhaszn�l�n�v
	 * @param movie
	 *            film
	 * @return igaz, ha m�r van �rt�kel�s, hamis ha m�g nincs
	 */
	public boolean ratingExist(String userName, Movie movie);

	/**
	 * Visszaadja egy filmhez tartoz� �rt�kel�seket.
	 * 
	 * @param movie
	 *            film
	 * @return film �rt�kel�sei
	 */
	public List<Rating> movieRatings(Movie movie);

	/**
	 * Felhaszn�l�n�v alapj�n kikeresi a felhaszn�l�t, �s elmenti az �rt�kel�st.
	 * 
	 * @param userName
	 * @param rating
	 */
	public void saveRating(String userName, Rating rating);
}
