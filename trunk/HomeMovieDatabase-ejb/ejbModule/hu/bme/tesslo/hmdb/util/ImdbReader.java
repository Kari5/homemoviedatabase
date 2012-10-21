/**
 * 
 */
package hu.bme.tesslo.hmdb.util;

import hu.bme.tesslo.hmdb.model.Movie;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jboss.logging.Logger;

/**
 * @author Windisch.Karoly
 * 
 */
public class ImdbReader {

	private static final Logger logger = Logger.getLogger(ImdbReader.class);

	private static final String API_URL = "http://www.omdbapi.com/";

	private String movieName;

	private Integer movieYear;

	private String imdbID;

	private String dataUrl;

	public ImdbReader(String movieName, Integer movieYear, String imdbID) {
		super();
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.imdbID = imdbID;
		this.movieName = this.movieName.replace(" ", "+");
		logger.info("Keresendõ film: " + this.movieName + ", " + this.movieYear
				+ ", " + this.imdbID);
		if (this.imdbID != null && !this.imdbID.isEmpty()
				&& !this.imdbID.equals("null") && !this.imdbID.equals(" ")) {
			this.dataUrl = "i=" + this.imdbID;
		} else {
			this.dataUrl = "t=" + this.movieName;
			if (this.movieYear != null) {
				this.dataUrl += "&y=" + movieYear;
			}
		}
		logger.info("Összeállított URL: " + dataUrl);
	}

	/**
	 * Az összeállított url-t meghívja, és elmenti egy string-be a visszakapott
	 * adatokat.
	 * 
	 * @return A keresett film adatai JSON formátumban
	 */
	private String readRawData() {
		GetMethod get = null;
		HttpClient client = new HttpClient();
		String retData = "";
		try {
			logger.info("getMethod elõtt: " + dataUrl);
			get = new GetMethod(API_URL);
			logger.info(get.getName() + ", " + get.getPath() + ", "
					+ get.getURI());
			get.setQueryString(dataUrl);
			client.executeMethod(get);
			retData = get.getResponseBodyAsString();
			logger.info(get.getName() + ", " + get.getPath() + ", "
					+ get.getURI());
			logger.info(get.getStatusCode() + ", " + get.getStatusText());
		} catch (Exception e) {
			logger.error(
					"Kapcsolat felépítése nem sikerült! " + e.getMessage(), e);
		}
		logger.info("Visszakapott cucc: " + retData);

		try {
			if (get != null) {
				get.releaseConnection();
			}
		} catch (Exception e) {
			logger.error("Kapcsolat zárásakor hiba: " + e.getMessage(), e);
		}

		return retData;
	}

	public Movie parseJson() {
		String json = readRawData();
		Movie result = null;
		try {
			JSONObject jsonObject = new JSONObject(json);
			if (jsonObject.getString("Response").equals("False")) {
				logger.info("Nincs találat a filmre!");
				return null;
			}
			String title = jsonObject.getString("Title");
			int year = jsonObject.getInt("Year");
			String runtime = jsonObject.getString("Runtime");
			String genere = jsonObject.getString("Genre");
			String director = jsonObject.getString("Director");
			String writer = jsonObject.getString("Writer");
			String actors = jsonObject.getString("Actors");
			String plot = jsonObject.getString("Plot");
			String posterUrl = jsonObject.getString("Poster");
			Double imdbRating;
			try {
				imdbRating = jsonObject.getDouble("imdbRating");
			} catch (Exception e) {
				logger.error("imdbRating nem elérhetõ! " + e.getMessage());
				imdbRating = 0.0;
			}
			String imdbId = jsonObject.getString("imdbID");

			result = new Movie(title, year, runtime, genere, director, writer,
					actors, plot, posterUrl, imdbRating, imdbId, null, null,
					null);
		} catch (JSONException e) {
			logger.error("JSON parse error: " + e.getMessage(), e);
		}
		logger.info("Beolvasott film: " + result.toString());
		return result;

	}

}
