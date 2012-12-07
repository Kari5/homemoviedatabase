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
 * Webszolg�ltat�s, amely egy film adatait k�pes automatikusan visszaadni.
 * 
 * @author Windisch K�roly
 * 
 */
@Stateless
@WebService(name = "HMDbWebService")
public class HMDbWebService {

	private MovieDao movieDao;

	/**
	 * Filmkeres�.
	 * 
	 * @param title
	 *            c�m.
	 * @param year
	 *            �v.
	 * @return megtal�lt film, vagy egy �res film, melynek Sikertelen keres�s! a
	 *         c�me.
	 */
	@WebMethod()
	public SimpleMovie getMovie(String title, int year) {
		try {
			movieDao = (MovieDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/MovieDao/local");
		} catch (NamingException e) {
			SimpleMovie error = new SimpleMovie();
			error.setTitle("Sikertelen k�r�s!");
			return error;
		}
		System.out.println(title + " - " + year);
		Movie m = movieDao.getMovie(title, year);
		if (m == null) {
			SimpleMovie error = new SimpleMovie();
			error.setTitle("Sikertelen k�r�s!");
			return error;
		}
		System.out.println(m.getId());
		return new SimpleMovie(m);
	}
}
