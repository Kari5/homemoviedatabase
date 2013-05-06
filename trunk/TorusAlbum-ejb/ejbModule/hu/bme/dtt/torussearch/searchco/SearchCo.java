package hu.bme.dtt.torussearch.searchco;

import hu.bme.dtt.util.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jboss.logging.Logger;

public class SearchCo {
	private static final Logger LOGGER = Logger.getLogger(SearchCo.class);
	private final Search search;
	private static final String SEARC_CO_VIEW_URL = "http://searchco.de/codesearch/view/";

	public SearchCo() {
		search = new Search();
	}

	/**
	 * Search for code.
	 * 
	 * @param query
	 *            The query string.
	 * @param ext
	 *            The file extension.
	 * @param lang
	 *            The code language.
	 * @param repo
	 *            The code repository.
	 * @param url
	 *            The searched url.
	 * @return
	 */
	public List<Result> searchCode(String query, String ext, String lang, String repo, String url) {
		String fullQuery = QueryBuilder.buildQuery(query, ext, lang, repo, url);
		LOGGER.info(fullQuery);
		return executeCodeSearch(fullQuery);
	}

	private List<Result> executeCodeSearch(String query) {
		List<Result> resultList = new ArrayList<Result>();
		try {
			// LOGGER.info("SEARCHING FOR CODE");
			String resultString = search.searchCode(query, null);
			JSONObject jsonObject = new JSONObject(resultString);
			JSONArray jsonArray = new JSONArray(jsonObject.getString("results"));
			for (int i = 0; i < jsonArray.length(); i++) {
				try {
					Result result = new Result();
					JSONObject arrayObject = new JSONObject(jsonArray.getString(i));
					// LOGGER.info(arrayObject);
					result.setName(arrayObject.getString("name") + ": " + arrayObject.getString("location") + "/"
							+ arrayObject.getString("filename"));
					result.setUrl(SEARC_CO_VIEW_URL + arrayObject.getString("id"));

					String snippet = "";
					try {
						JSONObject lines = new JSONObject(arrayObject.getString("lines"));
						JSONArray names = lines.names();
						for (int j = 0; j < names.length(); j++) {
							snippet += StringEscapeUtils.escapeHtml4(names.getString(j)) + ":	"
									+ StringEscapeUtils.escapeHtml4(lines.getString(names.getString(j))) + "<br>";
						}
					} catch (JSONException e) {
						LOGGER.warn("Lines parameter is not an object!");
						JSONArray lines = new JSONArray(arrayObject.getString("lines"));
						for (int j = 0; j < lines.length(); j++) {
							snippet += StringEscapeUtils.escapeHtml4(lines.getString(j)) + "<br>";
						}
					}

					result.setSnippet(snippet);
					resultList.add(result);
				} catch (JSONException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (JSONException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return resultList;
	}
}
