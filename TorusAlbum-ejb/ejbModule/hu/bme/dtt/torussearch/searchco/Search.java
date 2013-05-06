package hu.bme.dtt.torussearch.searchco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Search {
	private static final String SEARCH_CO_URL = "http://searchco.de/api";
	private static final String SEARCH_CO_DOC = "/search_IV/?";
	private static final String SEARCH_CO_CODE = "/codesearch_I/?";
	private static final String SEARCH_CO_QUERY_PARAM = "q=";
	private static final String SEARCH_CO_QUERY_PAGE_PARAM = "p=";
	
	public String searchDocumentation(final String query, final Integer page) throws IOException{
		String url = SEARCH_CO_URL+ SEARCH_CO_DOC+SEARCH_CO_QUERY_PARAM;
		if(query != null){
			url += query;
		}
		if(page != null){
			url += "&"+SEARCH_CO_QUERY_PAGE_PARAM+page;
		}
		return htmlGetRequest(url);
	}
	
	public String searchCode(final String query, final Integer page) throws IOException{
		String url = SEARCH_CO_URL+ SEARCH_CO_CODE+SEARCH_CO_QUERY_PARAM;
		if(query != null){
			url += query;
		}
		if(page != null){
			url += "&"+SEARCH_CO_QUERY_PAGE_PARAM+page;
		}
		return htmlGetRequest(url);
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
