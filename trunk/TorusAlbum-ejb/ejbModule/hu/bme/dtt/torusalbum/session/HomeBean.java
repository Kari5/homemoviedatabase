package hu.bme.dtt.torusalbum.session;

import hu.bme.dtt.torusalbum.dao.AlbumDao;
import hu.bme.dtt.torusalbum.dao.SearchEngineDao;
import hu.bme.dtt.torusalbum.entity.Album;
import hu.bme.dtt.torusalbum.entity.Picture;
import hu.bme.dtt.torusalbum.entity.SearchEngine;
import hu.bme.dtt.torusalbum.util.StateHolder;
import hu.bme.dtt.torusalbum.util.search.Search;
import hu.bme.dtt.torusalbum.util.search.model.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("HomeBean")
@Scope(ScopeType.EVENT)
public class HomeBean {
	private static final Logger LOGGER = Logger.getLogger(HomeBean.class);

	/**
	 * A kiválasztott album stateHoldere.
	 */
	@In(create = true)
	private StateHolder<Album> selectedAlbumStateHolder;
	
	private String searchQuery;
	private boolean imageSearch;
	
	@In(create=true)
	private StateHolder<String> resultStringStateHolder;

	/**
	 * A paraméterként megkapott albumot álítja be a kiválasztottnak.
	 * 
	 * @param album
	 */
	public String changeSelectedAlbum(Album album) {
		selectedAlbumStateHolder.setSelected(album);
		return "albumPage";
	}

	/**
	 * Léterhoz egy új, üres albumot, és elmenti
	 */
	public String addNewAlbum() {
		Album album = new Album();
		album.setPictures(new ArrayList<Picture>());
		try {
			((AlbumDao) InitialContext.doLookup("TorusAlbum-ear/AlbumDao/local")).save(album);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}

	public void testSearch() {
		try {
			SearchEngine searchEngine = ((SearchEngineDao) InitialContext
					.doLookup("TorusAlbum-ear/searchEngineDao/local"))
					.getSearchEngine("Torus");
			Search search = new Search();
			Map<String, Object> searchParams = new HashMap<String, Object>();
			String query = searchQuery;
			searchParams.put("q", URLEncoder.encode(query, "UTF-8"));
			searchParams.put("key", searchEngine.getApiKey());
			searchParams.put("cx", searchEngine.getCxKey());
			searchParams.put("alt", "json");
			//searchParams.put("userIp", "192.168.0.1");
			if(this.imageSearch){
			searchParams.put("searchType", "image");
			}
			try {
				Response executeSearch = search.executeSearch(searchParams);
				this.resultStringStateHolder.setSelected(executeSearch.toString().replaceAll("\n", "<br>"));
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
	}

	/**
	 * @return the searchQuery
	 */
	public String getSearchQuery() {
		return searchQuery;
	}

	/**
	 * @param searchQuery the searchQuery to set
	 */
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	/**
	 * @return the imageSearch
	 */
	public boolean isImageSearch() {
		return imageSearch;
	}

	/**
	 * @param imageSearch the imageSearch to set
	 */
	public void setImageSearch(boolean imageSearch) {
		this.imageSearch = imageSearch;
	}

}
