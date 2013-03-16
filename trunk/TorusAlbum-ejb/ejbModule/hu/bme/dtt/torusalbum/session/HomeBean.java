package hu.bme.dtt.torusalbum.session;

import hu.bme.dtt.torusalbum.dao.AlbumDao;
import hu.bme.dtt.torusalbum.dao.SearchEngineDao;
import hu.bme.dtt.torusalbum.entity.Album;
import hu.bme.dtt.torusalbum.entity.Picture;
import hu.bme.dtt.torusalbum.entity.SearchEngine;
import hu.bme.dtt.torusalbum.util.StateHolder;
import hu.bme.dtt.torusalbum.util.search.Search;

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
					.getSearchEngine("Test Engine");
			Search search = new Search();
			Map<String, Object> searchParams = new HashMap<String, Object>();
			String query = "lamborghini diablo";
			searchParams.put("q", URLEncoder.encode(query, "UTF-8"));
			searchParams.put("key", searchEngine.getApiKey());
			searchParams.put("cx", searchEngine.getCxKey());
			searchParams.put("alt", "json");
			// searchParams.put("searchType", "image");
			try {
				search.executeSearch(searchParams);
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
}
