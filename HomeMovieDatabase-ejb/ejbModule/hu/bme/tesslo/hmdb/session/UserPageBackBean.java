package hu.bme.tesslo.hmdb.session;

import hu.bme.tesslo.hmdb.dao.RatingDao;
import hu.bme.tesslo.hmdb.dao.UserDao;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.Rating;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.security.Credentials;

@Name("UserPageBean")
@Scope(ScopeType.PAGE)
public class UserPageBackBean {

	@In
	Credentials credentials;

	private UserDao userDao;

	private RatingDao ratingDao;

	private List<Movie> favoriteMovies;

	private List<Rating> ownRatings;

	private static final Logger logger = Logger
			.getLogger(UserPageBackBean.class);

	@Create
	public void init() {
		this.favoriteMovies = new ArrayList<Movie>();
		this.ownRatings = new ArrayList<Rating>();

		try {
			userDao = (UserDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/UserDao/local");
			favoriteMovies = userDao.favoriteMovies(this.credentials
					.getUsername());

			ratingDao = InitialContext
					.doLookup("HomeMovieDatabase-ear/ratingDao/local");
			ownRatings = ratingDao.userRatings(this.credentials.getUsername());
		} catch (NamingException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void deleteRating(Rating rating) {
		ratingDao.deleteRating(rating);
		// try {
		// ratingDao = InitialContext
		// .doLookup("HomeMovieDatabase-ear/ratingDao/local");
		// } catch (NamingException e) {
		// logger.error(e.getMessage(), e);
		// }
		// ownRatings = ratingDao.userRatings(this.credentials.getUsername());
	}

	/**
	 * @return the favoriteMovies
	 */
	public List<Movie> getFavoriteMovies() {
		return favoriteMovies;
	}

	/**
	 * @param favoriteMovies
	 *            the favoriteMovies to set
	 */
	public void setFavoriteMovies(List<Movie> favoriteMovies) {
		this.favoriteMovies = favoriteMovies;
	}

	/**
	 * @return the ownRatings
	 */
	public List<Rating> getOwnRatings() {
		return ownRatings;
	}

	/**
	 * @param ownRatings
	 *            the ownRatings to set
	 */
	public void setOwnRatings(List<Rating> ownRatings) {
		this.ownRatings = ownRatings;
	}

}
