package hu.bme.dtt.torussearch.googlesearch;

import hu.bme.dtt.torusalbum.dao.SearchEngineDao;
import hu.bme.dtt.torusalbum.entity.SearchEngine;
import hu.bme.dtt.torusalbum.util.search.Search;
import hu.bme.dtt.torusalbum.util.search.model.Response;
import hu.bme.dtt.torusalbum.util.search.model.item.Item;
import hu.bme.dtt.util.Result;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

public class GoogleSearch {
	private static final Logger LOGGER = Logger.getLogger(GoogleSearch.class);

	/**
	 * 
	 * @param query
	 *            The query string.
	 * @param fileType
	 *            The extension of the file type to search for.
	 * @param url
	 *            The url of the site to search on.
	 * @param lang
	 *            The code language to search for.
	 * @return
	 */
	public List<Result> executeSearch(String query, String fileType, String url, String lang) {
		List<Result> resultList = new ArrayList<Result>();
		try {
			SearchEngine searchEngine = ((SearchEngineDao) InitialContext
					.doLookup("TorusAlbum-ear/searchEngineDao/local")).getSearchEngine("Torus");
			Search search = new Search();
			Map<String, Object> searchParams = new HashMap<String, Object>();
			String searchQuery = query;
			if (lang != null) {
				query += " " + lang;
			}
			searchParams.put("q", URLEncoder.encode(searchQuery, "UTF-8"));
			searchParams.put("key", searchEngine.getApiKey());
			searchParams.put("cx", searchEngine.getCxKey());
			searchParams.put("fileType", fileType);
			searchParams.put("relatedSite", url);
			searchParams.put("alt", "json");
			try {
				Response response = search.executeSearch(searchParams);
				int i=0;
				for (Item item : response.getItems()) {
					Result result = new Result();
					result.setRelevant(true);
					result.setPosition(i);
					result.setName(item.getHtmlTitle());
					result.setUrl(item.getLink());
					result.setSnippet(item.getHtmlSnippet());
					resultList.add(result);
					i++;
				}
			} catch (IllegalArgumentException e) {
				LOGGER.error(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				LOGGER.error(e.getMessage(), e);
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		} catch (NamingException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return resultList;
	}
}
