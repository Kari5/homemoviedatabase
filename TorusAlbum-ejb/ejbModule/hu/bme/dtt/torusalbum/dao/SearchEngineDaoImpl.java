package hu.bme.dtt.torusalbum.dao;

import hu.bme.dtt.torusalbum.entity.SearchEngine;
import hu.futurion.mt.dao.GenericDaoImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DataAccessObject for the SearchEngine table.
 * 
 * @author Shazak
 * 
 */
@Stateless(name = "searchEngineDao")
public class SearchEngineDaoImpl extends GenericDaoImpl<SearchEngine> implements SearchEngineDao {
	/**
	 * Persistence unit.
	 */
	@PersistenceContext(unitName = "TorusAlbum")
	EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	public SearchEngine getSearchEngine(String name) {
		String query = "FROM SearchEngine as se WHERE se.engineName = ?";
		return (SearchEngine) executeQuerySingleResult(query, name);
	}

}
