package hu.bme.dtt.torusalbum.util.search;

import hu.bme.dtt.torusalbum.util.search.model.Request;
import hu.bme.dtt.torusalbum.util.search.model.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.jboss.logging.Logger;

import com.google.gson.Gson;

/**
 * Object for performing search through the Google Custom Search API.
 * 
 * @author Shazak
 * 
 */
public class Search {
	/**
	 * JBoss Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(Search.class);

	/**
	 * 
	 * @param searchParams
	 *            The parameters to use for the search. (param name - param
	 *            value) The param name must be equal to the Request class field
	 *            name.
	 * @return The Response object representing the search results.
	 * @throws IllegalArgumentException
	 *             If parameter processing fails.
	 * @throws IllegalAccessException
	 *             If parameter processing fails.
	 * @throws IOException
	 *             If GET request fails.
	 */
	public Response executeSearch(Map<String, Object> searchParams)
			throws IllegalArgumentException, IllegalAccessException, IOException {
		LOGGER.debug("Initiating search!");
		Request searchRequest = new Request();
		searchRequest.setParameters(searchParams);
		LOGGER.debug("Request object: " + searchRequest);
		String requestURL = searchRequest.createRequestURL();
		LOGGER.debug("Request URL: " + requestURL);
		Response result = convertJSON(htmlGetRequest(requestURL));
		LOGGER.debug("Response object: " + result);
		return result;
	}

	/**
	 * Converts the given JSON representation to a Response object.
	 * 
	 * @param json
	 *            The JSON string.
	 * @return The Response object.
	 */
	private Response convertJSON(String json) {
		LOGGER.debug("Converting to Response object! JSON: " + json);
		Gson gson = new Gson();
		Response result = gson.fromJson(json, Response.class);
		LOGGER.debug("Conversion result: " + result);
		return result;
	}

	/**
	 * Performs a GET request to the given URL.
	 * 
	 * @param urlToRead
	 *            The target URL.
	 * @return The result of the GET request.
	 * @throws IOException
	 *             If connection fails.
	 */
	private String htmlGetRequest(String urlToRead) throws IOException {
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		url = new URL(urlToRead);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((line = rd.readLine()) != null) {
			result += line;
		}
		rd.close();
		return result;
	}
}
