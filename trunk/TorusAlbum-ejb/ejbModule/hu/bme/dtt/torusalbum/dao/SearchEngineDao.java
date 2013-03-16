package hu.bme.dtt.torusalbum.dao;

import hu.bme.dtt.torusalbum.entity.SearchEngine;

import javax.ejb.Local;

/**
 * Interface for SearchEngine table access.
 * 
 * @author Shazak
 * 
 */
@Local
public interface SearchEngineDao {
	/**
	 * Returns the SearchEngine parameters by name.
	 * 
	 * @param name
	 *            The name of the search engine.
	 * @return The SearchEngine params.
	 */
	SearchEngine getSearchEngine(String name);
}
