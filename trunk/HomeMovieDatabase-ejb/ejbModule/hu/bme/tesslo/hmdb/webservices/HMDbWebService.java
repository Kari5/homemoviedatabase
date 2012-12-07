package hu.bme.tesslo.hmdb.webservices;

import hu.bme.tesslo.hmdb.dao.MovieDao;
import hu.bme.tesslo.hmdb.model.Movie;
import hu.bme.tesslo.hmdb.model.SimpleMovie;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Webszolgáltatás, amely egy film adatait képes automatikusan visszaadni.
 * 
 * @author Windisch Károly
 * 
 */
@Stateless
@WebService(name = "HMDbWebService")
public class HMDbWebService {

	private MovieDao movieDao;

	/**
	 * Filmkeresõ.
	 * 
	 * @param title
	 *            cím.
	 * @param year
	 *            év.
	 * @return megtalált film, vagy egy üres film, melynek Sikertelen keresés! a
	 *         címe.
	 */
	@WebMethod()
	public SimpleMovie getMovie(String title, int year) {
		try {
			movieDao = (MovieDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/MovieDao/local");
		} catch (NamingException e) {
			SimpleMovie error = new SimpleMovie();
			error.setTitle("Sikertelen kérés!");
			return error;
		}
		System.out.println(title + " - " + year);
		Movie m = movieDao.getMovie(title, year);
		if (m == null) {
			SimpleMovie error = new SimpleMovie();
			error.setTitle("Sikertelen kérés!");
			return error;
		}
		System.out.println(m.getId());
		return new SimpleMovie(m);
	}
}
