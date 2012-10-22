package hu.bme.tesslo.hmdb.session;

import hu.bme.tesslo.hmdb.dao.RatingDao;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.Rating;
import hu.bme.tesslo.hmdb.util.StateHolder;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.security.Credentials;

/**
 * Értékelések megjelenítéséhez back bean.
 * 
 * @author Karcsi
 * 
 */
@Name("RatingsBackBean")
@Scope(ScopeType.PAGE)
public class RatingsBackBean {

	private RatingDao ratingDao;

	private List<Rating> ratings;

	private Rating newRating;

	@In
	Credentials credentials;

	/**
	 * Kiválasztott film stateHoldere, conversation scope-ban van.
	 * 
	 */
	@In(create = true)
	private StateHolder<Movie> selectedMovieStateHolder;

	@Create
	public void init() {
		ratings = new ArrayList<Rating>();
		newRating = new Rating();
		newRating.setMovie(selectedMovieStateHolder.getSelected());
		try {
			ratingDao = InitialContext
					.doLookup("HomeMovieDatabase-ear/ratingDao/local");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		ratings = ratingDao
				.movieRatings(selectedMovieStateHolder.getSelected());

	}

	public boolean ratingExist() {
		return ratingDao.ratingExist(credentials.getUsername(),
				selectedMovieStateHolder.getSelected());
	}

	public void saveRating() {
		ratingDao.saveRating(credentials.getUsername(), newRating);
	}

	/**
	 * @return the ratings
	 */
	public List<Rating> getRatings() {
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	/**
	 * @return the newRating
	 */
	public Rating getNewRating() {
		return newRating;
	}

	/**
	 * @param newRating
	 *            the newRating to set
	 */
	public void setNewRating(Rating newRating) {
		this.newRating = newRating;
	}

}
